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
    private GameObject platform;
    private boolean isGameStopped;


    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        createGame();
        showGrid(false);
    }

    private void createGame() {
        isGameStopped = false;
        isLeftPressed = false;
        isUpPressed = false;
        isRightPressed = false;
        createGameObjects();
        drawScene();
        setTurnTimer(50);
    }

    private void createGameObjects() {
        platform = new GameObject(23, MoonLanderGame.HEIGHT - 1, ShapeMatrix.PLATFORM);
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
        if(key == Key.SPACE&& isGameStopped){
            createGame();
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
        if (rocket.isCollision(landscape) && !(rocket.isCollision(platform) && rocket.isStopped())) {
            gameOver();
        }
        if (rocket.isCollision(platform) && rocket.isStopped()) {
            win();
        }
    }

    private void win() {
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.GOLDENROD, "U WIN, ARMSTRONG!", Color.CORAL, 50);
        stopTurnTimer();
    }

    private void gameOver() {
        rocket.crash();
        isGameStopped = true;
        showMessageDialog(Color.GOLDENROD, "U CRASHED!", Color.CORAL, 50);
        stopTurnTimer();
    }
}
