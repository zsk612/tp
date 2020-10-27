package commands.diet.dietmanager;

import commands.Command;
import diet.dietsession.DietSession;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;

public class DietSessionList extends Command {

    static final String FILEPATH = "saves/diet/";
    DietManagerUi ui = new DietManagerUi();

    /**
     * Overrides execute for list command to list diet sessions.
     *
     * @param input user input for command
     * @param storage storage for diet manager
     */
    @Override
    public void execute(String input, DietStorage storage) {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();
        StringBuilder listResult = new StringBuilder();
        assert folder.exists();
        try {
            listResult.append("Here is your diet session list: \n\t ");
            if (Objects.requireNonNull(listOfFiles).length == 0) {
                listResult.append("It seems like you do not have any sessions stored!");
            }

            for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
                DietSession ds = storage.readDietSession(listOfFiles[i].getName());
                double totalCalories = ds.getTotalCalories();
                listResult.append("\t" + (i + 1) + ". "
                        + listOfFiles[i].getName().replaceFirst("[.][^.]+$", "")
                        + " [Total calories: " + totalCalories + "]" + "\n\t ");
            }
            logger.log(Level.INFO, "Listed all available diet sessions");
            ui.showToUser(listResult.toString().trim());
        } catch (NullPointerException e) {
            ui.showToUser("Sorry! It seems like you have no meal sessions saved!.");
            logger.log(Level.WARNING, "No instances of diet sessions saved");
        }
    }
}
