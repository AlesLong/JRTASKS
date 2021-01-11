package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        bufferedReader.close();
        if (s.equals("earth")) {
            thePlanet = Earth.getInstance();
        } else if (s.equals("sun")) {
            thePlanet = Sun.getInstance();
        } else if (s.equals("moon")) {
            thePlanet = Moon.getInstance();
        } else {
            thePlanet = null;
        }
    }
}
