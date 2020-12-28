package com.javarush.task.task18.task1822;

import java.io.*;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String idToSearch = args[0];
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        String productInfoFromFile = null;
        while ((productInfoFromFile = bufferedFileReader.readLine()) != null) {

            String[] data = productInfoFromFile.trim().split(" ");
            if (data[0].equals(idToSearch)) {
                System.out.println(productInfoFromFile);
            }
        }
        bufferedFileReader.close();
    }
}
