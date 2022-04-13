package commands;

import collectionworker.CollectionManager;
import collection.Dragon;
import interfaces.Command;

public class AddIfMin implements Command {
    private CollectionManager collectionManager;

    public AddIfMin(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        Dragon currentDragon = collectionManager.getDragonFactory().createDragon();
        Dragon minCollectionDragon = collectionManager.findMinDragon();
        if (currentDragon.compareTo(minCollectionDragon)>0){
            System.err.println("Значение этого элемента больше, чем значение минимального элемента коллекции!\nЭлемент не добавлен!");
        }
        if (currentDragon.compareTo(minCollectionDragon)==0){
            System.err.println("Значения этого элемента равно значению минимального элемента коллекции!\nЭлемент не добавлен!");
        }
        if (currentDragon.compareTo(minCollectionDragon)<0){
            collectionManager.insert(currentDragon);
            System.out.println("Элемент добавлен!");
        }
    }

    @Override
    public String getDescription() {
        return "Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
