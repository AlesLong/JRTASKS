package com.javarush.task.task24.task2413;

public class Ball extends BaseObject {
    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        this.isFrozen = true;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }


    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }

    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    @Override
    void move() {
        if (!isFrozen) {
            x += dx;
            y += dy;
        }
    }

    void start() {
        isFrozen = false;
    }
}
