package commands.diet.dietmanager;

import commands.Command;
import storage.diet.Storage;

import java.io.File;
import java.util.Objects;

public class DietSessionClear extends Command {
    static final String FILEPATH = "saves/diet/";

    @Override
    public void execute(String input, Storage storage) {
        try {
            File folder = new File(FILEPATH);
            File[] listOfFiles = folder.listFiles();
            for (int index = 0; index < Objects.requireNonNull(listOfFiles).length; index++) {
                listOfFiles[index].delete();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println("You have cleared all diet sessions!");
    }
}
