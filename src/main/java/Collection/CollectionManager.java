package Collection;

import Exceptions.NotValidNumberException;
import file.FileWorker;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.events.DTD;
import java.time.LocalDate;
import java.util.*;

@XmlRootElement(name = "dragons")
public class CollectionManager {

    private LinkedList<Dragon> dragons;
    private DragonFactory dragonFactory;
    private LocalDate creationCollectionDate;

    private Dragon minDragon;

    public DragonFactory getDragonFactory() {
        return dragonFactory;
    }

    public CollectionManager() {
        creationCollectionDate = LocalDate.now();
        dragons = new LinkedList<Dragon>();
        dragonFactory = new DragonFactory();
    }

    public void info() {
        System.out.println("Дата создания коллекции " + creationCollectionDate);
        System.out.println("Количество элементов в коллеции " + dragons.size());
    }

    public void insert(Dragon dragon) {
        long checkId = dragon.getId();
        boolean isContains = false;
        for (Dragon val : getDragons()){
            if (isElementInCollection(checkId)) ++checkId;
        }
        dragon.setId(checkId);
        dragons.add(dragon);
        long newId = checkId+1;
        getDragonFactory().setId(newId);
    }

    public void show() {
        if (dragons.size() == 0) {
            System.out.println("Коллекция пуста!");
        } else {
            for (Dragon vals : dragons) {
                System.out.println(vals.toString());
            }
        }
    }

    public void updateById(long id, String field, String value) {
        switch (field) {
            case "name": {
                if (value.equals("")) throw new NullPointerException();
                getElementById(id).setName(value);
                System.out.println("Поле изменено!");
                break;
            }
            case "coordinate_x": {
                if (value.equals("")) value = null;
                getElementById(id).getCoordinates().setX(Integer.parseInt(value));
                System.out.println("Поле изменено!");
                break;
            }
            case "coordinate_y": {
                if (value.equals("")) value = null;
                getElementById(id).getCoordinates().setY(Double.parseDouble(value));
                System.out.println("Поле изменено!");
                break;
            }
            case "age": {
                if (value.equals("")) {
                    getElementById(id).setAge(null);
                }
                getElementById(id).setAge(Integer.parseInt(value));
                System.out.println("Поле изменено!");
                break;
            }
            case "color": {
                getElementById(id).setColor(Color.valueOf(value.toUpperCase(Locale.ROOT)));
                System.out.println("Поле изменено!");
                break;
            }

            case "type": {
                getElementById(id).setType(DragonType.valueOf(value.toUpperCase(Locale.ROOT)));
                System.out.println("Поле изменено!");
                break;
            }

            case "character": {
                getElementById(id).setCharacter(DragonCharacter.valueOf(value.toUpperCase(Locale.ROOT)));
                System.out.println("Поле изменено!");
                break;
            }

            case "cave_depth": {
                if (value.equals("")) throw new NullPointerException();
                getElementById(id).getCave().setDepth(Float.parseFloat(value));
                System.out.println("Поле изменено!");
                break;
            }

            case "cave_number_of_treasures": {
                if (value.equals("")) throw new NullPointerException();
                getElementById(id).getCave().setNumberOfTreasures(Float.parseFloat(value));
                System.out.println("Поле изменено!");
                break;
            }
            case "stop": {
                break;
            }
            default: {
                System.out.println("Значение поля введено неверно!");
                break;
            }
        }

    }

    public Dragon getElementById(long id) {
        try {
            if (id < 1) throw new NotValidNumberException();
            for (Dragon vals : dragons) {
                if (vals.getId() == id) {
                    return vals;
                }
            }
        } catch (NotValidNumberException e) {
            System.out.println("Введите корректный id!");
        }
        return null;
    }

    public boolean removeById(long id) {
        try {
            if (id < 1 && id > dragons.size()) throw new NotValidNumberException();
            for (Dragon val : dragons) {
                if (val.getId() == id) {
                    dragons.remove(val);
                    dragonFactory.setId(id);
                    return true;
                }
            }
        } catch (NotValidNumberException e) {
            System.out.println("Элемента с таким id в коллекции нет!");
        }
        return false;
    }

    public boolean isElementInCollection(long id) {
        try {
            if (id < 1) throw new NotValidNumberException();
            for (Dragon vals : this.getDragons()) {
                if (vals.getId() == id) {
                    return true;
                }
            }
        } catch (NotValidNumberException e) {
            System.out.println("Введите корректный id!");
        }
        return false;

    }

    public String getFieldsName() {
        return "Список всех полей:\nname(String)\ncoordinate_x(Integer)\ncoordinate_y(Double)\nage(Integer)" +
                "\ncolor: " + Arrays.toString(Color.values()) + "\ntype: " + Arrays.toString(DragonType.values()) +
                "\ncharacter: " + Arrays.toString(DragonCharacter.values()) + "\ncave_depth(Float)\ncave_number_of_treasures(Float)\n";
    }

    public void clear() {
        dragons.clear();
        dragonFactory.setId(1);
    }

    public int getSize() {
        return dragons.size();
    }

    public LinkedList<Dragon> getDragons() {
        return dragons;
    }

    @XmlElement(name = "dragon")
    public void setDragons(LinkedList<Dragon> list) {
        dragons = list;
    }

    public LinkedList<Dragon> reverseCollection() {
        LinkedList<Dragon> newDragons = new LinkedList<>();
        int count = 0;
        Iterator<Dragon> iterator = dragons.descendingIterator();
        while (iterator.hasNext() && count < dragons.size()) {
            newDragons.add(iterator.next());
            count++;
        }
        return newDragons;
    }


    public Dragon findMinDragon() {
        minDragon = dragons.get(0);
        for (Dragon vals : dragons) {
            if (vals.compareTo(minDragon) > 0) minDragon = vals;
        }
        return minDragon;
    }

    public void save(){
        FileWorker fileWorker = new FileWorker(this);
        fileWorker.saveToXml();
    }

}
