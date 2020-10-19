package commands.diet.dietmanager;

import commands.Command;
import diet.dietsession.DietSession;
import storage.diet.Storage;
import ui.diet.dietmanager.DietManagerUi;

import java.io.IOException;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class DietSessionCreate extends Command {

    @Override
    public void execute(String input, Storage storage) {
        DietManagerUi ui = new DietManagerUi();

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
