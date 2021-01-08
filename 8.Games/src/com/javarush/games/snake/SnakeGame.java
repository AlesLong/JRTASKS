package com.javarush.games.snake;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    private static final int GOAL = 28;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);

        createGame();
    }

    private void createGame() {
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        isGameStopped = false;
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);

    }

    private void createNewApple() {
        apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(WIDTH));
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.AQUA, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    public void onTurn(int step) {
        snake.move(apple);
        if (snake.getLength() > GOAL) {
            win();
        }
        if (!snake.isAlive) {
            gameOver();
        }
        if (!apple.isAlive) {
            createNewApple();
        }
        drawScene();
    }

    public void onKeyPress(Key key) {
        if (key.equals(Key.LEFT)) {
            snake.setDirection(Direction.LEFT);
        }
        if (key.equals(Key.RIGHT)) {
            snake.setDirection(Direction.RIGHT);
        }
        if (key.equals(Key.UP)) {
            snake.setDirection(Direction.UP);
        }
        if (key.equals(Key.DOWN)) {
            snake.setDirection(Direction.DOWN);
        }
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.GOLDENROD, "U Win, genius", Color.CORAL, 25);
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.GOLDENROD, "U Lose, try again", Color.CORAL, 25);
    }
}

