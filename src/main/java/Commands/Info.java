package Commands;

import Collection.CollectionManager;
import Interfaces.Command;

public class Info implements Command {

    private CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        try {
            collectionManager.info();
        } catch (NullPointerException ex) {
            System.err.println("В коллекции нет элементов");
        }
    }

    @Override
    public String getDescription() {
        return "Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
