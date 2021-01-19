package com.javarush.task.task22.task2213;

public class Tetris {
    static Tetris game;

    private Field field;
    private Figure figure;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }



    public void run() {

    }

    public void step() {

    }


    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }
}
