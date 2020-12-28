package com.javarush.task.task08.task0829;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> townToSurname = new HashMap<>();
        while (true) {
            String town = reader.readLine();
            if (town.isEmpty()) {
                break;
            }
            String surname = reader.readLine();
            if (surname.isEmpty()){
                break;
            }
            townToSurname.put(town,surname);
        }
        String townToSearch = reader.readLine();
        String surname = townToSurname.get(townToSearch);
        if (surname == null){
            System.out.println("Нет проживающих");
        }
        else {
            System.out.println(surname);
        }
    }
}
