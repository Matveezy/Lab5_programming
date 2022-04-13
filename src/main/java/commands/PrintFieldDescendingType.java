package commands;

import collectionworker.CollectionManager;
import collection.Dragon;
import interfaces.Command;

import java.util.LinkedList;

public class PrintFieldDescendingType implements Command {

    private CollectionManager collectionManager;

    public PrintFieldDescendingType(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        LinkedList<Dragon> reverseDragons = collectionManager.reverseCollection();
        for (Dragon val : reverseDragons){
            System.out.println(val.getType());
        }
    }

    @Override
    public String getDescription() {
        return "Вывести значения поля type всех элементов в порядке убывания";
    }
}


