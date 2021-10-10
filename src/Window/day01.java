package Window;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.TargetDataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Objects;


class cdd {
//    public static void main(String[] args) {
//
//        JFrame jf=new JFrame("下雪");//设置标题
//        Image drawing = null;//软件图标
//       // JPanel jp=new cdd();//绘图容器
//        jf.setLocation(400,125);//起始位置
//        jf.setSize(500,500); //窗口默认大小
//        //初始化icon
//        try {
//            drawing = ImageIO.read(new File("G:\\02l.png"));
//        } catch (IOException e) {
////            e.printStackTrace();
//            System.out.println("icon加载失败");
//        }
//
//        jf.add(jp);//添加容器
//        jf.setIconImage(drawing);//设置icon
//        jf.setVisible(true);//软见可视化
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出软见
//
//    }
}
//重写绘图容器
public class day01 extends JPanel{
    static BufferedImage im;
    static int[] ls;
    static int[] ls2;
    my_run mt;
    static {
        try {
            im = ImageIO.read(Objects.requireNonNull(cdd.class.getResource("4.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public day01(){
        //初始化数组
        ls=new int[500];
        ls2=new int[500];
        for (int i = 0; i < 500; i++) {
            ls[i]=(int)(Math.random()*10000)%500;
            ls2[i]=(int)(Math.random()*10000)%500;
        }
//        my_run my=new my_run();
//        my.start();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        for (int i = 0; i < 1280; i+=5) {
            for (int j = 0; j < 800; j+=10) {
                g.drawLine(i,j,i+2,j);
            }
        }
        for (int i = 0; i < 1280; i+=10) {
            for (int j = 0; j < 800; j+=5) {
                g.drawLine(i,j,i+2,j);
            }
        }

//        g.drawImage(im, 0, 0, this);
        g.setColor(Color.white);
        g.drawLine(200,200,300,200);//底边直线
//        g.drawLine(200,200,200+35,200-35);//偏移量
        for (int i = 200,y=200; i <235&&y>200-35 ; i+=10,y-=10) {
            g.drawLine(i,y,i+5,y-5);
        }
//        g.drawLine(200+35,200-35,300+35,200-35);//底边直线
        for (int i = 200+35,j=200-35; i <300+35 ; i+=10) {
            g.drawLine(i,j,i+5,j);
        }
        g.drawLine(300,200,300+35,200-35);//you偏移量

        g.drawLine(200,200,200,100);//高
//        g.drawLine(200+35,200-35,200+35,100-35);//高
        for (int x1 = 200+35,y1=200-35;y1>=100-35+5 ; y1-=10) {
            g.drawLine(x1,y1,x1,y1-5);//高
        }
        g.drawLine(300,200,300,100);//高
        g.drawLine(300+35,200-35,300+35,100-35);//高
        g.drawLine(200,100,300,100);//底边直线
        g.drawLine(200,100,200+35,100-35);//偏移量
        g.drawLine(200+35,100-35,300+35,100-35);//底边直线
        g.drawLine(300,100,300+35,100-35);//偏移量
        g.setColor(Color.red);
        for (int x = 0,y=0; x < 300; x++) {
            g.drawLine(x,y,x+1,(int)Math.sin((double)(x+1)*10)*10);
            y=(int)Math.sin((double)(x+1)*10)*10;
        }
        g.drawArc(100,100,100,100,0,45);
        for (int i = 0,j=0; i <1000 ; i++) {

            g.drawArc(i,j,200,200,0,-180);
        }

        g.drawArc(100,160,100,128,0, 180);


        g.setColor(Color.black);
        for (int i = 0; i < 500; i++) {
            g.drawString("*",ls[i],ls2[i]);
        }

    }

    class my_run extends Thread{
        @SuppressWarnings("InfiniteLoopStatement")
        @Override
        public void run() {

            while(true){
                for (int i = 0; i < 500; i++) {
                    ls2[i]+=1;
                    if (i%2==0){

                        ls[i]+=1;
                    }else ls[i]--;
                    if (ls2[i]>=500){
                        ls2[i] = 0;
                    }
                    if (ls[i]>500){
                        ls[i]=0;
                    }
                }
                repaint();
                try {
                    //noinspection BusyWait
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
