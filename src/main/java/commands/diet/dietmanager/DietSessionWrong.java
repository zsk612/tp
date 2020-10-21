package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;

import java.util.logging.Level;
import static logger.SchwarzeneggerLogger.logger;

public class DietSessionWrong extends Command {

    /**
     * Overrides execute for wrong command.
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, Storage storage) {
        System.out.println("Sorry! It seems like you've entered an invalid command!");
        logger.log(Level.INFO, "Invalid command");
    }
}
