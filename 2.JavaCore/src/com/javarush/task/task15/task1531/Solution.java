package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigInteger bg = new BigInteger(n + "");
        BigInteger temp = new BigInteger("1");
        if (bg.compareTo(BigInteger.ZERO) < 0) {
            return "0";
        }

        if (bg.compareTo(BigInteger.ZERO) == 0) {
            return "1";
        }
        for (int i = 1; i < n; i++) {
            temp = temp.multiply(bg);
            bg = bg.subtract(BigInteger.ONE);
        }
        return temp.toString();
    }
}
