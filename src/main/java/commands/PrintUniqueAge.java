package commands;

import collectionworker.CollectionManager;
import collection.Dragon;
import interfaces.Command;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueAge implements Command {

    private CollectionManager collectionManager;
    Set<Integer> ages;

    public PrintUniqueAge(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        for (Integer ages : createAgeSet()) {
            System.out.println(ages);
        }
    }

    @Override
    public String getDescription() {
        return "Вывести уникальные значения поля age всех элементов в коллекции";
    }

    private Set<Integer> createAgeSet() {
        ages = new HashSet<>();
        for (Dragon dragon : collectionManager.getDragons()) {
            ages.add(dragon.getAge());
        }
        return ages;
    }

}


