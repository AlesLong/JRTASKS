package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        BufferedReader fileInput = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileOtput = new BufferedWriter(new FileWriter(fileName2));
        while (fileInput.ready()) {
            String[] digits = fileInput.readLine().split(" ");
            for (int i = 0; i < digits.length; i++) {
                int number = (int) Math.round(Double.parseDouble(digits[i]));
                fileOtput.write(number + " ");
            }
        }
        bufferedReader.close();
        fileInput.close();
        fileOtput.close();
    }
}
