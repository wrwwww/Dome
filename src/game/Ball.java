package game;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball {
    private int x;
    private int y;
    private int len;
    private Color color;
    private int speed;
    private int f;

    public void setLen(int len) {
        this.len = len;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }
public void move(){
        if (f==0){
            x+=speed;
            y+=speed;

        }else if (f==1){
            x-=speed;
            y+=speed;

        }else if (f==2){
            x-=speed;
            y-=speed;
        }else {
            x+=speed;
            y -= speed;
        }
}


}

class KeyGame implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("我是!!");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char f=e.getKeyChar();
        System.out.println("我是!!"+f);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char f=e.getKeyChar();
        System.out.println("我是!!"+f);

    }
}