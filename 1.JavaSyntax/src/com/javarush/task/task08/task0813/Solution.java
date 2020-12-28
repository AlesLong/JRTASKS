package com.javarush.task.task08.task0813;

import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
       Set<String> strings = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            strings.add("Л"+i);
        }
        return strings;
    }


    public static void main(String[] args) {
        HashSet<String> str =new HashSet<>();

    }
}
