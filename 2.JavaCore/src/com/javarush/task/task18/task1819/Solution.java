package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        FileReader fileReader1 = new FileReader(fileName1);
        FileReader fileReader2 = new FileReader(fileName2);
        FileWriter fileWriter1 = new FileWriter(fileName1);
        while (fileReader2.ready()) {
            fileWriter1.write(fileReader2.read());
        }
        while (fileReader1.ready()) {
            fileWriter1.write(fileReader1.read());
        }
        bufferedReader.close();
        fileWriter1.close();
        fileReader1.close();
        fileReader2.close();
    }
}
