package logic.commands.workout.workoutsession;

import logic.commands.CommandResult;
import models.ExerciseList;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;
import storage.workout.Storage;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WorkoutSessionAddTest {

    @Test
    void execute_validInput_success() {
        String[] inputs = {"add", "bench", "/n", "3244", "/w", "4324"};
        ExerciseList exerciseList = new ExerciseList();
        String filePath = "./saves/workout/workoutSession0";
        Storage storage = new Storage();
        boolean[] hasEndedWorkoutSessions = {false};

        WorkoutSessionAdd workoutSessionAdd = new WorkoutSessionAdd();

        CommandResult actual = workoutSessionAdd.execute(inputs, exerciseList, filePath, storage,
                hasEndedWorkoutSessions);
        CommandResult expected = new CommandResult("Yay! You have added bench to your list.\n"
                + "\t [Repetitions: 3244 || Weight: 4324]");
        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));
    }

}
