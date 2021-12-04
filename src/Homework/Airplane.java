package Homework;

public class Airplane extends Fly implements Enemy {

    int speed;
    int score = 0;

    Airplane() {
        speed = 1;
        setImage(Activity.airplane);
        setY(-this.getImage().getHeight());
        setX(((int) (Math.random() * 10000) % 400));
        setHeight(this.getImage().getHeight());
        setWidth(this.getImage().getWidth());
        score = 5;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public void move() {
        setY(getY() + speed);
    }


    




}
