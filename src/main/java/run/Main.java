package run;

public class Main {
    public static void main(String[] args) {
        try {
            String inputFile = System.getenv("FILE_PATH");
            Application application = new Application();
            application.start(inputFile);

        } catch (NullPointerException e){
            System.err.println("Укажите переменную окружения FILE_PATH!");
        }

//    System.out.println(inputFile);


    }
}


