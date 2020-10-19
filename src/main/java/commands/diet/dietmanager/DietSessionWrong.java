package commands.diet.dietmanager;

import storage.diet.Storage;
import commands.Command;

import java.util.logging.Logger;

public class DietSessionWrong extends Command {
    @Override
    public void execute(String input, Storage storage, Logger logger) {
        System.out.println("Sorry! It seems like you've entered an invalid command!");
    }
}
