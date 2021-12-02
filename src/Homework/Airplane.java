package Homework;

public class Airplane extends Fly implements Enemy {

    int speed;
    int score = 0;

    Airplane() {
        speed = 1;
        image = Activity.airplane;
        y = -this.image.getHeight();
        x = ((int) (Math.random() * 10000) % 400);
        height = this.image.getHeight();
        width = this.image.getWidth();
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
        y += speed;
    }


    




}
