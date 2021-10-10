package Homework;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.IntStream;

import static javax.imageio.ImageIO.read;

public class Activity extends JPanel {
    static BufferedImage airplane;
    static BufferedImage bee;
    static BufferedImage bullet;
    static BufferedImage hero0;
    static BufferedImage hero1;
    static BufferedImage pause;
    static BufferedImage start;
    static BufferedImage background;
    static BufferedImage backgroundAlbee;
    static BufferedImage gameover;
    static int HEIGHT;
    static int WIDTH;
    public static final int STATUS_GAME_STARTED = 1;//游戏开始
    public static final int STATUS_GAME_PAUSED = 2;//游戏暂停
    public static final int STATUS_GAME_OVER = 3;//游戏结束
    public static final int STATUS_GAME_DESTROYED = 4;//游戏销毁
    private int status;//初始为销毁状态
    private long score=0;//总得分
    private float fontSize ;//默认的字体大小，用于绘制左上角的文
    private float fontSize2;//用于在Game Over的时候绘制Dialog中的文本本
    private float borderSize;//Game Over的Dialog的边框
    private Font font;
    private Font font1;
    private Hero hero;
    static Key t1;
    static Mouse t2;
    Timer time;
    TimerTask task;

    //图片的初始化
    static {
        try {
            airplane = read(Objects.requireNonNull(Activity.class.getResource("draw/airplane.png")));
            bee = read(Objects.requireNonNull(Activity.class.getResource("draw/bee.png")));
            bullet = read(Objects.requireNonNull(Activity.class.getResource("draw/bullet.png")));
            hero0 = read(Objects.requireNonNull(Activity.class.getResource("draw/hero0.png")));
            hero1 = read(Objects.requireNonNull(Activity.class.getResource("draw/hero1.png")));
            background = read(Objects.requireNonNull(Activity.class.getResource("draw/background.png")));
            backgroundAlbee = read(Objects.requireNonNull(Activity.class.getResource("draw/backgroundAlbee.jpg")));
            pause = read(Objects.requireNonNull(Activity.class.getResource("draw/pause.png")));
            start = read(Objects.requireNonNull(Activity.class.getResource("draw/start.png")));
            gameover = read(Objects.requireNonNull(Activity.class.getResource("draw/gameover.png")));
            HEIGHT = background.getHeight();
            WIDTH = background.getWidth();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    Activity() throws FileNotFoundException, JavaLayerException {
        score = 0;//分数
        fontSize = 12;//小的字体
        fontSize2 = 20;//大的字体
        hero = new Hero();//创建英雄飞机
        hero.image = hero0;//设置英雄机的图片
        hero.setX(200);//英雄机的初始位置
        hero.setY(400);
        time = new Timer(true);//让子弹飞
        t1 = new Key();//监听键盘
        t2 = new Mouse();//监听键盘
        status = STATUS_GAME_DESTROYED;//游戏模式
        font = new Font("宋体", Font.BOLD, (int) fontSize2);
        font1 = new Font("宋体", Font.BOLD, (int) fontSize);
        //让子弹飞
        task = new TimerTask() {
            @Override
            public void run() {
                bulletArrays();
                hero.bulletFly();
                repaint();
            }
        };
        //延迟时间
        playMusic music = new playMusic();
        music.start();

    }

    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
        JFrame jf = new JFrame("飞机大战");
        JPanel jp = new Activity();
        jf.addKeyListener(t1);
        jf.addMouseListener(t2);
        jf.add(jp);
        jf.setSize(WIDTH, HEIGHT);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    //子弹集合
    int number=0;
    void bulletArrays() {
        number++;
        if (number % 20 == 0) {
            Bullet[] tt = hero.shoot();
            Bullet[] temp = new Bullet[hero.daDan.length + tt.length];
            for (int i = 0; i < temp.length; i++) {
                if (i < hero.daDan.length) {
                    temp[i] = hero.daDan[i];
                } else temp[i] = tt[i - hero.daDan.length];
            }
            hero.daDan = temp;
        }
    }

    //游戏开始
    public void startGame(Graphics draw) {
        draw.drawImage(background, 0, 0, this);
        draw.drawImage(hero.image, hero.getX(), hero.getY(), this);
        draw.drawString("得分:" + score, 10, 10);
        IntStream.range(0, hero.daDan.length).forEach(i -> draw.drawImage(Bullet.image, hero.daDan[i].x, hero.daDan[i].y, this));

    }

    public void pauseGame(Graphics draw) {
        draw.drawImage(pause, 0, 0, this);
    }

    public void gameOver(Graphics draw) {
        draw.drawImage(gameover, 0, 0, null);
        draw.setFont(font1);
        draw.setColor(Color.black);
        draw.drawString("得分:" + score, WIDTH / 2, HEIGHT / 2 + 20);
    }

    public void destroyGame(Graphics draw) {
        Color color=draw.getColor();
        draw.setColor(Color.black);
        draw.setFont(font);
        draw.drawRect(WIDTH / 2, HEIGHT / 2 - 30, 100, 50);
        draw.drawString("点击开始", WIDTH / 2, HEIGHT / 2);
        draw.setColor(color);
    }

    static class playMusic extends Thread {
        private Player player;
        playMusic() throws FileNotFoundException, JavaLayerException {
            File file = new File("C:\\Users\\wrw\\Desktop\\audio\\battle\\music\\battle_bk0.mp3");
            FileInputStream in = new FileInputStream(file);
            BufferedInputStream music = new BufferedInputStream(in);
            player = null;
            player = new Player(music);
        }

        @Override
        public void run() {
            try {
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    public void paint(Graphics g) {

        super.paint(g);
        //绘制游戏背景
        g.drawImage(background, 0, 0, null);
        //根据游戏状态绘制界面

        //游戏销毁状态
        if (status == STATUS_GAME_DESTROYED) {
            destroyGame(g);
        }
        //游戏开始状态
        else if (status == STATUS_GAME_STARTED) {
            startGame(g);
        }
        //游戏暂停状态
        else if (status == STATUS_GAME_PAUSED) {
            pauseGame(g);
        }//游戏结束状态
        else if (status == STATUS_GAME_OVER) {
            gameOver(g);
        }

    }

    //键盘监听类
    class Key implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (c == 'a') {
                hero.setX(hero.getX() - 5);
            } else if (c == 'd') {
                hero.setX(hero.getX() + 5);

            } else if (c == 'w') {
                hero.setY(hero.getY() - 5);
            } else if (c == 's') {
                hero.setY(hero.getY() + 5);
            }
            e.consume();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            char c = e.getKeyChar();
            if (c == 'a') {
                hero.setX(hero.getX() - 3);

            } else if (c == 'd') {
                hero.setX(hero.getX() + 3);

            }
            e.consume();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    class Mouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if (status == STATUS_GAME_DESTROYED)
                if (x >= WIDTH / 2 && x <= (WIDTH / 2)+ 100 && y >= (HEIGHT / 2) - 30 && y <= (HEIGHT / 2) + 20) {
                    status = STATUS_GAME_STARTED;
                    time.schedule(task, 5, 5);
                }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
