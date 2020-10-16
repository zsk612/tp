package diet.dietmanager.command;

import storage.diet.Storage;

import java.util.logging.Level;

public class DietSessionWrong implements Command {
    @Override
    public void execute(String input, Storage storage) {
        System.out.println("Sorry! It seems like you've entered an invalid command!");
        logger.log(Level.INFO,"Invalid command");
    }
}
