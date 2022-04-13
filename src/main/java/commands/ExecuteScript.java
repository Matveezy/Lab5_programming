package commands;

import collectionworker.CollectionManager;
import interfaces.CommandWithArguments;
import userio.UserIO;
import utils.DragonFieldsReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteScript implements CommandWithArguments {

    private String[] commandArguments;
    private CollectionManager collectionManager;
    private DragonFieldsReader dragonFieldsReader;
    private UserIO userIO;
    private Script script;
    private String scriptPath;

    public ExecuteScript(CollectionManager collectionManager, DragonFieldsReader dragonFieldsReader, Script script) {
        this.collectionManager = collectionManager;
        this.dragonFieldsReader = dragonFieldsReader;
        this.script = script;
    }

    @Override
    public void execute() {
        try {
            if (commandArguments.length == 1) {
                scriptPath = commandArguments[0];
                if (script.scriptPath.contains(scriptPath)) {
                    System.err.println("Попытка рекурсивного вызова скрипта внутри него же!");
                    return;
                }
                else script.putScript(scriptPath);
            } else throw new IllegalArgumentException();
            File ioFile = new File(scriptPath);
            if (!ioFile.canWrite() || ioFile.isDirectory() || !ioFile.isFile()) throw new IOException();
            FileInputStream fileInputStream = new FileInputStream(scriptPath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            Scanner scanner = new Scanner(inputStreamReader);
            userIO = new UserIO(scanner);
            CommandInvoker commandInvoker = new CommandInvoker(collectionManager, script, userIO, dragonFieldsReader);
            while (scanner.hasNext()) {
                commandInvoker.execute(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл скрипта не найден!");
        } catch (IOException e2) {
            System.err.println("Нет доступа к файлу" + e2.getMessage());
        } catch (IllegalArgumentException e3) {
            System.err.println("Скрипт не передан в качестве аргумента команды , либо кол-во аргументов больше 1!");
        } catch (NullPointerException e5) {
            System.err.println("Не выбран файл, из которого читать скрипт!");
        }
    }

    @Override
    public String getDescription() {
        return "Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    @Override
    public void getArguments(String[] arguments) {
        this.commandArguments = arguments;
    }

    static class Script {

        private ArrayList<String> scriptPath = new ArrayList<>();

        public void putScript(String path) {
            scriptPath.add(path);
        }

        public void removeScript(String path) {
            scriptPath.remove(path);
        }

    }
}
