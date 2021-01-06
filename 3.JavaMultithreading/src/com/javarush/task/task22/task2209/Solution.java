package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bfr = new BufferedReader(new FileReader(bufferedReader.readLine()))) {
            while (bfr.ready()) {

            }
        }


        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) {
            return null;
        }
        return null;
    }
}
