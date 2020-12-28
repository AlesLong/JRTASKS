package com.javarush.games.game2048;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.*;
import javafx.geometry.Side;

import java.util.Arrays;
import java.util.Random;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();

    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        setScore(score = 0);
        createNewNumber();
        createNewNumber();

    }

    private void drawScene() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellColoredNumber(i, j, gameField[j][i]);
            }
        }
    }

    private void createNewNumber() {
        int x, y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[y][x] != 0);

        if (getRandomNumber(10) == 9) {
            gameField[y][x] = 4;
        } else {
            gameField[y][x] = 2;
        }
        if (getMaxTileValue() == 2048) {
            win();
        }
    }

    private Color getColorByValue(int value) {
        if (value == 0) {
            return Color.BLUE;
        } else if (value == 2) {
            return Color.ALICEBLUE;
        } else if (value == 4) {
            return Color.ANTIQUEWHITE;
        } else if (value == 8) {
            return Color.AQUA;
        } else if (value == 16) {
            return Color.AQUAMARINE;
        } else if (value == 32) {
            return Color.AZURE;
        } else if (value == 64) {
            return Color.BEIGE;
        } else if (value == 128) {
            return Color.BISQUE;
        } else if (value == 256) {
            return Color.CHARTREUSE;
        } else if (value == 512) {
            return Color.BLANCHEDALMOND;
        } else if (value == 1024) {
            return Color.BLUEVIOLET;
        } else {
            return Color.CHOCOLATE;
        }
    }

    private void setCellColoredNumber(int x, int y, int value) {

        Color colorByValue = getColorByValue(value);
        String cellValue = String.valueOf(value);
        if (value == 0) {
            cellValue = "";
        }
        setCellValueEx(x, y, colorByValue, cellValue);
    }

    private boolean compressRow(int[] row) {
        boolean changes = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0 && i < row.length - 1 && row[i + 1] != 0) {
                int temp = row[i];
                row[i] = row[i + 1];
                row[i + 1] = temp;
                i = -1;
                changes = true;
            }
        }
        return changes;
    }

    private boolean mergeRow(int[] row) {
        boolean changes = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0 && i + 1 < row.length && row[i] == row[i + 1]) {
                row[i] *= 2;
                score += row[i];
                setScore(score);
                row[i + 1] = 0;
                changes = true;
            }
        }
        return changes;
    }

    @Override
    public void onKeyPress(Key key) {

        if (isGameStopped && key == Key.SPACE) {
            isGameStopped = false;
            createGame();
            drawScene();
            return;
        }
        if (isGameStopped && key != Key.SPACE) {
            return;
        }

        if (canUserMove() == false) {
            gameOver();
            return;
        }
        if (key == Key.LEFT) {
            moveLeft();
        }
        if (key == Key.RIGHT) {
            moveRight();
        }
        if (key == Key.UP) {
            moveUp();
        }
        if (key == Key.DOWN) {
            moveDown();
        }
        drawScene();
    }

    private void moveLeft() {
        int count = 0;
        for (int i = 0; i < gameField.length; i++) {
            if (compressRow(gameField[i])) {
                count++;
            }
            if (mergeRow(gameField[i])) {
                count++;
                compressRow(gameField[i]);
            }
        }
        if (count > 0) {
            createNewNumber();
        }
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();

    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int n = SIDE;
        int[][] newField = new int[n][n];
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = gameField[i][j];
                newField[i][j] = gameField[n - j - 1][i];
                newField[n - j - 1][i] = gameField[n - i - 1][n - j - 1];
                newField[n - i - 1][n - j - 1] = gameField[j][n - i - 1];
                newField[j][n - i - 1] = tmp;

            }
        }
        gameField = newField;
    }

    private int getMaxTileValue() {

        int result = Integer.MIN_VALUE;

        for (int[] i : gameField) {
            for (int j : i)
                result = Math.max(result, j);
        }

        return result;
    }


    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.BLANCHEDALMOND, "You win! Congratz", getColorByValue(56), 20);
    }

    private boolean isGameStopped = false;

    private boolean canUserMove() {

        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {

                if (gameField[x][y] == 0) {
                    return true;
                }

                if (x < SIDE - 1) {
                    if (gameField[x][y] == gameField[x + 1][y]) {
                        return true;
                    }
                }

                if (y < SIDE - 1) {
                    if (gameField[x][y] == gameField[x][y + 1]) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BROWN, "You loooose, loser!", getColorByValue(13), 30);
    }

    private int score = 0;

}

