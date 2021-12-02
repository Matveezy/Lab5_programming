package Commands;

import Collection.CollectionManager;
import Interfaces.Command;
import file.FileWorker;

public class Save implements Command {
    private CollectionManager collectionManager;
    private String inputFile;

    public Save(CollectionManager collectionManager, String inputFile) {
        this.collectionManager = collectionManager;
        this.inputFile = inputFile;
    }

    @Override
    public void execute() {
        collectionManager.save();
        System.out.println("Коллекция сохранена!");
    }

    @Override
    public String getDescription() {
        return "Сохранить коллекцию в файл";
    }
}
