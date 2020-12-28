package com.javarush.task.task10.task1008;

/* 
Правильный ответ: d = 2.941
*/

public class Solution {
    public static void main(String[] args) {
        int a = 50;
        int b = 17;
        double d = (double) a / b;
        double c = (float) a / b;
        System.out.println(d);
        System.out.println(c);
    }
}
