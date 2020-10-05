package diet.dietmanager.command;

import storage.DietManagerStorage;

public class DietSessionList implements Command {

    @Override
    public void execute(String[] args) {
        DietManagerStorage.list(args);
    }
}
