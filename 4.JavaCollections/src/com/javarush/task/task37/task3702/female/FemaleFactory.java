package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.Human;
import com.javarush.task.task37.task3702.male.KidBoy;
import com.javarush.task.task37.task3702.male.Man;
import com.javarush.task.task37.task3702.male.TeenBoy;

public class FemaleFactory {
    public Human getPerson(int n) {
        if (n <= KidGirl.MAX_AGE) {
            return new KidGirl();
        }
        if (n <= TeenGirl.MAX_AGE && n > KidGirl.MAX_AGE) {
            return new TeenGirl();
        } else {
            return new Woman();
        }
    }
}
