package diet.dietmanager.command;

import diet.dietsession.DietSession;
import storage.DietManagerStorage;

public class DietSessionCreate implements Command {

    @Override
    public void execute() {
        DietSession ds = new DietSession();
        System.out.println("in new diet");
        ds.start();
        DietManagerStorage.add(ds);
    }
}
