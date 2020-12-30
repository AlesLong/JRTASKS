package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> salary = new TreeMap<>();
        BufferedReader rd = new BufferedReader(new FileReader(args[0]));
        String[] splitedLine;
        String line;
        Double currentValue;

        while ((line = rd.readLine()) != null) {
            splitedLine = line.split(" ");
            String name = splitedLine[0];
            double value = Double.parseDouble(splitedLine[1]);

            if (salary.containsKey(name)) {
                currentValue = salary.get(name);
                salary.put(name, value + currentValue);
            } else {
                salary.put(name, value);

            }
        }
        rd.close();

        for (String key : salary.keySet()) {
            System.out.println(key + " " + salary.get(key));
        }
    }
}

