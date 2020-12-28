package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        String s2 = "";
        s2 = s2 + string.substring(0, 1).toUpperCase();
        for (int i = 1; i < string.length(); i++) {
            if (" ".equals(string.substring(i - 1, i)))
                s2 = s2 + string.substring(i, i + 1).toUpperCase();
            else
                s2 = s2 + string.substring(i, i + 1);
        }
        System.out.println(s2);
    }
}
