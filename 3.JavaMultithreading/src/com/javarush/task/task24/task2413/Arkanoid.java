package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    static Arkanoid game = new Arkanoid(500, 500);

    private int width;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    void run() {

    }

    void move() {
        
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int height;

    public static void main(String[] args) {

    }
}
