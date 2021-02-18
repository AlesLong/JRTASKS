package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
        this.height = 2;
        this.width = 2;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);

        int xc = getX();
        int yc = getY();
        int height = getHeight();
        int width = getWidth();

        graphics.fillOval(xc - width / 2, yc - height / 2, width, height);
    }
}
