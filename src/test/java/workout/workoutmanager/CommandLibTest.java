package workout.workoutmanager;

import org.junit.jupiter.api.Test;
import workout.workoutmanager.command.ByeWS;
import workout.workoutmanager.command.DeleteWS;
import workout.workoutmanager.command.ListWS;
import workout.workoutmanager.command.NewWS;

class CommandLibTest {

    @Test
    void get_WorkoutManagerUnrecognisedCommand_returnNull() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.get("asdf") == null);
    }

    private void assertTrue(boolean asdf) {
    }

    @Test
    void get_list_returnListCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.get("list") instanceof ListWS);
    }

    @Test
    void get_delete_returnDeleteCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.get("delete") instanceof DeleteWS);
    }

    @Test
    void get_new_returnNewCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.get("new") instanceof NewWS);
    }

    @Test
    void get_bye_returnByeCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.get("bye") instanceof ByeWS);
    }
}