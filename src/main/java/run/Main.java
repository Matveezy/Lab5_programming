package run;

import Collection.CollectionManager;
import Collection.Dragon;
import Commands.*;
import Interfaces.Command;
import Interfaces.CommandWithArguments;
import UserIO.UserIO;
import file.DragonFieldsReader;
import file.FileWorker;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    String inputFile = System.getenv("FILE_PATH");

    System.out.println(inputFile);

        Application application = new Application();
        application.start(inputFile);

    }
}


