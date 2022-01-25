package commands;

import collectionWorker.CollectionManager;
import Interfaces.Command;
import Interfaces.CommandWithArguments;
import userIO.UserIO;
import utils.DragonFieldsReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

/**
 * Класс, который вызывает исполнение команд
 */
public class CommandInvoker {

    private HashMap<String, Command> commandWithoutArguments;
    private HashMap<String, CommandWithArguments> commandWithArguments;
    private CollectionManager collectionManager;
    ExecuteScript.Script script;
    private UserIO userIO;
    private String inputFile;
    private DragonFieldsReader dragonFieldsReader;


    public CommandInvoker(CollectionManager collectionManager, ExecuteScript.Script script, UserIO userIO, DragonFieldsReader dragonFieldsReader) {
        this.collectionManager = collectionManager;
        this.userIO = userIO;
        this.dragonFieldsReader = dragonFieldsReader;
        this.script = script;
        commandWithoutArguments = new HashMap<>();
        commandWithArguments = new HashMap<>();
        this.putCommand();

    }

    public CommandInvoker(CollectionManager collectionManager, UserIO userIO, String inputFile, DragonFieldsReader dragonFieldsReader) {
        this.collectionManager = collectionManager;
        this.userIO = userIO;
        this.inputFile = inputFile;
        this.dragonFieldsReader = dragonFieldsReader;
        commandWithArguments = new HashMap<>();
        commandWithoutArguments = new HashMap<>();
        script = new ExecuteScript.Script();
        this.putCommand();
    }

    private void putCommand() {
        commandWithoutArguments.put("help", new Help(commandWithoutArguments, commandWithArguments));
        commandWithoutArguments.put("info", new Info(collectionManager));
        commandWithoutArguments.put("add", new Add(collectionManager));
        commandWithoutArguments.put("clear", new Clear(collectionManager));
        commandWithoutArguments.put("show", new Show(collectionManager));
        commandWithoutArguments.put("exit", new Exit());
        commandWithoutArguments.put("head", new Head(collectionManager));
        commandWithoutArguments.put("print_field_descending_type", new PrintFieldDescendingType(collectionManager));
        commandWithoutArguments.put("print_unique_age", new PrintUniqueAge(collectionManager));
        commandWithoutArguments.put("add_if_min", new AddIfMin(collectionManager));
        commandWithoutArguments.put("remove_lower", new RemoveLower(collectionManager));
        commandWithoutArguments.put("max_by_creation_date", new MaxByCreationDate(collectionManager));
        commandWithoutArguments.put("save", new Save(collectionManager, inputFile));

        commandWithArguments.put("update", new Update(collectionManager, userIO));
        commandWithArguments.put("execute_script", new ExecuteScript(collectionManager, dragonFieldsReader, script));
        commandWithArguments.put("remove_by_id", new RemoveById(userIO, collectionManager));


    }

    public void execute(String firstLineCommand) {
        String[] words = firstLineCommand.trim().split("\\s+");
        String[] args = Arrays.copyOfRange(words, 1, words.length);

        if (commandWithArguments.containsKey(words[0].toLowerCase(Locale.ROOT))) {
            CommandWithArguments command;
            command = commandWithArguments.get(words[0].toLowerCase(Locale.ROOT));
            command.getArguments(args);
            command.execute();
        } else if (commandWithoutArguments.containsKey(words[0].toLowerCase(Locale.ROOT))) {
            Command command;
            command = commandWithoutArguments.get(words[0].toLowerCase(Locale.ROOT));
            command.execute();
        } else {
            System.out.println("Комманда " + words[0] + " не распознана, введите корректную команду!");
        }

    }

}
