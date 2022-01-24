package commands;

import collectionWorker.CollectionManager;
import Interfaces.CommandWithArguments;
import userIO.UserIO;

public class RemoveById implements CommandWithArguments {
    private String[] commandArguments;
    private UserIO userIO;
    private CollectionManager collectionManager;

    public RemoveById(UserIO userIO, CollectionManager collectionManager) {
        this.userIO = userIO;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        try {

            if (collectionManager.isElementInCollection(Long.parseLong(commandArguments[0]))){
                    collectionManager.removeById(Long.parseLong(commandArguments[0]));
            } else {
                System.err.println("Элемента с данным id нет в коллекции!");
            }
        } catch (NullPointerException e2){
            System.err.println("Не указан аргумент команды!");
        }
    }

    @Override
    public String getDescription() {
        return "Удалить элемент из коллекции по его id";
    }

    @Override
    public void getArguments(String[] arguments) {
        this.commandArguments=arguments;
    }
}
