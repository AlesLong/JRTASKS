package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static String[] getTokens(String query, String delimiter) {
        List<String> strings = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            strings.add(token);
        }
        String[] strings1 = new String[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            strings1[i] = strings.get(i);
        }
        return strings1;

      //  StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
      //  String[] result = new String[stringTokenizer.countTokens()];
      //  int i = 0;
      //  while (stringTokenizer.hasMoreTokens()) {
      //      result[i++] = stringTokenizer.nextToken();
      //  }
      //  return result;
    }
}
