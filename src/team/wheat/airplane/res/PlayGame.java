package team.wheat.airplane.res;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class PlayGame extends JPanel implements KeyListener {
    MainPlane p1;
    static Image background;
    ObjectPlane p2;
    int[][] object_count;
    int[] ten;
    static {
        try {
            background = ImageIO.read(new File("E:\\Dome\\src\\team\\wheat\\airplane\\res\\draw\\background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public PlayGame() throws IOException {
        p1 = new MainPlane();
        p2 =new ObjectPlane();
        object_count=new int[2][5];
        ten=new int[20];
        for (int j = 0; j < object_count[0].length; j++) {

            object_count[0][j] = randomNums(400);
            object_count[1][j] = randomNums(100)-200;

        }

        p1.setHp_value(100);
        p1.setMp_value(100);
        p1.setBasis_damage(20);
        p1.setLv(1);
        p1.setX(200);
//        p1.setY(9);
        p1.setY(600-100);
        p1.setImage("E:\\Dome\\src\\team\\wheat\\airplane\\res\\draw\\hero0.png");
        p1.setImage02("E:\\Dome\\src\\team\\wheat\\airplane\\res\\draw\\hero1.png");
        p2.setImage("E:\\Dome\\src\\team\\wheat\\airplane\\res\\draw\\airplane.png");
        p2.setY(0);
        p2.setX(randomNums(400));
        read a1=new read();
        a1.start();

    }

    public  int randomNums(int num) {
        return (int) (Math.random() * 10000) % num;
    }

    //画笔
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
        if(p1.p==0) {
            g.drawImage(p1.getImage(), p1.getX(), p1.getY(), this);
            p1.p=1;
        }else {
            g.drawImage(p1.getImage02(), p1.getX(), p1.getY(), this);
            p1.p=0;

        }
        for (int i = 0; i < object_count[0].length; i++) {
            if (object_count[1][i]>=0)
            g.drawImage(p2.getImage(), object_count[0][i], object_count[1][i], this);
        }

        g.fillOval(p1.dd.getX(),p1.dd.getY(),5,5);

    }

    class read extends Thread{
        @Override
        public void run() {
            super.run();
            //noinspection InfiniteLoopStatement
            while(true) {
                for (int i = 0; i < object_count[0].length; i++) {
                    if (object_count[1][i]<=600)
                        object_count[1][i] += 1;
                    else {
                        object_count[0][i] = randomNums(400);
//                        object_count[1][i]=0;
                        object_count[1][i] = randomNums(100)-200;

                    }

                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();

            }
        }
    }


    //键盘键盘检测事件
    @Override
    public void keyTyped(KeyEvent e) {
        char c=e.getKeyChar();
        if (c=='a') {
            p1.setX(p1.getX() - 5);
            System.out.println("这里啊啊");
        }
        else if(c=='d'){
            p1.setX(p1.getX()+5);
            System.out.println("这里啊啊");
        }
//        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
