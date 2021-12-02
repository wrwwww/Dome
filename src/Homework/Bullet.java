package Homework;


public class Bullet extends Fly {
    private int speed;

    Bullet() {
        setSpeed(5);
        image = Activity.bullet;
        setHeight(image.getHeight());
        setWidth(image.getWidth());
    }

    Bullet(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }


    @Override
    void move() {
        y -= speed;
    }




    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
