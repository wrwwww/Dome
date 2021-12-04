package Homework;

import java.awt.image.BufferedImage;

public abstract class Fly {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected BufferedImage image;

    abstract void move();

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.setWidth(image.getWidth());
        this.setHeight(image.getHeight());
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


    public boolean bang(Fly fly) {
        return fly.getX() >= getX() - fly.getWidth() &&
                fly.getY() >= getY() - fly.getHeight() &&
                fly.getX() <= getX() + this.getWidth() &&
                fly.getY() <= getY() + this.getHeight();
    }

}
