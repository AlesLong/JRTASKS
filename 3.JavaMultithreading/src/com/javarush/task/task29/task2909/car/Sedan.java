package com.javarush.task.task29.task2909.car;

public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_CABRIOLET_SPEED = 120;
        return MAX_CABRIOLET_SPEED;
    }
}
