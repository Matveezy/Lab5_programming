package commands;

import collectionWorker.CollectionManager;
import Interfaces.CommandWithArguments;
import userIO.UserIO;
import utils.CollectionInfo;

public class Update implements CommandWithArguments {

    private String[] arguments;
    private CollectionManager collectionManager;
    private UserIO userIO;
    private CollectionInfo collectionInfo;

    public Update(CollectionManager collectionManager, UserIO userIO) {
        this.collectionManager = collectionManager;
        this.userIO = userIO;
        collectionInfo = new CollectionInfo();
    }

    @Override
    public void execute() {
        try {
            if (collectionManager.isElementInCollection(Long.parseLong(arguments[0]))) {
                System.out.println(collectionInfo.getFieldsName());
                System.out.println("Введите stop, когда захотите прервать изменение элемента коллекции!");
                System.out.println("Введите значения полей для элемента коллекции: ");
                String[] commandWords = new String[0];
                do {
                    try {
                        commandWords = userIO.getLine().trim().split("\\s+");
                        if (commandWords.length == 1) {
                            collectionManager.updateById(Long.parseLong(arguments[0]), commandWords[0], "");
                        } else {
                            collectionManager.updateById(Long.parseLong(arguments[0]), commandWords[0], commandWords[1]);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Не указано поле или значение!");
                    }
                } while (!commandWords[0].equals("stop"));

            } else {
                System.err.println("Элемента с данным id нет в коллекции!");
            }
        } catch (IndexOutOfBoundsException e2) {
            System.err.println("Не указаны все аргументы команды!");
        } catch (NumberFormatException e3) {
            System.err.println("Формат аргумента не соответствует целочисленному ");
        } catch (NullPointerException e4){
            System.err.println("Поле не может быть задано пустой строкой");
        }
    }

    @Override
    public String getDescription() {
        return "Обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public void getArguments(String[] arguments) {
        this.arguments=arguments;
    }
}
