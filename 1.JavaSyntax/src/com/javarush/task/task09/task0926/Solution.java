package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int []> arraysNumbers = new ArrayList<>();
        int [] numbers = new int[] {1,2,3,4,5};
        arraysNumbers.add(numbers);
        arraysNumbers.add(new int[2]);
        arraysNumbers.add(new int[4]);
        arraysNumbers.add(new int[7]);
        arraysNumbers.add(new int[0]);
        return arraysNumbers;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
