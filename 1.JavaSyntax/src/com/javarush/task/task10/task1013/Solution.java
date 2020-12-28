package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String surname;
        private int age;
        private int height;
        private int weight;
        private String education;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Human(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        public Human(String name, String surname, int age, int height) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.height = height;
        }

        public Human(String name, String surname, int age, int height, int weight) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public Human(int height, int weight, String education) {
            this.height = height;
            this.weight = weight;
            this.education = education;
        }

        public Human(String name, int age, int height, int weight, String education) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.education = education;
        }

        public Human(String name, int age, int height, String education) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.education = education;
        }
    }
}
