package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {
    public Human getPerson(int n) {
        if (n <= KidBoy.MAX_AGE) {
            return new KidBoy();
        }
        if (n <= TeenBoy.MAX_AGE && n > KidBoy.MAX_AGE) {
            return new TeenBoy();
        } else {
            return new Man();
        }
    }
}
