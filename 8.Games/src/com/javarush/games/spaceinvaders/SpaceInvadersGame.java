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

    private int animationsCount;

    private boolean isGameStopped;

    private List<Star> stars;
    private List<Bullet> enemyBullets;

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
        enemyBullets = new ArrayList<>();
        enemyFleet = new EnemyFleet();
        playerShip = new PlayerShip();
        createStars();
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
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
        enemyFleet.move();
        enemyBullets.forEach(Bullet::move);
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
    }

    private void check() {
        if(!playerShip.isAlive){
            stopGameWithDelay();
        }
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
        if(animationsCount>=10){
            stopGame(playerShip.isAlive);
        }
    }
}
