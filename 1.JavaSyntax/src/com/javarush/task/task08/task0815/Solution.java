package com.javarush.task.task08.task0815;

import java.util.*;

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

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        Iterator<String> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            String nameI = iterator.next();
            if (nameI.equals(name)) {
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String nameI = iterator.next();
            if (nameI.equals(lastName)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        getCountTheSameFirstName(createMap(), "yevh");
        getCountTheSameLastName(createMap(), "bess");
    }
}
