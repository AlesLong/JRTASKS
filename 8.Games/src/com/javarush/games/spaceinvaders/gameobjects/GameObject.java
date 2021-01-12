package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.*;

public class GameObject {

    public double x;
    public double y;


    public int[][] matrix;
    public int width;
    public int height;

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
        width = matrix[0].length;
        height = matrix.length;
    }


    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Game game) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                game.setCellValueEx((int) x + i, (int) y + j, Color.values()[matrix[j][i]], "");
            }
        }
    }
}
