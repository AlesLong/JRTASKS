package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();
        FileWriter fileWriter1 = new FileWriter(fileName1);
        FileReader fileReader2 = new FileReader(fileName2);
        FileReader fileReader3 = new FileReader(fileName3);
        while (fileReader2.ready()) {
            fileWriter1.write(fileReader2.read());
        }
        while (fileReader3.ready()) {
            fileWriter1.write(fileReader3.read());
        }
        bufferedReader.close();
        fileReader2.close();
        fileWriter1.close();
        fileReader3.close();
    }
}
