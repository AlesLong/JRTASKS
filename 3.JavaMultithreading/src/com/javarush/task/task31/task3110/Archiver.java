package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws IOException {
        try(
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            while (br.ready()){
                String path = br.readLine();
                String pathArchive = br.readLine();
                ZipFileManager zipFileManager = new ZipFileManager(Paths.get(path));
                zipFileManager.createZip(Paths.get(pathArchive));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExitCommand ec = new ExitCommand();
        try {
            ec.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
