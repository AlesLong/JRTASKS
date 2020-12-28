package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        String fileName3 = bufferedReader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);
        // byte[] bytes = new byte[10000000];
        // while (fileInputStream1.available() > 0) {
        //     int count = fileInputStream1.read(bytes);
        //
        //         fileOutputStream2.write(bytes, 0, count / 2 );
        //         fileOutputStream3.write(bytes, count / 2+1,count/2);
        //
        int halfOfFile = (fileInputStream1.available() + 1) / 2;
        int numberOfByte = 0;
        while (fileInputStream1.available() > 0) {
            if (numberOfByte < halfOfFile) {
                fileOutputStream2.write(fileInputStream1.read());
                numberOfByte++;
            } else fileOutputStream3.write(fileInputStream1.read());
        }
        fileInputStream1.close();
        fileOutputStream3.close();
        fileOutputStream2.close();

    }
}
