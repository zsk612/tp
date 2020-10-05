package diet.dietmanager.command;

import diet.dietsession.DietSession;
import storage.DietManagerStorage;

public class NewDietSession implements Command {

    @Override
    public void execute(String[] args) {
        DietSession ds = new DietSession();
        ds.dietSessionStart();
        DietManagerStorage.add(ds);
    }
}
