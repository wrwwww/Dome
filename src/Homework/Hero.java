package Homework;

import java.awt.image.BufferedImage;

public class Hero extends Fly {
    int number = 1;
    Bullet[] daDan;
    BufferedImage image;

    Hero() {
        daDan = new Bullet[0];
        image = Activity.hero0;
    }

    @Override
    void air() {

    }

    Bullet[] shoot() {
        if (number == 1) {
            return new Bullet[]{new Bullet(this.x + this.image.getWidth() / 2 - Bullet.image.getWidth() / 2, this.y - 20)};
        } else {
            return new Bullet[]{new Bullet(this.x, this.y), new Bullet(this.x, this.y)};
        }
    }

    void bulletFly(){
        for (int i = 0; i < daDan.length; i++) {
            daDan[i].air();
        }
    }
}
