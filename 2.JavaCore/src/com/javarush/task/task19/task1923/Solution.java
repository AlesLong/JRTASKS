package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        String fileReadLine;
        String[] splitedLine;
        while ((fileReadLine = bufferedReader.readLine()) != null) {
            splitedLine = fileReadLine.split(" ");
            for (String word : splitedLine) {
                if (word.matches(".+[0-9].+")) {
                    bufferedWriter.write(word + " ");
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
