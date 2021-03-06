package commands;

import interfaces.Command;

public class Exit implements Command {
    @Override
    public void execute() {
        System.out.println("Завершение работы программы!");
        System.exit(0);
//        return;
    }

    @Override
    public String getDescription() {
        return "Завершить программу (без сохранения в файл)";
    }
}
