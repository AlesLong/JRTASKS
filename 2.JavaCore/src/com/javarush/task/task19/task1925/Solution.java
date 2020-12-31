package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> strings = new ArrayList<>();
        String[] splitedLine;
        while (br.ready()) {
            splitedLine = br.readLine().split(" ");
            for (int i = 0; i < splitedLine.length; i++) {
                if (splitedLine[i].length() > 6) {
                    strings.add(splitedLine[i]);
                }
            }
        }
        for (int i = 0; i < strings.size(); i++) {
            if (i == strings.size() - 1) {
                bw.write(strings.get(i));
            } else {
                bw.write(strings.get(i) + ",");
            }
        }
        br.close();
        bw.close();
    }
}
