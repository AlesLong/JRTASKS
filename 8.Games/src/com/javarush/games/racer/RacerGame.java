package com.javarush.games.racer;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.*;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;

    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        drawScene();
    }

    private void drawScene() {
        drawField();
    }

    private void drawField() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; ROADSIDE_WIDTH <= j; j++) {
                setCellColor(j, i, Color.DIMGRAY);
            }
            for (int x = ROADSIDE_WIDTH; x <= WIDTH - ROADSIDE_WIDTH; x++) {
                setCellColor(x, i, Color.DIMGRAY);

            }
            for (int a = 0; 0 <= a && a < ROADSIDE_WIDTH; a++) {
                setCellColor(a, i, Color.GREEN);
            }
            for (int b = WIDTH - ROADSIDE_WIDTH; b < WIDTH; b++) {
                setCellColor(b, i, Color.GREEN);
            }
            setCellColor(CENTER_X, i, Color.WHITE);
        }
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (0 <= x && x < WIDTH && 0 <= y && y < WIDTH) {
            super.setCellColor(x, y, color);
        }
    }
}
