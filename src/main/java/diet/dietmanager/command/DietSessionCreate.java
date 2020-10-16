package diet.dietmanager.command;

import diet.dietmanager.DietManagerUI;
import diet.dietsession.DietSession;
import storage.diet.Storage;

import java.io.IOException;
import java.util.logging.Level;

public class DietSessionCreate implements Command {


    @Override
    public void execute(String input, Storage storage) {
        DietManagerUI ui = new DietManagerUI();
        try {
            DietSession ds = new DietSession(ui.extractMeal(input), ui.extractDate(input));
            assert ds != null;
            logger.log(Level.INFO, "Diet session successfully created");
            ds.start();
        } catch (IOException e) {
            System.out.println("It seems like we ran into some problems saving your session...");
            logger.log(Level.WARNING, "Diet session failed to save");
        }
    }
}
