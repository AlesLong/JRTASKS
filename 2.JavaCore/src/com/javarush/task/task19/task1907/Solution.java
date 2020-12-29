package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName = bufferedReader.readLine();
        BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFileName));
        int countWordWorld = 0;
        while (inputFileReader.ready()){
            String line = inputFileReader.readLine();
            if(line.contains("world")){
                countWordWorld++;
            }
        }
        System.out.println(countWordWorld);
        bufferedReader.close();
        inputFileReader.close();
    }
}
