package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileInputName = bufferedReader.readLine();
        String fileOutputName = bufferedReader.readLine();
        BufferedReader inputFileReader = new BufferedReader(new FileReader(fileInputName));
        BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(fileOutputName));
        while (inputFileReader.ready()) {
            outputFileWriter.write(inputFileReader.readLine().replaceAll("\\.", "!"));
        }
        bufferedReader.close();
        inputFileReader.close();
        outputFileWriter.close();
    }
}
