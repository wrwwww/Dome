package Homework;


public class Bullet extends Fly {
    private int speed;

    Bullet() {
        setSpeed(8);
        setImage(Activity.bullet);
        setHeight(getImage().getHeight());
        setWidth(getImage().getWidth());
    }

    Bullet(int x, int y) {
        this();
        this.setX(x);
        this.setY(y);
    }


    @Override
    void move() {
        setY(getY() - getSpeed());
    }




    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
