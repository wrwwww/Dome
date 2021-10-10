package dome_game;

import javax.swing.*;
import java.awt.*;


public class dome01 extends JPanel {
    my_thread my;
   static int[][] ten;
    dome01(){
        ten = new int[20][2];
        for (int i = 0; i < 20; i++) {
            ten[i][0]=50;
        }
        my= new my_thread();
        my.start();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < 20; i++) {
            g.fillOval(ten[i][0],ten[i][1],9,9);
        }
    }

    public static void main(String[] args) {
      JFrame jf=new JFrame();
      JPanel jp=new dome01();;
      jf.setVisible(true);
      jf.setSize(500,300);
      jf.add(jp);

    }

     class my_thread extends Thread{
        @Override
        public void run() {
//            super.run();
            while (true){
                for (int i = 0; i < 20; i++) {
                  if (ten[i][1]!=600)
                    ten[i][1]+=5;
                  else ten[i][1]=0;
                  repaint();

                }
                try {
                    my_thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
