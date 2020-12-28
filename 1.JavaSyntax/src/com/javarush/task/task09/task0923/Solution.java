package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        char[] stringToArray = string.toCharArray(); // Преобразуем строку str в массив символов (char)
        ArrayList<Character> glas = new ArrayList<>();
        ArrayList<Character> soglas = new ArrayList<>();
        for (int i = 0; i < stringToArray.length; i++) {
           if (isVowel(stringToArray[i])==true){
               glas.add(stringToArray[i]);
           }
           else if(string.charAt(i) !=' ' ){
               soglas.add(stringToArray[i]);
           }
        }
        for (int i = 0; i <glas.size(); i++) {
            System.out.print(glas.get(i)+" ");
        }
        System.out.println();
        for (int i = 0; i <soglas.size(); i++) {
            System.out.print(soglas.get(i)+" ");
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}