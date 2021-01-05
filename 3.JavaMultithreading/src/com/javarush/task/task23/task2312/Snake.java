package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private SnakeDirection direction;
    private boolean isAlive;
    private List<SnakeSection> sections = new ArrayList<>();

    public Snake(int x, int y) {
        sections.add(new SnakeSection(x, y));
        isAlive = true;

    }

    public List<SnakeSection> getSections() {
        return sections;
    }


    public boolean isAlive() {
        return isAlive;
    }


    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {

    }
}
