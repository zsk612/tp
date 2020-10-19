package commands;

import commands.diet.dietmanager.DietSessionClear;
import commands.diet.dietmanager.DietSessionCreate;
import commands.diet.dietmanager.DietSessionDelete;
import commands.diet.dietmanager.DietSessionHelp;
import commands.diet.dietmanager.DietSessionList;
import commands.diet.dietmanager.DietSessionEdit;
import commands.diet.dietmanager.DietSessionWrong;
import commands.diet.dietsession.FoodItemAdd;
import commands.diet.dietsession.FoodItemClear;
import commands.diet.dietsession.FoodItemDelete;
import commands.diet.dietsession.FoodItemHelp;
import commands.diet.dietsession.FoodItemList;
import commands.diet.dietsession.FoodItemWrong;
import commands.workout.workoutmanager.ByeWS;
import commands.workout.workoutmanager.ClearWS;
import commands.workout.workoutmanager.DeleteWS;
import commands.workout.workoutmanager.EditWS;
import commands.workout.workoutmanager.HelpWS;
import commands.workout.workoutmanager.ListWS;
import commands.workout.workoutmanager.NewWS;
import commands.workout.workoutmanager.WrongWS;
import commands.workout.workoutsession.WorkoutSessionAdd;
import commands.workout.workoutsession.WorkoutSessionEnd;
import commands.workout.workoutsession.WorkoutSessionDelete;
import commands.workout.workoutsession.WorkoutSessionList;
import commands.workout.workoutsession.WorkoutSessionWrong;

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
        this.library.put("end", new ByeWS());
        this.library.put("edit", new EditWS());
        this.library.put("clear", new ClearWS());
        this.library.put("help", new HelpWS());
        this.library.put("wrong", new WrongWS());
    }

    public void initWorkoutSessionCL() {
        this.library.put("add", new WorkoutSessionAdd());
        this.library.put("delete", new WorkoutSessionDelete());
        this.library.put("list", new WorkoutSessionList());
        this.library.put("end", new WorkoutSessionEnd());
        this.library.put("wrong", new WorkoutSessionWrong());
    }

    public void initDietManagerCL() {
        this.library.put("list", new DietSessionList());
        this.library.put("meal", new DietSessionCreate());
        this.library.put("edit", new DietSessionEdit());
        this.library.put("delete", new DietSessionDelete());
        this.library.put("clear", new DietSessionClear());
        this.library.put("help", new DietSessionHelp());
        this.library.put("wrong", new DietSessionWrong());
    }

    public void initDietSessionCL() {
        this.library.put("add", new FoodItemAdd());
        this.library.put("delete", new FoodItemDelete());
        this.library.put("list", new FoodItemList());
        this.library.put("clear", new FoodItemClear());
        this.library.put("help", new FoodItemHelp());
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
