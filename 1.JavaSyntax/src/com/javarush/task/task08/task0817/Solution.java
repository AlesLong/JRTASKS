package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> surnameName = new HashMap<>();
        surnameName.put("b", "y");
        surnameName.put("be", "ye");
        surnameName.put("bes", "yev");
        surnameName.put("besp", "yevh");
        surnameName.put("bespa", "yevhe");
        surnameName.put("bespal", "yevhen");
        surnameName.put("bespalo", "yevheni");
        surnameName.put("bespalov", "yevheniy");
        surnameName.put("bess", "yevv");
        surnameName.put("besal", "ye");
        return surnameName;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> duplicate = new HashMap<>(map);

        Iterator<Map.Entry<String, String>> it = duplicate.entrySet().iterator();   // Получаем итератор для множества пар отображения

        while (it.hasNext()) {   // Цикл будет работать, пока не достигнут последний элемент множества
            Map.Entry<String, String> pair = it.next();   // Получаем очередную пару
            String name = pair.getValue();

            it.remove();   // Удаляем текущую пару из отображения

            if (duplicate.containsValue(name)) {
                removeItemFromMapByValue(map, name);
            }
        }
//        Iterator<String> iterator = map.values().iterator();
//        while (iterator.hasNext()) {
//            String value = iterator.next();
//            if (value.equals(iterator.next()))
//                removeItemFromMapByValue(map, value);
//        }
        System.out.println(map);
    }


    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }
        public static void main (String[]args){
            removeTheFirstNameDuplicates(createMap());
        }
    }

