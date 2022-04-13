package run;

import collectionworker.CollectionManager;
import commands.CommandInvoker;
import exception.PathVariableNotExistException;
import userio.UserIO;
import file.FileWorker;
import utils.DragonFieldsReader;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Application {
    CollectionManager collectionManager;
    FileWorker fileWorker;
    UserIO userIO;
    CommandInvoker commandInvoker;
    DragonFieldsReader dragonFieldsReader;

    public void start(String inputFile) {
        if (inputFile==null) throw new PathVariableNotExistException("Укажите переменную окружения FILE_PATH!");
        collectionManager = new CollectionManager();
        fileWorker = new FileWorker(collectionManager , collectionManager.getDragonFactory());
        userIO = new UserIO();
        this.commandInvoker = new CommandInvoker(collectionManager, userIO, inputFile, dragonFieldsReader);

        try {
            File ioFile = new File(inputFile);
            if (!ioFile.canWrite() || !ioFile.isFile() || ioFile.isDirectory()) throw new IOException();
            fileWorker.fromXmlToObject();
            if (collectionManager.getSize()==0){
                System.out.println("Добавьте объекты с помощью команды add, после чего введите команды save для сохранения в xml!");
            } else System.out.println("Объекты из файла загружены!");

        } catch (IOException e) {
            System.out.println("Такого файла нет!");
            System.exit(0);
        }

        try{
            process();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

    }

    public void process(){
        System.out.println("Программа запущена");
        while (true){
            System.out.println("\nВведите название команды");
            String command = userIO.getLine();
            commandInvoker.execute(command);
        }
    }
}


