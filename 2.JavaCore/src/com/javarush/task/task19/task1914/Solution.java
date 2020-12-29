package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);
        String result = outputStream.toString();
        String[] resultArray = result.split(" ");
        int firstNum = Integer.parseInt(resultArray[0]);
        int secondNum = Integer.parseInt(resultArray[2]);
        int arithmeticResult;

        if (resultArray[1].trim().equals("+")) {
            arithmeticResult = firstNum + secondNum;
        } else if (resultArray[1].trim().equals("-")) {
            arithmeticResult = firstNum - secondNum;
        } else {
            arithmeticResult = firstNum * secondNum;
        }

        System.out.println(firstNum + " " + resultArray[1] + " " + secondNum + " = " + arithmeticResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}

