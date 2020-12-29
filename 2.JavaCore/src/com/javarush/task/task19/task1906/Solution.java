package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileInputName = bufferedReader.readLine();
        String fileOutputName = bufferedReader.readLine();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(fileInputName));
        BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter(fileOutputName));
        ArrayList<Integer> charsFronLine = new ArrayList<>();
        while (fileReader1.ready()) {
            charsFronLine.add(fileReader1.read());
        }
        for (int i = 1; i < charsFronLine.size(); i = i + 2) {
            fileWriter2.write(charsFronLine.get(i));
        }
        fileReader1.close();
        fileWriter2.close();
    }
}
