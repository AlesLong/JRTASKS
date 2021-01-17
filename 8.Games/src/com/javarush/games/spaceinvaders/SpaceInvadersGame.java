package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.*;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;
    private static final int PLAYER_BULLETS_MAX = 1;

    private int animationsCount;

    private boolean isGameStopped;

    private List<Star> stars;
    private List<Bullet> enemyBullets;
    private List<Bullet> playerBullets;

    private EnemyFleet enemyFleet;

    private PlayerShip playerShip;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        animationsCount = 0;
        isGameStopped = false;
        playerBullets = new ArrayList<>();
        enemyBullets = new ArrayList<>();
        enemyFleet = new EnemyFleet();
        playerShip = new PlayerShip();
        createStars();
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        for (Bullet bullet : playerBullets) {
            bullet.draw(this);
        }
        enemyFleet.draw(this);
        playerShip.draw(this);
        for (Bullet bullet : enemyBullets) {
            bullet.draw(this);
        }
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for (Star star : stars) {
            star.draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            stars.add(new Star(Math.random() * WIDTH, Math.random() * HEIGHT));
        }
    }

    private void moveSpaceObjects() {
        playerShip.move();
        enemyFleet.move();
        enemyBullets.forEach(Bullet::move);
        playerBullets.forEach(Bullet::move);
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();

        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) {
            enemyBullets.add(bullet);
        }

        drawScene();
    }

    private void removeDeadBullets() {
        enemyBullets.removeIf(bullet -> !bullet.isAlive || bullet.y >= HEIGHT - 1);
        playerBullets.removeIf(bullet -> !bullet.isAlive || (bullet.y + bullet.height) < 0);
    }

    private void check() {
        if (!playerShip.isAlive) {
            stopGameWithDelay();
        }
        enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        playerShip.verifyHit(enemyBullets);
        removeDeadBullets();
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) {
            showMessageDialog(Color.BLACK, "Nice shots!", Color.GREEN, 25);
        }
        if (!isWin) {
            showMessageDialog(Color.BLACK, "Death star", Color.RED, 25);
        }
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) {
            stopGame(playerShip.isAlive);
        }
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) {
            createGame();
        }
        if (key == Key.LEFT) {
            playerShip.setDirection(Direction.LEFT);
        }
        if (key == Key.RIGHT) {
            playerShip.setDirection(Direction.RIGHT);
        }
        if (key == Key.SPACE) {
            Bullet playerBullet = playerShip.fire();
            if (playerBullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                playerBullets.add(playerBullet);
            }
        }


    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) {
            playerShip.setDirection(Direction.UP);
        }
        if (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) {
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (!(x >= WIDTH || y >= HEIGHT || x <= 0 || y <= 0)) {
            super.setCellValueEx(x, y, cellColor, value);
        }

    }
}
