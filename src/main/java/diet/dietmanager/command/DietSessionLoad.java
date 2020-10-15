package diet.dietmanager.command;

import diet.dietsession.DietSession;
import storage.diet.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

public class DietSessionLoad implements Command {
    static final String FILEPATH = "saves/diet/";
    @Override
    public void execute(String input, Storage storage) {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();

        try {
            DietSession ds = null;
            assert listOfFiles != null;
            ds = storage.readDietSession(listOfFiles[Integer.parseInt(input) - 1].getName(), ds);
            ds.start();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("Sorry, there is no file at that index.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}