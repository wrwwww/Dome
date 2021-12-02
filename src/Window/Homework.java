package Window;

import javax.swing.*;
import java.awt.*;

public class Homework extends JPanel implements Runnable{
    public static void main(String[] args) {
        JFrame jf = new JFrame("作业");
        JPanel jp=new Homework();
        jf.add(jp);
        jf.setSize(800,400);
        jf.setLocation(300,200);
        //Thread my_thread=new Thread((Runnable) jp,"主界面");
//        my_thread.start();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(0, 204,255));
        g.fillOval(100,100,100,100);
        g.setColor(Color.black);
        g.fillOval(120,115,25,35);
        g.fillOval(155,115,25,35);
        g.setColor(Color.white);
        g.fillOval(128,130,7,10);
        g.fillOval(166,130,7,10);
        g.setColor(Color.white);
        //画一个圆
        g.fillOval(111,158,78,40);
        g.setColor(Color.red);
        g.fillOval(135,145,35,35);//鼻子
        g.setColor(Color.white);
        g.fillOval(150,150,5,8);
        g.setColor(Color.black);
        g.drawArc(145,185,30,20,45, 135);

        g.drawArc(200,200,30,60,0, 180);

    }

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName());
//            repaint();
        }
    }
}
