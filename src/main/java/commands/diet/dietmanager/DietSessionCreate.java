package commands.diet.dietmanager;

import ui.diet.dietmanager.DietManagerUi;
import diet.dietsession.DietSession;
import commands.Command;
import storage.diet.Storage;

import java.io.IOException;

public class DietSessionCreate extends Command {

    @Override
    public void execute(String input, Storage storage) {
        DietManagerUi ui = new DietManagerUi();

        try {
            DietSession ds = new DietSession(ui.extractMeal(input), ui.extractDate(input));
            ds.start();
        } catch (IOException e) {
            System.out.println("It seems like we ran into some problems saving your session...");
        }
    }
}
