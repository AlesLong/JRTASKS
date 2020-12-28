package com.javarush.task.task14.task1419;

import java.awt.datatransfer.MimeTypeParseException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Object object = null;
            object.toString();
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            int[] numbers = new int[2];
            numbers[3] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
      //  exceptions.add(new BindException());
        exceptions.add(new ArrayStoreException());
        exceptions.add(new CloneNotSupportedException());
        exceptions.add(new ClassCastException());
        exceptions.add(new StringIndexOutOfBoundsException());
        exceptions.add(new FileNotFoundException());
        exceptions.add(new MimeTypeParseException());
        exceptions.add(new InterruptedIOException());

    }
}
