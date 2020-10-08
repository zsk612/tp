package diet.dietsession;

import diet.dietsession.command.*;

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initDietManagerCL() {
        this.library.put("add", new FoodItemAdd());
        this.library.put("delete", new FoodItemDelete());
        this.library.put("show", new FoodItemShow());
    }

    public Command get(String keyword) {
        if(library.containsKey(keyword)) {
            return library.get(keyword);
        } else {
            return new FoodItemWrong();
        }
    }
}
