package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private SnakeDirection direction;
    private boolean isAlive;
    private List<SnakeSection> sections = new ArrayList<>();

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


}
