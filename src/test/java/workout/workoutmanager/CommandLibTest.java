package workout.workoutmanager;

import org.junit.jupiter.api.Test;
import workout.workoutmanager.command.ByeWS;
import workout.workoutmanager.command.Command;
import workout.workoutmanager.command.DeleteWS;
import workout.workoutmanager.command.ListWS;
import workout.workoutmanager.command.NewWS;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class CommandLibTest {

    @Test
    void get_WorkoutManagerUnrecognisedCommand_returnNull() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.get("asdf") == null);
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
    void get_bye_throwExitException() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutManagerCL();
        assertTrue(cl.get("bye") instanceof ByeWS);
    }
}