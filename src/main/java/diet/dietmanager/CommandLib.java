package diet.dietmanager;

import diet.dietmanager.command.NewDietSession;
import diet.dietmanager.command.Command;
import diet.dietmanager.command.DietSessionList;

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initDietManagerCL() {
        this.library.put("list", new DietSessionList());
        this.library.put("new", new NewDietSession());
    }

    public Command get(String keyword) {
        return library.get(keyword);
    }
}
