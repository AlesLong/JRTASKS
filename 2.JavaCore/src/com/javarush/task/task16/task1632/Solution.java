package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new ZeroThread()));
        threads.add(new Thread(new FirstThread()));
        threads.add(new Thread(new SecondThread()));
        threads.add(new Thread(new ThirdThread()));
        threads.add(new Thread(new FourthThread()));


    }

    public static void main(String[] args) {

    }

    public static class ZeroThread implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class FirstThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static class SecondThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThirdThread extends Thread implements Message {
        public void run() {
            while (!isInterrupted()) {
            }
        }

        public void showWarning() {
            this.interrupt();
        }
    }

    public static class FourthThread implements Runnable {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            while (true) {
                try {
                    String str = reader.readLine();
                    if (str.equals("N"))
                        break;
                    sum += Integer.parseInt(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(sum);
        }
    }
}