package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws IOException {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        } while (operation != Operation.EXIT);


        //    try (
        //           BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        //       while (br.ready()) {
        //           String path = br.readLine();
        //           String pathArchive = br.readLine();
        //           ZipFileManager zipFileManager = new ZipFileManager(Paths.get(path));
        //           zipFileManager.createZip(Paths.get(pathArchive));
        //       }
        //   } catch (Exception e) {
        //       e.printStackTrace();
        //   }
        //   ExitCommand ec = new ExitCommand();
        //   try {
        //       ec.execute();
        //   } catch (Exception e) {
        //       e.printStackTrace();
        //   }0
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - упаковать файлы в архив");
        ConsoleHelper.writeMessage(Operation.ADD.ordinal() + " - добавить файл в архив");
        ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + " - удалить файл из архива");
        ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + " - распаковать архив");
        ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + " - посмотреть содержимое архива");
        ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + " - выход");
        int i = ConsoleHelper.readInt();
        Operation[] values = Operation.values();
        return values[i];
    }
}
