package game;

import java.awt.*;

public class Board {


    private int high;
    private int x;
    private int y;
    private int length;
    private Color color;


    Board(){
        setColor(Color.blue);
        setX(0);
        setLength(0);
        setHigh(10);
    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public int getX() {
        return x;
    }

    public void setX(int point) {
        this.x = point;
    }

}
