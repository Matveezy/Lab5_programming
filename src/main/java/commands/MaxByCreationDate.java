package commands;

import collectionWorker.CollectionManager;
import collection.Dragon;
import Interfaces.Command;
import utils.DateParser;

public class MaxByCreationDate implements Command {
    private CollectionManager collectionManager;
    private DateParser dateParser = new DateParser();
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
        Dragon firstDragon = collectionManager.getDragons().get(0);
        Integer maxYear = dateParser.getYear(firstDragon);
        Integer maxMonth = dateParser.getMonth(firstDragon);
        Integer maxDay = dateParser.getDay(firstDragon);
        Dragon dragon = collectionManager.getDragons().get(0);
        for (Dragon val : collectionManager.getDragons()) {
            if (maxYear < dateParser.getYear(val)) {
                maxYear = dateParser.getYear(val);
                dragon = val;
                continue;
            } else if (maxYear > dateParser.getYear(val)) continue;
            else if (maxYear == dateParser.getYear(val)) {
                if (maxMonth < dateParser.getMonth(val)) {
                    maxMonth = dateParser.getMonth(val);
                    dragon = val;
                    continue;
                } else if (maxMonth > dateParser.getMonth(val)) continue;
                else if (maxMonth == dateParser.getMonth(val)) {
                    if (maxDay < dateParser.getDay(val)) {
                        maxDay = dateParser.getDay(val);
                        dragon = val;
                        continue;
                    } else if (maxDay > dateParser.getDay(val)) continue;
                    ;
                }
            }
        }
        return dragon;
    }


    @Override
    public String getDescription() {
        return "Вывести любой объект из коллекции, значение поля creationDate которого является максимальным";
    }
}
