package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.removeIf(integer -> integer > 10);
        return set;
    }

    public static void main(String[] args) {
        Set<Integer> set = createSet();
        Set<Integer> set1 = removeAllNumbersGreaterThan10(set);
    }
}
