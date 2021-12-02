package Homework;

import java.awt.image.BufferedImage;


public class Hero extends Fly {

    int hp;
    Bullet[] bullets;//子弹集合
    BufferedImage[] image;//英雄状态机

    Hero() {
        hp = 3;
        bullets = new Bullet[0];
        image = new BufferedImage[2];
        image[0] = Activity.hero0;
        image[1] = Activity.hero1;
        this.setWidth(image[0].getWidth());
        this.setHeight(image[0].getHeight());

    }

    //不停刷新图片
    int index = 0;//记号
    public BufferedImage getImage() {
        return image[index++ % 2];
    }

    @Override
    public boolean bang(Fly bullet) {
        return false;
    }


    int number = 1;
    Bullet[] shoot() {
        if (number == 1) {
            int len=new Bullet().getWidth();
            return new Bullet[]{new Bullet(this.x + this.image[0].getWidth() / 2 - len / 2, this.y - 20)};
        } else if (number==2) {
            int len=new Bullet().getWidth();
            return new Bullet[]{new Bullet(this.x + this.image[0].getWidth() / 4 - len / 2, this.y), new Bullet(this.x + this.image[0].getWidth() / 2 + len / 2, this.y)};
        }
        return null;
    }


    public void bulletFly() {
        for (Bullet bullet : bullets) {
            bullet.move();
        }
    }
    @Override
    public void move() {

    }
}
