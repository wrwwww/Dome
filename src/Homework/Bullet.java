package Homework;

import java.awt.image.BufferedImage;

public class Bullet extends Fly {
    private int speed;
    static BufferedImage image = Activity.bullet;
    ;

    Bullet() {
        speed = 5;

    }

    Bullet(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }


    @Override
    void air() {
        y -= speed;
    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
