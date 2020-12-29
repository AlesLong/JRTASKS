package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileInputName = bufferedReader.readLine();
        String fileOutputName = bufferedReader.readLine();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(fileInputName));
        BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter(fileOutputName));
        while (fileReader1.ready()) {
            fileWriter2.write(fileReader1.readLine().replaceAll("\\p{Punct}+", ""));
        }
        fileReader1.close();
        fileWriter2.close();
        bufferedReader.close();
    }
}
