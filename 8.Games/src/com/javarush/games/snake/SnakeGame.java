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
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);

        createGame();
    }

    private void createGame() {
        score = 0;
        setScore(score);
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        isGameStopped = false;
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);

    }

    private void createNewApple() {
        Apple newApple;
        do {
            int x = getRandomNumber(WIDTH);
            int y = getRandomNumber(HEIGHT);
            newApple = new Apple(x, y);
        } while (snake.checkCollision(newApple));
        apple = newApple;
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.BLACK, "");
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
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        drawScene();
    }

    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) {
            createGame();
        }

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
        showMessageDialog(Color.GOLDENROD, "U Lose Paprika, try again", Color.CORAL, 25);
    }
}

