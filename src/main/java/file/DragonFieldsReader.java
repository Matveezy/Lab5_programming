package file;

import Collection.*;
import Exceptions.NotValidNumberException;
import UserIO.UserIO;

import java.time.LocalDate;

public class DragonFieldsReader {
    private UserIO userIO;

    public DragonFieldsReader(UserIO userIO) {
        this.userIO = userIO;
    }

    public Dragon read(Integer id) {
        return new Dragon(id, readName(), readCoordinates(), LocalDate.now(), readAge(), readColor(), readDragonType(), readDragonCharacter(), readDragonCave());
    }

    public String readName() {
        String str;
        while (true) {
            userIO.printCommandText("Введите имя дракона (не null) :\n");
            str = userIO.getLine();
            if (str.trim().equals("")) {
                userIO.printErrorText("Имя не может быть пустой строкой!\n");
            }
            return str;
        }
    }

    public Coordinates readCoordinates() {
        return new Coordinates(readCoordinateX(), readCoordinateY());
    }

    public Integer readCoordinateX() {
        Integer x;

        while (true) {
            try {
                userIO.printCommandText("Введите координату X (не может быть null) : \n");
                String str = userIO.getLine();
                if (str.trim().equals("")) {
                    userIO.printErrorText("Коодината X не может быть задана пустой строкой!\n");
                }
                x = Integer.parseInt(str.trim());
                return x;
            } catch (NumberFormatException e) {
                userIO.printErrorText("Координата не можеть быть задана не числом!");
            }
        }
    }

    public Double readCoordinateY() {
        Double y;
        while (true) {
            try {
                userIO.printCommandText("Введите координату Y (не может быть null и должна быть меньше -212) : \n");
                String str = userIO.getLine();
                if (str.trim().equals("")) {
                    userIO.printErrorText("Коодината Y не может быть задана пустой строкой!\n");
                }
                y = Double.parseDouble(str.trim());
                if (y > -212) {
                    throw new NotValidNumberException();
                }
                return y;
            } catch (NumberFormatException e) {
                userIO.printErrorText("Координата не можеть быть задана не числом!\n");
            } catch (NotValidNumberException e2){
                userIO.printErrorText("Координата не можеть быть задана числом больше -212!\n");
            }
        }

    }

    public Integer readAge() {
        Integer age;

        while (true) {
            try {
                userIO.printCommandText("Введите возраст вашего дракона (Должно быть больше нуля! Может быть null!) :\n");
                String str = userIO.getLine();
                if (str.trim().equals("")) {
                    userIO.printErrorText("Возраст не может быть задана пустой строкой!\n");
                }
                age = Integer.parseInt(str.trim());
                if (age <= 0) {
                    throw new NotValidNumberException();
                }
                return age;
            } catch (NumberFormatException e) {
                userIO.printErrorText("Возраст не можеть быть задан не числом!");
            } catch (NotValidNumberException e2){
                userIO.printErrorText("Возраст не можеть быть задан числом меньше нуля!");
            }
        }
    }


    public Color readColor() {
        Color color;
        userIO.printCommandText("Выберите цвет из данного списка :\n");
        for (Color colors : Color.values()) {
            System.out.println(colors.name());
        }

        while (true) {
            try {
                userIO.printCommandText("Цвет вашего дракона :\n");
                color = Color.valueOf(userIO.getLine().trim().toUpperCase());
                return color;
            } catch (IllegalArgumentException e) {
                System.err.println("Значение введенной константы не представлено в перечислении Color");
            }
        }
    }

    public DragonType readDragonType() {
        DragonType dragonType;
        userIO.printCommandText("Все возможные типы драконов:\n");
        for (DragonType val : DragonType.values()) {
            System.out.println(val.name());
        }
        while (true) {
            try {
                userIO.printCommandText("Выберите тип вашего дракона:\n");
                String userInput = userIO.getLine().trim();
                if (userInput.equals("null")) {
                    dragonType=null;
                    return dragonType;
                }
                dragonType = DragonType.valueOf(userInput.toUpperCase());
                return dragonType;
            } catch (IllegalArgumentException e) {
                System.err.println("Значение введенной константы не представлено в перечислении DragonType");
            }
        }
    }

    public DragonCharacter readDragonCharacter() {
        DragonCharacter dragonCharacter;
        userIO.printCommandText("Все возможные типы характеров дракона :\n");
        for (DragonCharacter val : DragonCharacter.values()) {
            System.out.println(val.name());
        }
        while (true) {
            try {
                userIO.printCommandText("Выберите характер вашего дракона :\n");
                String userInput = userIO.getLine().trim();
                if (userInput.equals("null")){
                    dragonCharacter=null;
                    return dragonCharacter;
                }
                dragonCharacter = DragonCharacter.valueOf(userIO.getLine().trim().toUpperCase());
                return dragonCharacter;
            } catch (IllegalArgumentException e) {
                userIO.printErrorText("Значение введенной константы не представлено в перечислении DragonCharacter");
            }
        }
    }

    public DragonCave readDragonCave() {
        return new DragonCave(readCaveDepth(), readNumberOfTreasures());
    }

    public Float readCaveDepth() {
        Float depth;
        userIO.printCommandText("Введите глубину пещеры вышего дракона (не можеть быть null) :\n");
        while (true) {
            try {
                String str = userIO.getLine();
                if (str.trim().equals("")) {
                    userIO.printErrorText("Глубина пещеры не может быть пустой строкой!");
                }
                depth = Float.parseFloat(str.trim());
                return depth;
            } catch (NumberFormatException e) {
                userIO.printErrorText("Глубина пещеры не можеть быть задана не числом!");
            }
        }
    }

    public Float readNumberOfTreasures() {
        Float numberOfTreasures;
        userIO.printCommandText("Введите количество сокровищ :\n");
        while (true) {
            try {
                String str = userIO.getLine();
                if (str.trim().equals("")) {
                    userIO.printErrorText("Количество сокровищ не может быть пустой строкой!");
                }
                numberOfTreasures = Float.parseFloat(str.trim());
                return numberOfTreasures;
            } catch (NumberFormatException e) {
                userIO.printErrorText("Количество не можеть быть задано не числом!");
            }
        }
    }
}
