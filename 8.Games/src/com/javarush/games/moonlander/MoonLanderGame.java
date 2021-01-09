package com.javarush.games.moonlander;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    public final static int WIDTH = 64;
    public final static int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;


    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        createGame();
        showGrid(false);
    }

    private void createGame() {
        isLeftPressed = false;
        isUpPressed = false;
        isRightPressed = false;
        createGameObjects();
        drawScene();
        setTurnTimer(50);
    }

    private void createGameObjects() {
        rocket = new Rocket(WIDTH / 2, 0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.ALICEBLUE);
            }
        }
        rocket.draw(this);
        landscape.draw(this);
    }

    public void onTurn(int step) {
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        check();
        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x < WIDTH && x >= 0 && y < HEIGHT && y >= 0) {
            super.setCellColor(x, y, color);
        }
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.UP) {
            isUpPressed = true;
        }
        if (key == Key.LEFT) {
            isLeftPressed = true;
            isRightPressed = false;
        }
        if (key == Key.RIGHT) {
            isLeftPressed = false;
            isRightPressed = true;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.UP) {
            isUpPressed = false;
        }
        if (key == Key.LEFT) {
            isLeftPressed = false;
            isRightPressed = true;
        }
        if (key == Key.RIGHT) {
            isLeftPressed = true;
            isRightPressed = false;
        }
    }

    private void check() {

    }

    private void win() {

    }

    private void gameOver() {

    }
}
