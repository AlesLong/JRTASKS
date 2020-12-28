package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(bufferedReader.readLine())));
        ArrayList<Integer> numbers = new ArrayList<>();
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            int n = Integer.parseInt(s);
            if (n % 2 == 0) {
                numbers.add(n);
            }
        }
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
        fileReader.close();
        bufferedReader.close();

    }
}
