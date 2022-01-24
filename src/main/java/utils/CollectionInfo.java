package utils;

import collection.Dragon;
import collectionWorker.CollectionManager;

public class CollectionInfo {

    public void getInfoAboutCollection(CollectionManager collectionManager) {
        System.out.println("Дата создания коллекции " + collectionManager.getCreationCollectionDate());
        System.out.println("Количество элементов в коллеции " + collectionManager.getDragons().size());
    }

    public void show(CollectionManager collectionManager){
        if (collectionManager.getDragons().size() == 0) {
            System.out.println("Коллекция пуста!");
        } else {
            for (Dragon vals : collectionManager.getDragons()) {
                System.out.println(vals.toString());
            }
        }
    }
}
