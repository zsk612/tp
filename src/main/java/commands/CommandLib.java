package commands;

import commands.diet.dietmanager.DietSessionClear;
import commands.diet.dietmanager.DietSessionCreate;
import commands.diet.dietmanager.DietSessionDelete;
import commands.diet.dietmanager.DietSessionHelp;
import commands.diet.dietmanager.DietSessionList;
import commands.diet.dietmanager.DietSessionEdit;
import commands.diet.dietmanager.DietSessionSearch;
import commands.diet.dietmanager.DietSessionWrong;
import commands.diet.dietsession.FoodItemAdd;
import commands.diet.dietsession.FoodItemClear;
import commands.diet.dietsession.FoodItemDelete;
import commands.diet.dietsession.FoodItemList;
import commands.diet.dietsession.FoodItemHelp;
import commands.diet.dietsession.FoodItemWrong;
import commands.main.Help;
import commands.main.ToDiet;
import commands.main.ToProfile;
import commands.main.ToWorkout;
import commands.main.Wrong;
import commands.workout.workoutmanager.ByeWS;
import commands.workout.workoutmanager.ClearWS;
import commands.workout.workoutmanager.DeleteWS;
import commands.workout.workoutmanager.EditWS;
import commands.workout.workoutmanager.HelpWS;
import commands.workout.workoutmanager.ListWS;
import commands.workout.workoutmanager.NewWS;
import commands.workout.workoutmanager.SearchWS;
import commands.workout.workoutmanager.WrongWS;
import commands.workout.workoutsession.WorkoutSessionAdd;
import commands.workout.workoutsession.WorkoutSessionEnd;
import commands.workout.workoutsession.WorkoutSessionDelete;
import commands.workout.workoutsession.WorkoutSessionHelp;
import commands.workout.workoutsession.WorkoutSessionList;
import commands.workout.workoutsession.WorkoutSessionSearch;
import commands.workout.workoutsession.WorkoutSessionWrong;

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    /**
     * Initialize the commandLib with workout manager's commands.
     */
    public void initWorkoutManagerCL() {
        library.put("list", new ListWS());
        library.put("new", new NewWS());
        library.put("delete", new DeleteWS());
        library.put("end", new ByeWS());
        library.put("edit", new EditWS());
        library.put("clear", new ClearWS());
        library.put("help", new HelpWS());
        library.put("wrong", new WrongWS());
        library.put("search", new SearchWS());
    }

    /**
     * Initialize the commandLib with workout session's commands.
     */
    public void initWorkoutSessionCL() {
        library.put("add", new WorkoutSessionAdd());
        library.put("delete", new WorkoutSessionDelete());
        library.put("list", new WorkoutSessionList());
        library.put("end", new WorkoutSessionEnd());
        library.put("help", new WorkoutSessionHelp());
        library.put("search", new WorkoutSessionSearch());
        library.put("wrong", new WorkoutSessionWrong());
    }

    /**
     * Initialize the commandLib with diet manager's commands.
     */
    public void initDietManagerCL() {
        library.put("list", new DietSessionList());
        library.put("meal", new DietSessionCreate());
        library.put("help", new DietSessionHelp());
        library.put("clear", new DietSessionClear());
        library.put("search", new DietSessionSearch());
        library.put("edit", new DietSessionEdit());
        library.put("delete", new DietSessionDelete());
        library.put("wrong", new DietSessionWrong());
    }

    /**
     * Initialize the commandLib with main menu's commands.
     */
    public void initMainMenu() {
        library.put("wrong", new Wrong());
        library.put("help", new Help());
        library.put("diet", new ToDiet());
        library.put("profile", new ToProfile());
        library.put("workout", new ToWorkout());
    }

    /**
     * Initialize the commandLib with diet session's commands.
     */
    public void initDietSessionCL() {
        library.put("add", new FoodItemAdd());
        library.put("delete", new FoodItemDelete());
        library.put("help", new FoodItemHelp());
        library.put("clear", new FoodItemClear());
        library.put("search", new FoodItemClear());
        library.put("list", new FoodItemList());
        library.put("wrong", new FoodItemWrong());
    }

    public Command get(String keyword) {
        if (library.containsKey(keyword)) {
            return library.get(keyword);
        } else {
            return library.get("wrong");
        }
    }


}
