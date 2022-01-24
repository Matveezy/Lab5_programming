package commands;

import collectionWorker.CollectionManager;
import Interfaces.Command;
import userIO.UserIO;

import java.util.Scanner;

public class Add implements Command {

    private CollectionManager collectionManager;
    private UserIO userIO;

    @Override
    public void execute() {
        collectionManager.insert(collectionManager.getDragonFactory().createDragon());
    }

    public Add(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    private UserIO createIO() {
        userIO = new UserIO(new Scanner(System.in));
        return userIO;
    }

    @Override
    public String getDescription() {
        return "Добавить новый элемент в коллекцию";
    }
}
