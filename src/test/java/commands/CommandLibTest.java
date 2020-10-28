package commands;

import commands.diet.dietmanager.DietSessionClear;
import commands.diet.dietmanager.DietSessionCreate;
import commands.diet.dietmanager.DietSessionDelete;
import commands.diet.dietmanager.DietSessionEdit;
import commands.diet.dietmanager.DietSessionHelp;
import commands.diet.dietmanager.DietSessionList;
import commands.diet.dietmanager.DietSessionWrong;
import commands.diet.dietsession.FoodItemAdd;
import commands.diet.dietsession.FoodItemClear;
import commands.diet.dietsession.FoodItemDelete;
import commands.diet.dietsession.FoodItemHelp;
import commands.diet.dietsession.FoodItemList;
import commands.diet.dietsession.FoodItemWrong;
import commands.main.MainHelp;
import commands.main.ToDiet;
import commands.main.ToProfile;
import commands.main.ToWorkout;
import commands.main.MainWrong;
import commands.profile.ProfileAdd;
import commands.profile.ProfileDelete;
import commands.profile.ProfileEdit;
import commands.profile.ProfileEnd;
import commands.profile.ProfileHelp;
import commands.profile.ProfileView;
import commands.profile.ProfileWrong;
import commands.workout.workoutmanager.ByeWS;
import commands.workout.workoutmanager.DeleteWS;
import commands.workout.workoutmanager.ListWS;
import commands.workout.workoutmanager.NewWS;
import commands.workout.workoutmanager.WrongWS;
import commands.workout.workoutsession.WorkoutSessionAdd;
import commands.workout.workoutsession.WorkoutSessionDelete;
import commands.workout.workoutsession.WorkoutSessionEnd;
import commands.workout.workoutsession.WorkoutSessionHelp;
import commands.workout.workoutsession.WorkoutSessionList;
import commands.workout.workoutsession.WorkoutSessionSearch;
import commands.workout.workoutsession.WorkoutSessionWrong;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandLibTest {

    @Test
    void getCommandTest_dietManagerUnrecognisedCommand_returnDietSessionWrong() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("asdf") instanceof DietSessionWrong);
    }

    @Test
    void getCommandTest_listDietSession_returnListCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("list") instanceof DietSessionList);
    }

    @Test
    void getCommandTest_deleteDietSession_returnDeleteCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("delete") instanceof DietSessionDelete);
    }

    @Test
    void getCommandTest_newDietSession_returnNewCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("new") instanceof DietSessionCreate);
    }

    @Test
    void getCommandTest_clearDietSession_returnClearCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("clear") instanceof DietSessionClear);
    }

    @Test
    void getCommandTest_editDietSession_returnEditCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("edit") instanceof DietSessionEdit);
    }

    @Test
    void getCommandTest_helpDietSession_returnHelpCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("help") instanceof DietSessionHelp);
    }

    @Test
    void getCommandTest_DietManagerUnrecognisedCommand_returnFoodItemWrong() {
        CommandLib cl = new CommandLib();
        cl.initDietSessionCL();
        assertTrue(cl.getCommand("asdf") instanceof FoodItemWrong);
    }

    @Test
    void getCommandTest_listFoodItem_returnListCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietSessionCL();
        assertTrue(cl.getCommand("list") instanceof FoodItemList);
    }

    @Test
    void getCommandTest_deleteFoodItem_returnDeleteCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietSessionCL();
        assertTrue(cl.getCommand("delete") instanceof FoodItemDelete);
    }

    @Test
    void getCommandTest_newFoodItem_returnNewCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietSessionCL();
        assertTrue(cl.getCommand("add") instanceof FoodItemAdd);
    }

    @Test
    void getCommandTest_clearFoodItem_returnClearCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietSessionCL();
        assertTrue(cl.getCommand("clear") instanceof FoodItemClear);
    }

    @Test
    void getCommandTest_helpFoodItem_returnHelpCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietSessionCL();
        assertTrue(cl.getCommand("help") instanceof FoodItemHelp);
    }

    @Test
    void getCommandTest_WorkoutManagerUnrecognisedCommand_returnNull() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.getCommand("asdf") instanceof WrongWS);
    }

    @Test
    void getCommandTest_listWS_returnListCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.getCommand("list") instanceof ListWS);
    }

    @Test
    void getCommandTest_deleteWS_returnDeleteCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.getCommand("delete") instanceof DeleteWS);
    }

    @Test
    void getCommandTest_newWS_returnNewCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.getCommand("new") instanceof NewWS);
    }

    @Test
    void getCommandTest_byeWS_returnByeCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.getCommand("end") instanceof ByeWS);
    }

    @Test
    void getCommandTest_WorkoutSessionUnrecognisedCommand_returnNull() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("asdf") instanceof WorkoutSessionWrong);
    }

    @Test
    void getCommandTest_workoutSessionList_returnListCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("list") instanceof WorkoutSessionList);
    }

    @Test
    void getCommandTest_workoutSessionDelete_returnDeleteCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("delete") instanceof WorkoutSessionDelete);
    }

    @Test
    void getCommandTest_workoutSessionAdd_returnAddCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("add") instanceof WorkoutSessionAdd);
    }

    @Test
    void getCommandTest_workoutSessionEnd_returnEndCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("end") instanceof WorkoutSessionEnd);
    }

    @Test
    void getCommandTest_workoutSessionSearch_returnSearchCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("search") instanceof WorkoutSessionSearch);
    }

    @Test
    void getCommandTest_workoutSessionHelp_returnHelpCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("help") instanceof WorkoutSessionHelp);
    }

    @Test
    void getCommandTest_profileSessionAddCommand_returnProfileAdd() {
        CommandLib cl = new CommandLib();
        cl.initProfileSessionCL();
        assertTrue(cl.getCommand("add") instanceof ProfileAdd);
    }

    @Test
    void getCommandTest_profileSessionDeleteCommand_returnProfileDelete() {
        CommandLib cl = new CommandLib();
        cl.initProfileSessionCL();
        assertTrue(cl.getCommand("delete") instanceof ProfileDelete);
    }

    @Test
    void getCommandTest_profileSessionEditCommand_returnProfileEdit() {
        CommandLib cl = new CommandLib();
        cl.initProfileSessionCL();
        assertTrue(cl.getCommand("edit") instanceof ProfileEdit);
    }

    @Test
    void getCommandTest_profileSessionEndCommand_returnProfileEnd() {
        CommandLib cl = new CommandLib();
        cl.initProfileSessionCL();
        assertTrue(cl.getCommand("end") instanceof ProfileEnd);
    }

    @Test
    void getCommandTest_profileSessionHelpCommand_returnProfileHelp() {
        CommandLib cl = new CommandLib();
        cl.initProfileSessionCL();
        assertTrue(cl.getCommand("help") instanceof ProfileHelp);
    }

    @Test
    void getCommandTest_profileSessionViewCommand_returnProfileView() {
        CommandLib cl = new CommandLib();
        cl.initProfileSessionCL();
        assertTrue(cl.getCommand("view") instanceof ProfileView);
    }

    @Test
    void getCommandTest_profileSessionUnrecognisedCommand_returnProfileWrong() {
        CommandLib cl = new CommandLib();
        cl.initProfileSessionCL();
        assertTrue(cl.getCommand("asdf") instanceof ProfileWrong);
    }

    @Test
    void getCommandTest_mainHelpCommand_returnHelp() {
        CommandLib cl = new CommandLib();
        cl.initMainMenu();
        assertTrue(cl.getCommand("help") instanceof MainHelp);
    }

    @Test
    void getCommandTest_mainDietCommand_returnToDiet() {
        CommandLib cl = new CommandLib();
        cl.initMainMenu();
        assertTrue(cl.getCommand("diet") instanceof ToDiet);
    }

    @Test
    void getCommandTest_mainProfileCommand_returnToProfile() {
        CommandLib cl = new CommandLib();
        cl.initMainMenu();
        assertTrue(cl.getCommand("profile") instanceof ToProfile);
    }

    @Test
    void getCommandTest_mainWorkoutCommand_returnToWorkout() {
        CommandLib cl = new CommandLib();
        cl.initMainMenu();
        assertTrue(cl.getCommand("workout") instanceof ToWorkout);
    }

    @Test
    void getCommandTest_mainUnrecognisedCommand_returnWrong() {
        CommandLib cl = new CommandLib();
        cl.initMainMenu();
        assertTrue(cl.getCommand("asdf") instanceof MainWrong);
    }
}
