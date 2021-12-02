package Homework;

import java.awt.image.BufferedImage;

public abstract class Fly {
    int x;
    int y;
    int width;
    int height;
    BufferedImage image;

    abstract void move();

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public boolean bang(Fly fly){
        return fly.getX() >= x - fly.getWidth() &&
                fly.getY() >= y - fly.getHeight() &&
                fly.getX() <= x + this.getWidth() &&
                fly.getY() <= y + this.getHeight();
    }

}
