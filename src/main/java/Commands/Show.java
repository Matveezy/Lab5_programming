package Commands;

import Collection.CollectionManager;
import Interfaces.Command;

public class Show implements Command {

    private CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        collectionManager.show();
    }

    @Override
    public String getDescription() {
        return "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
