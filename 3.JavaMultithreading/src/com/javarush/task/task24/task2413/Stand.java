package com.javarush.task.task24.task2413;

public class Stand extends BaseObject {
    private double speed;
    private double direction;

    public double getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }


    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    @Override
    void draw(Canvas canvas) {

    }

    @Override
    void move() {
        x += direction * speed;
    }

    void moveLeft() {
        direction = -1;
    }

    void moveRight() {
        direction = 1;
    }
}
