package Commands;

import Collection.CollectionManager;
import Interfaces.Command;

public class Clear implements Command {

    private CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        collectionManager.clear();
        System.out.println("Коллекция очищена!");
    }

    @Override
    public String getDescription() {
        return "Очистить коллекцию";
    }
}
