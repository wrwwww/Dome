package Homework;

import java.awt.image.BufferedImage;

public class Bee extends Fly implements Reward{

    int speed;

    Bee() {
        speed = 2;
        super.setImage(Activity.bee);
        setY(-super.getImage().getHeight());
        setX(((int) (Math.random() * 10000) % 400));
        setHeight(super.getImage().getHeight());
        setWidth(super.getImage().getWidth());
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    @Override
    public void move() {
        setY(getY() + speed);
    }



    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void setImage(BufferedImage image) {
        setImage(image);
    }



    @Override
    public int type() {
        int i=Activity.randomNumber(5)+1;
        if (i <= 3)
            return 1;
        return 2;
    }
}
