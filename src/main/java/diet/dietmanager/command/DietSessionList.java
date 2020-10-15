package diet.dietmanager.command;

import storage.diet.Storage;

import java.io.File;
<<<<<<< HEAD

public class DietSessionList implements Command {
    static final String FILEPATH = "saves/diet";
=======
import java.util.logging.Level;

public class DietSessionList implements Command {
    static final String FILEPATH = "saves/diet/";
>>>>>>> 62fd2c83c5d18eef0a090f6d0c813ed0a9d47d2b
    @Override
    public void execute(String input, Storage storage) {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();

        try {
            for (int i = 0; i < listOfFiles.length; i++) {
<<<<<<< HEAD
                System.out.println("File " + listOfFiles[i].getName());
            }
        } catch (NullPointerException e) {
            System.out.println("Sorry, there is nothing in DietManager.");
=======
                System.out.println((i+1) + ". " + listOfFiles[i].getName());
            }
        } catch (NullPointerException e) {
            System.out.println("Sorry, there is nothing in Diet Manager.");
            logger.log(Level.INFO, "No instances of diet sessions saved");
>>>>>>> 62fd2c83c5d18eef0a090f6d0c813ed0a9d47d2b
        }
    }
}
