package com.javarush.task.task08.task0818;

import java.util.*;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("first", 1500);
        map.put("second", 150);
        map.put("third", 15000);
        map.put("fourth", 15);
        map.put("fifth", 150);
        map.put("sixth", 1520);
        map.put("seventh", 2500);
        map.put("eights", 500);
        map.put("ninth", 12500);
        map.put("tenth", 1300);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
//        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Integer> pair = iterator.next();
//            String key = pair.getKey();
//            int value = pair.getValue();
//
//            System.out.println(key+":"+value);
        Map<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String,Integer> x: copy.entrySet()){
            if(x.getValue()<500){
                map.remove(x.getKey());

            }

        }

    }

    public static void main(String[] args) {
        removeItemFromMap(createMap());
    }
}