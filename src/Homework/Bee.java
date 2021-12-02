package Homework;

import java.awt.image.BufferedImage;

public class Bee extends Fly implements Reward{

    int speed;

    Bee() {
        speed = 2;
        image = Activity.bee;
        y = -this.image.getHeight();
        x = ((int) (Math.random() * 10000) % 400);
        height = this.image.getHeight();
        width = this.image.getWidth();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    @Override
    public void move() {
        y += speed;
    }



    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void setImage(BufferedImage image) {
        this.image = image;
    }



    @Override
    public int type() {
        int i=Activity.randomNumber(5)+1;
        if (i==5)
        return 1;
        return 2;
    }
}
