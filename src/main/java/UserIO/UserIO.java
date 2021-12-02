package UserIO;

import java.util.Scanner;

public class UserIO {

    Scanner scanner;

    public UserIO() {

        this.scanner = new Scanner(System.in);
    }

    public UserIO(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getLine(){
       return scanner.nextLine();
    }

    public void printCommandText(String str){
        System.out.print(str);
    }

    public void printErrorText(String err){
        System.err.print(err);
    }


}
