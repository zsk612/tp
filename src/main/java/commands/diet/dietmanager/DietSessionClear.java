package commands.diet.dietmanager;

import storage.diet.Storage;
import commands.Command;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Logger;

public class DietSessionClear extends Command {
    static final String FILEPATH = "saves/diet/";

    @Override
    public void execute(String input, Storage storage, Logger logger) {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();
        try {
            System.out.println("Oh no! You have cleared all the diet sessions!");
            Arrays.fill(listOfFiles, null);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Sorry! It seems like you've entered an invalid number or input!");
        }
    }
}
