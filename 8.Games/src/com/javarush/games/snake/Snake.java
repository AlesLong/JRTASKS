package com.javarush.games.snake;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake extends GameObject {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;

    public void setDirection(Direction direction) {
        if ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) && snakeParts.get(0).x == snakeParts.get(1).x) {
            return;
        }
        if ((this.direction == Direction.UP || this.direction == Direction.DOWN) && snakeParts.get(0).y == snakeParts.get(1).y) {
            return;
        }

        if (direction == Direction.UP && this.direction == Direction.DOWN) {
            return;
        } else if (direction == Direction.LEFT && this.direction == Direction.RIGHT) {
            return;
        } else if (direction == Direction.RIGHT && this.direction == Direction.LEFT) {
            return;
        } else if (direction == Direction.DOWN && this.direction == Direction.UP) {
            return;
        }

        this.direction = direction;
        //  if ((direction == Direction.UP && this.direction != Direction.DOWN)
        //          || (direction == Direction.DOWN && this.direction != Direction.UP)
        //          || (direction == Direction.LEFT && this.direction != Direction.RIGHT)
        //          || direction == Direction.RIGHT && this.direction != Direction.LEFT) {
        //      this.direction = direction;
        //  }
    }

    private Direction direction = Direction.LEFT;


    public Snake(int x, int y) {
        super(x, y);
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        if (isAlive) {
            game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, Color.BLUEVIOLET, 75);
            for (int i = 1; i < snakeParts.size(); i++) {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.BLUEVIOLET, 75);
            }
        } else {
            game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, Color.RED, 75);
            for (int i = 1; i < snakeParts.size(); i++) {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.RED, 75);
            }
        }
    }

    public void move(Apple apple) {
        GameObject creatHead = createNewHead();
        if (checkCollision(creatHead)) {
            isAlive = false;
            return;
        }
        if (apple.x == creatHead.x && apple.y == creatHead.y) {
            apple.isAlive = false;
            snakeParts.add(0, creatHead);

        }
        if (creatHead.x >= SnakeGame.WIDTH || creatHead.y >= SnakeGame.HEIGHT || creatHead.x < 0 || creatHead.y < 0) {
            isAlive = false;
            return;
        }
        if (!(apple.x == creatHead.x && apple.y == creatHead.y)) {
            snakeParts.add(0, creatHead);
            removeTail();
        }

    }

    public GameObject createNewHead() {
        if (direction == Direction.LEFT) {
            return new GameObject(snakeParts.get(0).x - 1, snakeParts.get(0).y);
        }
        if (direction == Direction.RIGHT) {
            return new GameObject(snakeParts.get(0).x + 1, snakeParts.get(0).y);
        }
        if (direction == Direction.UP) {
            return new GameObject(snakeParts.get(0).x, snakeParts.get(0).y - 1);
        } else {
            return new GameObject(snakeParts.get(0).x, snakeParts.get(0).y + 1);
        }
    }

    public boolean checkCollision(GameObject gameObject) {
        for (int i = 0; i < snakeParts.size(); i++) {
            if (gameObject.x == snakeParts.get(i).x && gameObject.y == snakeParts.get(i).y) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }
}

