package team.wheat.airplane.res;

import game.Ball;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Plane {
    private int x;
    private int y;
    private int width;
    private int high;
    private int Hp_value;//血条
    private int Mp_value;//蓝条
    private int lv;//等级
    private int basis_damage;//基础伤害
    private Image image;//飞机图片

    Plane(){


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
        return image.getWidth(null);
    }







    public int getHp_value() {
        return Hp_value;
    }

    public void setHp_value(int hp_value) {
        Hp_value = hp_value;
    }

    public int getMp_value() {
        return Mp_value;
    }

    public void setMp_value(int mp_value) {
        Mp_value = mp_value;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public int getBasis_damage() {
        return basis_damage;
    }

    public void setBasis_damage(int basis_damage) {
        this.basis_damage = basis_damage;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(String image) throws IOException {
        this.image = ImageIO.read(new File(image));
    }




}

class MainPlane extends Plane {
    Bullet dd;
    private Image image02;//飞机图片2
    Ball ball;
    int p;

    MainPlane() {
        super();
        dd=new Bullet();
        shoot();
        p=0;
    }

    public Image getImage02() {
        return image02;
    }

    public void setImage02(String plane) throws IOException {
        super.setImage(plane);
    }

    void shoot() {
        this.dd.setX(getX());
        this.dd.setY(getY());
    }
}
class ObjectPlane extends Plane{

    ObjectPlane(){
          super();
    }
}
class Bullet{
    private int input;
    private int x;
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }


    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

}
