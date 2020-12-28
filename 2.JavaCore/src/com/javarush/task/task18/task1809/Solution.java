package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileInputName = bufferedReader.readLine();
        String fileOutputName = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileInputName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);

        List<Integer> inputBytes = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            inputBytes.add(fileInputStream.read());
        }
        Collections.reverse(inputBytes);
        for (Integer aByte : inputBytes) {
            fileOutputStream.write(aByte);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}



