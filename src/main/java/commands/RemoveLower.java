package commands;

import collectionWorker.CollectionManager;
import collection.Dragon;
import Interfaces.Command;

import java.util.LinkedList;

public class RemoveLower implements Command {
    private CollectionManager collectionManager;

    public RemoveLower(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        Dragon currentDragon = collectionManager.getDragonFactory().createDragon();
        Dragon comparing;
        LinkedList<Dragon> needToRemoveDragons = new LinkedList<>();
        for (Dragon dragon : collectionManager.getDragons()) {
            if (dragon.compareTo(currentDragon) < 0) {
                needToRemoveDragons.add(dragon);
            }
        }
        collectionManager.getDragons().removeAll(needToRemoveDragons);
    }


    @Override
    public String getDescription() {
        return "Удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
