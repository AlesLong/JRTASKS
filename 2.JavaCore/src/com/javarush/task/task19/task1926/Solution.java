package com.javarush.task.task19.task1926;

import java.io.*;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()) {
            StringBuilder str = new StringBuilder(br.readLine());
            System.out.println(str.reverse());
        }
        bufferedReader.close();
        br.close();
    }
}
