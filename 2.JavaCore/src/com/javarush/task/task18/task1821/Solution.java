package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
      // TreeMap<Character, Integer> frequencyMap = new TreeMap<>();
      // FileReader fileReader = new FileReader(args[0]);
      // BufferedReader bufferedReader = new BufferedReader(fileReader);
      // while (bufferedReader.ready()) {
      //     String line = bufferedReader.readLine();
      //     char[] chars = line.toCharArray();
      //     for (int i = 0; i < chars.length; i++) {
      //         frequencyMap.put(chars[i], frequencyMap.getOrDefault(chars[i], 0) + 1);
      //     }
      // }
      // Set<Character> charKeys = frequencyMap.keySet();
      // for (Character key : charKeys) {
      //     System.out.println(key + " " + frequencyMap.get(key));
      // }
      // fileReader.close();
        int[] aSCII = new int[128];
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                aSCII[reader.read()]++;
            }
        }
        for (int i = 0; i < aSCII.length; i++) {
            if (aSCII[i] != 0) {
                System.out.println((char) i + " " + aSCII[i]);
            }
        }
    }
}

