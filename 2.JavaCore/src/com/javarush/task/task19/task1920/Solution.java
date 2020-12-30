package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
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

        double maxSalary = salary.firstEntry().getValue();
        for (double value : salary.values()) {
            if (value > maxSalary) {
                maxSalary = value;
            }
        }

        TreeSet<String> names = new TreeSet<>();
        for (String name : salary.keySet()) {
            if (maxSalary == salary.get(name)) {
                names.add(name);
            }
        }

        for (String name : names) {
            System.out.println(name);
        }
        rd.close();
    }
}

