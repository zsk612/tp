package workout.workoutsession;

import commands.CommandLib;
import commands.workout.workoutmanager.ByeWS;
import commands.workout.workoutmanager.DeleteWS;
import commands.workout.workoutmanager.ListWS;
import commands.workout.workoutmanager.NewWS;
import commands.workout.workoutmanager.WrongWS;
import commands.workout.workoutsession.WorkoutSessionAdd;
import commands.workout.workoutsession.WorkoutSessionDelete;
import commands.workout.workoutsession.WorkoutSessionEnd;
import commands.workout.workoutsession.WorkoutSessionList;
import commands.workout.workoutsession.WorkoutSessionWrong;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandLibTest {

    /*@Test
    void get_WorkoutManagerUnrecognisedCommand_returnNull() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.get("asdf") instanceof WorkoutSessionWrong);
    }

    @Test
    void get_list_returnListCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.get("list") instanceof WorkoutSessionList);
    }

    @Test
    void get_delete_returnDeleteCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.get("delete") instanceof WorkoutSessionDelete);
    }

    @Test
    void get_new_returnNewCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.get("add") instanceof WorkoutSessionAdd);
    }

    @Test
    void get_bye_returnByeCommand() {
        CommandLib cl = new CommandLib();
        cl.initWorkoutSessionCL();
        assertTrue(cl.get("end") instanceof WorkoutSessionEnd);
    }*/
}