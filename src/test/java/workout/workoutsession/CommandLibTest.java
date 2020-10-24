package workout.workoutsession;

import commands.CommandLib;
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
    void get_WorkoutSessionUnrecognisedCommand_returnNull() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("asdf") instanceof WorkoutSessionWrong);
    }

    @Test
    void get_list_returnListCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("list") instanceof WorkoutSessionList);
    }

    @Test
    void get_delete_returnDeleteCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("delete") instanceof WorkoutSessionDelete);
    }

    @Test
    void get_add_returnAddCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("add") instanceof WorkoutSessionAdd);
    }

    @Test
    void get_End_returnEndCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("end") instanceof WorkoutSessionEnd);
    }

    @Test
    void get_Search_returnSearchCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("search") instanceof WorkoutSessionSearch);
    }

    @Test
    void get_help_returnHelpCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.getCommand("help") instanceof WorkoutSessionHelp);
    }
}
