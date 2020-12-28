package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String line = reader.readLine();
        while (!line.isEmpty()) {
            list.add(line);
            line = reader.readLine();
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                numbers.add(Integer.parseInt(array[i]));
            } else {
                words.add(array[i]);
            }
        }
        Collections.sort(numbers);
        Collections.reverse(numbers);

        //    numbers.sort(new Comparator<String>() {
        //        @Override
        //        public int compare(String o1, String o2) {
        //            return isGreaterThan(o1, o2) ? -1 : isEquals(o1, o2) ? 0 : 1;
        //        }
        //    });
        words.sort((o1, o2) -> isGreaterThan(o1, o2) ? 1 : isEquals(o1, o2) ? 0 : -1);

        Iterator<Integer> numbersIterator = numbers.iterator();
        Iterator<String> wordsIterator = words.iterator();

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = numbersIterator.next().toString();
            } else {
                array[i] = wordsIterator.next();
            }
        }
    }

    public static boolean isEquals(String a, String b) {
        return a.compareTo(b) == 0;
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];

            // есть '-' внутри строки
            if (i != 0 && character == '-') {
                return false;
            }

            // не цифра и не начинается с '-'
            if (!Character.isDigit(character) && character != '-') {
                return false;
            }

            // одиночный '-'
            if (chars.length == 1 && character == '-') {
                return false;
            }
        }

        return true;
    }
}
