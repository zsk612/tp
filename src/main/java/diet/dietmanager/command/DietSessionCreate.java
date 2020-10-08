package diet.dietmanager.command;

import diet.dietmanager.DietManagerUI;
import diet.dietsession.DietSession;
import storage.DietManagerStorage;

public class DietSessionCreate implements Command {


    @Override
    public void execute(String input, DietManagerStorage storage) {

        storage.add(input);
    }
}
