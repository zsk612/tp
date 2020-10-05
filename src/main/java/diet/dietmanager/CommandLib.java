package diet.dietmanager;

import diet.dietmanager.command.AddFood;
import diet.dietmanager.command.Command;
import diet.dietmanager.command.DeleteFood;
import diet.dietmanager.command.DietSessionList;
import diet.dietmanager.command.NewDietSession;

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initDietManagerCL() {
        this.library.put("list", new DietSessionList());
        this.library.put("new", new NewDietSession());
        this.library.put("add", new AddFood());
        this.library.put("delete", new DeleteFood());
    }

    public Command get(String keyword) {
        return library.get(keyword);
    }
}
