package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        Human grandDad1 = new Human("Va", true, 50);
        Human grandMom1 = new Human("Sl", false, 45);
        Human grandDad = new Human("Vas", true, 55);
        Human grandMom = new Human("Sli", false, 50);
        Human mom = new Human("Sliva", false, 30);
        Human dad = new Human("Vasya", true, 35);
        Human children1 = new Human("Sashka", true, 15);
        dad.children.add(children1);
        mom.children.add(children1);
        Human children2 = new Human("Sashk", true, 17);
        dad.children.add(children2);
        mom.children.add(children2);
        Human children3 = new Human("Sash", false, 16);
        dad.children.add(children3);
        mom.children.add(children3);
        grandDad.children.add(mom);
        grandMom.children.add(mom);
        grandDad1.children.add(dad);
        grandMom1.children.add(dad);
        System.out.println(grandDad.toString());
        System.out.println(grandDad1.toString());
        System.out.println(grandMom.toString());
        System.out.println(grandMom1.toString());
        System.out.println(mom.toString());
        System.out.println(dad.toString());
        System.out.println(children1.toString());
        System.out.println(children2.toString());
        System.out.println(children3.toString());


    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();


        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }
}
