package Commands;

import Collection.CollectionManager;
import Collection.Dragon;
import Interfaces.Command;

public class MaxByCreationDate implements Command {
    private CollectionManager collectionManager;

    public MaxByCreationDate(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        if (collectionManager.getSize() == 0) {
            System.err.println("Коллекция пустая!");
            return;
        }
        if (collectionManager.getSize() == 1) {
            System.out.println(collectionManager.getDragons().get(0).toString());
            return;
        }
        System.out.println(findDragonWithMaxCreationDay(collectionManager).toString());

    }

    /**
     * Я думаю, можно сделать алгоритм быстрее и красивее, но пока так
     *
     * @param collectionManager
     * @return
     */
    private Dragon findDragonWithMaxCreationDay(CollectionManager collectionManager) {
        Integer maxYear = getYear(collectionManager.getDragons().get(0));
        Integer maxMonth = getMonth(collectionManager.getDragons().get(0));
        Integer maxDay = getDay(collectionManager.getDragons().get(0));
        Dragon dragon = collectionManager.getDragons().get(0);
        for (Dragon val : collectionManager.getDragons()) {
            if (maxYear < getYear(val)) {
                maxYear = getYear(val);
                dragon = val;
                continue;
            } else if (maxYear > getYear(val)) continue;
            else if (maxYear == getYear(val)) {
                if (maxMonth < getMonth(val)) {
                    maxMonth = getMonth(val);
                    dragon = val;
                    continue;
                } else if (maxMonth > getMonth(val)) continue;
                else if (maxMonth == getMonth(val)) {
                    if (maxDay < getDay(val)) {
                        maxDay = getDay(val);
                        dragon = val;
                        continue;
                    } else if (maxDay > getDay(val)) continue;
                    ;
                }
            }
        }
        return dragon;
    }

    private int getYear(Dragon dragon) {
        String date = dragon.getCreationDate().toString();
        String year = date.split("-")[0];
        return Integer.parseInt(year);
    }

    private int getMonth(Dragon dragon) {
        String date = dragon.getCreationDate().toString();
        String month = date.split("-")[1];
        return Integer.parseInt(month);
    }

    private int getDay(Dragon dragon) {
        String date = dragon.getCreationDate().toString();
        String day = date.split("-")[2];
        return Integer.parseInt(day);
    }

    @Override
    public String getDescription() {
        return "Вывести любой объект из коллекции, значение поля creationDate которого является максимальным";
    }
}
