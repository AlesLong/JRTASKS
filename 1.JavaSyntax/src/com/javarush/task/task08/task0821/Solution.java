package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> surnameName = new HashMap<>();
        surnameName.put("b", "y");
        surnameName.put("be", "ye");
        surnameName.put("bess", "yev");
        surnameName.put("besp", "yevh");
        surnameName.put("bespa", "yevhe");
        surnameName.put("bespal", "yevhen");
        surnameName.put("bespalo", "yevheni");
        surnameName.put("bespalov", "yevheniy");
        surnameName.put("bess", "yevv");
        surnameName.put("besal", "ye");
        return surnameName;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
