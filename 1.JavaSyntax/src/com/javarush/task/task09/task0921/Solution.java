package com.javarush.task.task09.task0921;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        try {while(true){
            numbers.add(sc.nextInt());
        }

        }catch (Exception e){
            for (int i = 0; i < numbers.size(); i++) {
                System.out.println(numbers.get(i));
            }
        }
    }
}
