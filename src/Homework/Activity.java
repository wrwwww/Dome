package Homework;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.*;

import static javax.imageio.ImageIO.read;

public class Activity extends JPanel {
    public static final int STARTED = 1;//游戏开始
    public static final int PAUSED = 2;//游戏暂停
    public static final int OVER = 3;//游戏结束
    public static final int DESTROYED = 4;//游戏销毁
    static BufferedImage airplane;
    static BufferedImage bee;
    static BufferedImage bullet;
    static BufferedImage hero0;
    static BufferedImage hero1;
    static BufferedImage pause;
    static BufferedImage start;
    static BufferedImage background;
    static BufferedImage backgroundAlbee;
    static BufferedImage over;
    static int HEIGHT;
    static int WIDTH;
    private final Font font;
    private final Font font1;
    Hero hero;
    Timer time;
    Fly[] fly_list ;//敌机和奖励机的集合
    int number = 0;
    int num = 0;
    private int status=DESTROYED;//初态
    private long score;//总得分
    //图片的初始化
    static {
        try {
            airplane = read(Objects.requireNonNull(Activity.class.getResource("draw/new/object.png")));
            bee = read(Objects.requireNonNull(Activity.class.getResource("draw/bee.png")));
            bullet = read(Objects.requireNonNull(Activity.class.getResource("draw/new/bullet.png")));
            hero0 = read(Objects.requireNonNull(Activity.class.getResource("draw/new/hero2.png")));
            hero1 = read(Objects.requireNonNull(Activity.class.getResource("draw/new/hero2.png")));
            background = read(Objects.requireNonNull(Activity.class.getResource("draw/background.png")));
            backgroundAlbee = read(Objects.requireNonNull(Activity.class.getResource("draw/backgroundAlbee.jpg")));
            pause = read(Objects.requireNonNull(Activity.class.getResource("draw/pause.png")));
            start = read(Objects.requireNonNull(Activity.class.getResource("draw/start.png")));
            over = read(Objects.requireNonNull(Activity.class.getResource("draw/gameover.png")));
            HEIGHT = backgroundAlbee.getHeight();
            WIDTH = backgroundAlbee.getWidth();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void firstRun() {
        score = 0;//分数
        hero = new Hero();//创建英雄飞机
        fly_list = new Fly[0];
        hero.setX(WIDTH/2-hero.getWidth()/2);
        hero.setY(HEIGHT-hero.getHeight());
    }
    Activity() {
        firstRun();
        font = new Font("宋体", Font.BOLD, 20);
        font1 = new Font("宋体", Font.BOLD, 20);
        MouseAdapter mm = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (status == STARTED) {
                    hero.setX(e.getX() - hero.image[0].getWidth() / 2);
                    hero.setY(e.getY() - hero.image[0].getHeight() / 2);
                }
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                if (status == DESTROYED) {
                    time = new Timer(true);//让子弹飞
                    //延迟时间
                    time.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (!isGaveOver()) {
                                bulletAction();//子弹移动并添加
//                                flyAction();//敌机奖励机的移动添加
                                bangAction();//子弹碰撞fly
                                bang2Action();//hero碰撞fly
                                clearArrays();
                                clearBullet();
                            }
                            repaint();//重绘
                        }
                    }, 10, 10);
                    status = STARTED;
                } else if (status == OVER) {
                    firstRun();
                    status = DESTROYED;
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (status == STARTED) {
                    status = PAUSED;
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if (status == PAUSED) {
                    status = STARTED;
                }
            }
        };
        this.addMouseListener(mm);
        this.addMouseMotionListener(mm);
    }

   
    public static void main(String[] args) throws FileNotFoundException {
        JFrame jf = new JFrame("飞机大战");
        JPanel jp = new Activity();
        jf.add(jp);
        jf.setSize(WIDTH, HEIGHT);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static int randomNumber(int bound) {
        return (int) (Math.random() * 100000) % bound;
    }

    public void flyAction() {
        fly();
        for (Fly i : fly_list) {
            i.move();
        }
    }

    //bullets
    public void bangAction() {
        for (int i = 0; i < hero.bullets.length; i++) {
            if (bang(hero.bullets[i])) {
                hero.bullets[i] = hero.bullets[hero.bullets.length - 1];
                hero.bullets = Arrays.copyOf(hero.bullets, hero.bullets.length - 1);
            }
        }
    }

    //hero
    public void bang2Action() {
        for (int i = 0; i < fly_list.length; i++)
            bang2(hero, i);
    }
    public void bang2(Hero hero, int i) {
        if (fly_list[i].bang(hero)) {
            hero.setHp(hero.getHp() - 1);
            fly_list[i] = fly_list[fly_list.length - 1];
            fly_list = Arrays.copyOf(fly_list, fly_list.length - 1);
        }
    }

    public boolean bang(Bullet bullet) {
        int index = -1;
        for (int i = 0; i < fly_list.length; i++) {
            if (fly_list[i].bang(bullet)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            if (fly_list[index] instanceof Enemy) {
                Enemy e = (Enemy) fly_list[index];
                score += e.getScore();
            } else if (fly_list[index] instanceof Reward) {
                Reward e = (Reward) fly_list[index];
                int type = e.type();
                switch (type) {
                    case Reward.double_bullet:
                        hero.number = 2;
                        break;
                    case Reward.hp:
                        hero.setHp(hero.getHp() + 1);
                        break;
                }
            }
            fly_list[index] = fly_list[fly_list.length - 1];
            fly_list = Arrays.copyOf(fly_list, fly_list.length - 1);
            return true;
        }
        return false;
    }



    public boolean isGaveOver() {

        if (hero.getHp() <= 0) {
            status = OVER;
            time.cancel();
            return true;
        }
        return false;
    }

    public void clearArrays() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < fly_list.length; i++) {
            if (isOuter(fly_list[i])) {
                list.add(i);
            }
        }
        int a = 0;
        for (int i : list) {
            fly_list[i] = fly_list[fly_list.length - 1 - a++];
        }
        fly_list = Arrays.copyOf(fly_list, fly_list.length - list.size());
    }

    public boolean isOuter(Fly fly) {
        return fly.getY() + fly.getHeight() <= 0 || fly.getY() >= HEIGHT;
    }

    /**
     * 处理子弹数组
     * 删除数组中越界的子弹
     * 先将越界的用不越界的替换最后将原数组空间变得合适
     */
    public void clearBullet() {

        int left = 0;
        Fly[] fly = hero.bullets;
        int right = fly.length - 1;
        if (left == right) return;
        while (left <= right) {
//            如果没有碰撞就++
            while (left <= right && !isOuter(fly[left])) {
                left += 1;
            }
            //如果有碰撞，后指针找
            while (left <= right && isOuter(fly[right])) {
                right -= 1;
            }
            if (left <= right) {
                fly[left] = fly[right];
                right--;
                left++;
            }
        }
        hero.bullets = Arrays.copyOf((Bullet[]) fly, left);


//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < hero.bullets.length; i++) {
//            if (isOuter(hero.bullets[i])) {
//                list.add(i);
//            }
//        }
//        int a=0;
//        for (int i:list) {
//            hero.bullets[i] = hero.bullets[hero.bullets.length - 1 - a++];
//        }
//        hero.bullets = Arrays.copyOf(hero.bullets, hero.bullets.length - list.size());

    }

    /**
     * 子弹入库
     */
    public void bulletAction() {
        number += 1;
        if (number % 20 == 0) {
            Bullet[] tt = hero.shoot();
            Bullet[] temp = new Bullet[hero.bullets.length + tt.length];
            for (int i = 0; i < temp.length; i++) {
                if (i < hero.bullets.length) {
                    temp[i] = hero.bullets[i];
                } else temp[i] = tt[i - hero.bullets.length];
            }
            hero.bullets = temp;
        }
        hero.bulletFly();
    }

    public void fly() {
        num += 1;
        if (num % 40 == 0) {
            Fly[] temp = new Fly[fly_list.length + 1];
            System.arraycopy(fly_list, 0, temp, 0, fly_list.length);
            temp[temp.length - 1] = addAirPlane();
            fly_list = temp;
        }
    }

    public Fly addAirPlane() {
        int num = randomNumber(10) + 1;
        if (num == 5) {
            return new Bee();
        } else
            return new Airplane();
    }

    //游戏开始
    public void startGame(Graphics draw) {
        draw.drawImage(backgroundAlbee, 0, 0, null);
        draw.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);
        draw.setFont(font);
        draw.drawString("得分:" + score, 15, 15);
        draw.drawString("HP:" + hero.getHp(), 15, 45);

        for (int i1 = 0; i1 < hero.bullets.length; i1++) {
            draw.drawImage(hero.bullets[i1].getImage(), hero.bullets[i1].getX(), hero.bullets[i1].getY(), null);
        }
        for (Fly value : fly_list) {
            draw.drawImage(value.getImage(), value.getX(), value.getY(), this);
        }
        repaint();
    }

    public void pauseGame(Graphics draw) {
        draw.drawImage(pause, 0, 0, null);
    }

    public void gameOver(Graphics draw) {
        draw.drawImage(over, 0, 0, null);
        draw.setFont(font1);
        draw.setColor(Color.black);
        draw.drawString("得分:" + score, WIDTH / 2, HEIGHT / 2 + 20);
    }

    public void destroyGame(Graphics draw) {
        draw.drawImage(start, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        //绘制游戏背景
        g.drawImage(backgroundAlbee, 0, 0, null);
        //根据游戏状态绘制界面
        //游戏销毁状态
        if (status == DESTROYED) {
            destroyGame(g);
        }
        //游戏开始状态
        else if (status == STARTED) {
            startGame(g);
        }
        //游戏暂停状态
        else if (status == PAUSED) {
            pauseGame(g);
        }//游戏结束状态
        else if (status == OVER) {
            gameOver(g);
        }

    }


}
