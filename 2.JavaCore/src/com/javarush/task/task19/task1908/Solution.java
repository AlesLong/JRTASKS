package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileInputName = bufferedReader.readLine();
        String fileOutputName = bufferedReader.readLine();
        BufferedReader inputFileReader = new BufferedReader(new FileReader(fileInputName));
        BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(fileOutputName));
        while (inputFileReader.ready()) {
            String line = inputFileReader.readLine();
            String[] symbols = line.split(" ");
            for (int i = 0; i < symbols.length; i++) {
                try {
                    int num = Integer.parseInt(symbols[i]);
                    outputFileWriter.write(num + " ");
                } catch (NumberFormatException ignore) {
                    /* NOP */
                }
            }
        }
        bufferedReader.close();
        inputFileReader.close();
        outputFileWriter.close();
    }
}
