package run;

public class Main {
    public static void main(String[] args) {
            String inputFile = System.getenv("FILE_PATH");
            Application application = new Application();
            application.start(inputFile);
        }
    }



