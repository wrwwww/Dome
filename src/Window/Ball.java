package Window;

import javax.swing.*;
import java.awt.*;

public class Ball {
    static final int WIGHT=400;
    static final int HIGH=500;
    public static void main(String[] args) {

        JFrame jf = new JFrame("小球");
        jf.setBackground(Color.blue);
        jf.setAlwaysOnTop(true);
        jf.setSize(WIGHT,HIGH);
        jf.setLocation(300,200);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
class FistBall{
    private int x;
    private int y;
    private final int len=50;
    private Color color;
    private int speed;

    FistBall() {
        x=100;
        y=100;
        color=Color.blue;
        speed=1;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLen() {
        return len;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }



}
class MyJP extends JPanel{
    FistBall bl=new FistBall();
    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.setColor();
    }
}
class sdf extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.setColor(new Color().get);
    }
}