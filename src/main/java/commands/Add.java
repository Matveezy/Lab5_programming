package commands;

import collectionWorker.CollectionManager;
import Interfaces.Command;
import userIO.UserIO;

import java.util.Scanner;

public class Add implements Command {

    private CollectionManager collectionManager;

    @Override
    public void execute() {
        collectionManager.insert(collectionManager.getDragonFactory().createDragon());
    }

    public Add(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }


    @Override
    public String getDescription() {
        return "Добавить новый элемент в коллекцию";
    }
}
