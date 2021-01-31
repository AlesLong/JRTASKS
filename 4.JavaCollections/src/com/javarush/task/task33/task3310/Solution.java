package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;
import javafx.scene.Node;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        long elementsNumber = 10000;

        testStrategy(new HashMapStorageStrategy(), elementsNumber);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> ids = new HashSet<>();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> str = new HashSet<>();
        for (Long key : keys) {
            str.add(shortener.getString(key));
        }
        return str;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date d1 = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date d2 = new Date();
        System.out.println(d2.getTime() - d1.getTime());
        Date d3 = new Date();
        Set<String> stringsGenerated = getStrings(shortener, ids);
        Date d4 = new Date();
        System.out.println(d4.getTime() - d3.getTime());
        if (strings.size() == stringsGenerated.size()) {
            System.out.println("Тест пройден.");
        } else System.out.println("Тест не пройден.");
    }
}
