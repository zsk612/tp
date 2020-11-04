package workout.workoutmanager;

import logic.commands.CommandLib;
import logic.commands.workout.workoutmanager.WrongWS;
import org.junit.jupiter.api.Test;
import logic.commands.workout.workoutmanager.ByeWS;
import logic.commands.workout.workoutmanager.DeleteWS;
import logic.commands.workout.workoutmanager.ListWS;
import logic.commands.workout.workoutmanager.NewWS;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandLibTest {

    @Test
    void get_WorkoutManagerUnrecognisedCommand_returnNull() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.getCommand("asdf") instanceof WrongWS);
    }

    @Test
    void get_list_returnListCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.getCommand("list") instanceof ListWS);
    }

    @Test
    void get_delete_returnDeleteCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.getCommand("delete") instanceof DeleteWS);
    }

    @Test
    void get_new_returnNewCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.getCommand("new") instanceof NewWS);
    }

    @Test
    void get_bye_returnByeCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.getCommand("end") instanceof ByeWS);
    }
}
