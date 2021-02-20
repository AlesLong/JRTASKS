package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private EventListener eventListener;
    private View view;

    public Field(View view) {
        this.view = view;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
