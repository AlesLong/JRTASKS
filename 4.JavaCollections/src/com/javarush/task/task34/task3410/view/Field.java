package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Field extends JPanel {
    private EventListener eventListener;
    private View view;

    public Field(View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        GameObjects gameObjects = view.getGameObjects();
        gameObjects.getAll().forEach(el -> el.draw(g));
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                eventListener.move(Direction.LEFT);
            } else if (key == KeyEvent.VK_RIGHT) {
                eventListener.move(Direction.RIGHT);
            } else if (key == KeyEvent.VK_UP) {
                eventListener.move(Direction.UP);
            } else if (key == KeyEvent.VK_DOWN) {
                eventListener.move(Direction.DOWN);
            } else if (key == KeyEvent.VK_R) {
                eventListener.restart();
            }
        }
    }
}
