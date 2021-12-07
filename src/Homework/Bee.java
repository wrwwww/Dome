package Homework;

import java.awt.image.BufferedImage;

public class Bee extends Fly implements Reward{
    int f ;
    int speed;
    Bee() {
        setSpeed(2);
        f = Activity.randomNumber(2);
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

    //模式
    @Override
    public void move() {
        if (getX()+getWidth()>=Activity.WIDTH||getX()<=0){
            f = f == 1 ? 0 : 1;
        }
        if (f==0){
            x+=getSpeed();
            y+=getSpeed();

        }else if (f==1){
            x-=speed;
            y+=speed;
        }

    }


    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void setImage(BufferedImage image) {
        super.setImage(image);
    }

    @Override
    public int type() {
        int i=Activity.randomNumber(5)+1;
        if (i <= 3)
            return 1;
        return 2;
    }
}
