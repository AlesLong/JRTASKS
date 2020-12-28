package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        int count = 0;
        try (FileInputStream fileInputStream=new FileInputStream(fileName)){
            while (fileInputStream.available()>0){
                if(fileInputStream.read()==44){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
