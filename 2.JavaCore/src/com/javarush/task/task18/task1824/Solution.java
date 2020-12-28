package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = null;
        try {
            while (bufferedReader.ready()) {
                fileName = bufferedReader.readLine();
                FileReader fileReader = new FileReader(fileName);
                fileReader.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println(fileName);
        }
        bufferedReader.close();
    }
}
