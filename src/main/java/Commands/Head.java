package Commands;

import Collection.CollectionManager;
import Collection.Dragon;
import Interfaces.Command;

public class Head implements Command {
    private CollectionManager collectionManager;
    private Dragon head;

    public Head(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        if (collectionManager.getSize() != 0) {
            head = collectionManager.getDragons().get(0);
            System.out.println(head.toString());
        } else System.out.println("Коллекция пуста!");
    }

    @Override
    public String getDescription() {
        return "Вывести первый элемент коллекции";
    }
}
