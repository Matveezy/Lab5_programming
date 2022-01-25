package utils;

import collection.Color;
import collection.Dragon;
import collection.DragonCharacter;
import collection.DragonType;
import collectionWorker.CollectionManager;

import java.util.Arrays;

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

    public String getFieldsName() {
        return "Список всех полей:\nname(String)\ncoordinate_x(Integer)\ncoordinate_y(Double)\nage(Integer)" +
                "\ncolor: " + Arrays.toString(Color.values()) + "\ntype: " + Arrays.toString(DragonType.values()) +
                "\ncharacter: " + Arrays.toString(DragonCharacter.values()) + "\ncave_depth(Float)\ncave_number_of_treasures(Float)\n";
    }

}
