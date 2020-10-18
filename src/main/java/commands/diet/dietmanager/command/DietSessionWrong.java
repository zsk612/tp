package commands.diet.dietmanager.command;

import storage.diet.Storage;
import commands.Command;

public class DietSessionWrong extends Command {
    @Override
    public void execute(String input, Storage storage) {
        System.out.println("Sorry! It seems like you've entered an invalid command!");
    }
}
