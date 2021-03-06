package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.*;
import java.util.stream.Collectors;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;

    private Direction direction = Direction.RIGHT;

    private List<EnemyShip> ships;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<>();
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
        for (int i = 0; i < COLUMNS_COUNT; i++) {
            for (int j = 0; j < ROWS_COUNT; j++) {
                ships.add(new EnemyShip(i * STEP, j * STEP + 12));
            }
        }
    }

    public void draw(Game game) {
        ships.forEach(enemyShip -> enemyShip.draw(game));
    }

    private double getLeftBorder() {
        double left = SpaceInvadersGame.WIDTH;
        for (GameObject ship : ships) {
            if (ship.x < left) {
                left = ship.x;
            }
        }
        return left;
    }

    private double getRightBorder() {
        double right = 0;
        for (GameObject ship : ships) {
            if (ship.x + ship.width > right) {
                right = ship.x + ship.width;
            }
        }
        return right;
    }

    private double getSpeed() {
        return Math.min(2.0, 3.0 / ships.size());
    }

    public void move() {
        if (!ships.isEmpty()) {
            if (direction == Direction.LEFT && getLeftBorder() < 0) {
                direction = Direction.RIGHT;
                ships.forEach(enemyShip -> enemyShip.move(Direction.DOWN, getSpeed()));
            }
            if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
                direction = Direction.LEFT;
                ships.forEach(enemyShip -> enemyShip.move(Direction.DOWN, getSpeed()));
            }
            ships.forEach(enemyShip -> enemyShip.move(direction, getSpeed()));
        }
    }

    public Bullet fire(Game game) {
        if (ships.isEmpty()) {
            return null;
        }
        if (game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) > 0) {
            return null;
        }
        return ships.get(game.getRandomNumber(ships.size())).fire();
    }

    // public void verifyHit(List<Bullet> bullets) {
    //     for (Bullet bullet : bullets) {
    //         for (Ship ship : ships) {
    //             if (bullet.isCollision(ship) && bullet.isAlive && ship.isAlive) {
    //                 bullet.kill();
    //                 ship.kill();
    //             }
    //         }
    //     }
    // }

    public void deleteHiddenShips() {
        ships.removeIf(enemyShip -> !enemyShip.isVisible());
    }

    public double getBottomBorder() {
        try {
            if (ships != null && !ships.isEmpty()) {
                double max = ships.get(0).y + ships.get(0).height;
                for (EnemyShip enemyShip : ships) {
                    if (enemyShip.y + enemyShip.height > max)
                        max = enemyShip.y + enemyShip.height;
                }
                return max;
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public int getShipsCount() {
        return ships.size();
    }

    public int verifyHit(List<Bullet> bullets) {
        int score = 0;
        for (Bullet bullet : bullets) {
            for (EnemyShip ship : ships) {
                if (ship.isAlive && bullet.isAlive && ship.isCollision(bullet)) {
                    ship.kill();
                    bullet.kill();
                    score += ship.score;
                }
            }
        }
        return score;
    }
}

