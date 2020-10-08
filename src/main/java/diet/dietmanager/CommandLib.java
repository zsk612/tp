package diet.dietmanager;

import diet.dietmanager.command.*;
import diet.dietmanager.command.DietSessionCreate;

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initDietManagerCL() {
        this.library.put("list", new DietSessionList());
        this.library.put("meal", new DietSessionCreate());
//        this.library.put("add", new AddFood());
//        this.library.put("delete", new DeleteFood());
    }

    public Command get(String keyword) {
        if (library.containsKey(keyword)) {
            return library.get(keyword);
        } else {
            return new DietSessionWrong();
        }
    }
}
