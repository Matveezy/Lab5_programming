package commands;

import collectionworker.CollectionManager;
import Interfaces.Command;

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
