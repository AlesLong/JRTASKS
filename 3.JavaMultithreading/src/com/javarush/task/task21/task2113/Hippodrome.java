package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    void run() {

    }

    void move() {

    }

    void print() {
        
    }


    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Cloudy", 3.0, 0.0));
        horses.add(new Horse("Snowy", 3.0, 0.0));
        horses.add(new Horse("Blacky", 3.0, 0.0));
        Hippodrome.game = new Hippodrome(horses);
    }
}
