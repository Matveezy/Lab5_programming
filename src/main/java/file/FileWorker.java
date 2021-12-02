package file;

import Collection.CollectionManager;
import Collection.Dragon;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.CollationElementIterator;

public class FileWorker {
    private CollectionValidator collectionValidator;
    private CollectionManager collectionManager;
    private String filepath = System.getenv("FILE_PATH");
//      private String filepath = "/Users/matthew/IdeaProjects/Lab5/src/main/java/run/file.xml";


    public FileWorker(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
        collectionValidator = new CollectionValidator(collectionManager);
    }


    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public void fromXmlToObject() {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionManager.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            CollectionManager collectionManager1 = (CollectionManager) unmarshaller.unmarshal(new File(filepath));
            for (Dragon val : collectionManager1.getDragons()){
                if (collectionValidator.validateId(val) && collectionValidator.validateCoordinates(val) && collectionValidator.validateAge(val) && collectionValidator.validateDate(val)
                && collectionValidator.validateCave(val) && collectionValidator.validateColor(val)){
                        collectionValidator.isThatIdContainsInCollection(val);
                        this.collectionManager.insert(val);

                }
                else System.out.println("Из XML-файла элемент с именем: " + val.getName()+ " не добавлен в коллекцию!");
            }

        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e2){
            System.err.println("Не удается найти файл!");
        }
    }

    public void saveToXml() {
        try {
            File outFile = new File(filepath);
            OutputStream outputStream = new FileOutputStream(outFile);
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionManager.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(collectionManager, outputStream);

        } catch (FileNotFoundException e){
            System.out.println("Такой файл не найден!");
        } catch (JAXBException e2) {
            System.out.println(e2.getMessage());
        }
    }


}
