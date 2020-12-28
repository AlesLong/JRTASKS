package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException {
        super(fileName);
        if (!fileName.endsWith(".txt")) {
            try {
                super.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {
    }
}

