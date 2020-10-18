package commands;

import commands.diet.dietmanager.command.DietSessionCreate;
import commands.diet.dietmanager.command.DietSessionDelete;
import commands.diet.dietmanager.command.DietSessionList;
import commands.diet.dietmanager.command.DietSessionLoad;
import commands.diet.dietmanager.command.DietSessionWrong;
import commands.diet.dietsession.command.FoodItemAdd;
import commands.diet.dietsession.command.FoodItemDelete;
import commands.diet.dietsession.command.FoodItemShow;
import commands.diet.dietsession.command.FoodItemWrong;
import commands.workout.workoutmanager.command.ByeWS;
import commands.workout.workoutmanager.command.DeleteWS;
import commands.workout.workoutmanager.command.ListWS;
import commands.workout.workoutmanager.command.NewWS;

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initWorkoutManagerCL() {
        this.library.put("list", new ListWS());
        this.library.put("new", new NewWS());
        this.library.put("delete", new DeleteWS());
        this.library.put("bye", new ByeWS());
    }

    public void initDietManagerCL() {
        this.library.put("list", new DietSessionList());
        this.library.put("meal", new DietSessionCreate());
        this.library.put("load", new DietSessionLoad());
        this.library.put("delete", new DietSessionDelete());
        this.library.put("wrong", new DietSessionWrong());
    }

    public void initDietSessionCL() {
        this.library.put("add", new FoodItemAdd());
        this.library.put("delete", new FoodItemDelete());
        this.library.put("show", new FoodItemShow());
        this.library.put("wrong", new FoodItemWrong());
    }

    public Command get(String keyword) {
        if (library.containsKey(keyword)) {
            return library.get(keyword);
        } else {
            return library.get("wrong");
        }
    }
}
