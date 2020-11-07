package logic.commands.workout.workoutsession;

import logic.commands.Command;
import logic.commands.CommandResult;
import storage.workout.WorkoutSessionStorage;
import ui.workout.workoutsession.WorkoutSessionUi;
import models.Exercise;
import models.ExerciseList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import static ui.CommonUi.LS;

public class WorkoutSessionList extends Command {

    @Override
    public CommandResult execute(String[] inputs, ExerciseList exerciseList,
                                 String filePath, WorkoutSessionStorage workoutSessionStorage,
                                 boolean[] hasEndedWorkoutSessions) {
        assert (inputs != null && exerciseList != null && filePath != null
                && workoutSessionStorage != null && hasEndedWorkoutSessions != null) : "File Corrupted";
        String result = "";
        try {
            result = printList(exerciseList.exerciseList);
            workoutSessionStorage.writeToStorage(filePath, exerciseList);
        } catch (IOException e) {
            return new CommandResult(WorkoutSessionUi.PRINT_ERROR);
        }
        return new CommandResult(result);
    }

    private String printList(ArrayList<Exercise> exercise) {
        assert exercise != null : "exercise list not found";
        String list = "";
        if (exercise.size() <= 0) {
            list = WorkoutSessionUi.EMPTY_LIST_ERROR;
        } else {
            list = formatList(exercise);
        }
        return list;
    }

    private String formatList(ArrayList<Exercise> exercise) {

        ArrayList<String> exerciseNames = (ArrayList<String>) exercise.stream()
                .map(Exercise::getDescription).collect(Collectors.toList());
        int descriptionMaxLenInt = Math.max(20,
                exerciseNames.stream().max(Comparator.comparingInt(String::length)).get().length());

        String descriptionFormat = "%-" + String.format("%d", descriptionMaxLenInt + 1) + "s";

        String returnString = String.format("%-8s", "Index") + String.format(descriptionFormat, "Exercise")
                + String.format("%-15s", "Repetitions") + String.format("%-10s", "Weight") + LS;

        StringBuilder infoBuilder = new StringBuilder(returnString);

        String listDescriptionFormat = "%-" + String.format("%d", descriptionMaxLenInt) + "s %-14s %s";
        for (int i = 0; i < exercise.size(); i++) {
            String rowContent = String.format(listDescriptionFormat, exercise.get(i).getDescription(),
                    exercise.get(i).getRepetitions(), exercise.get(i).getWeight());
            String row = String.format("%-8s", i + 1) + rowContent + LS;
            infoBuilder.append(row);
        }
        returnString = infoBuilder.toString().trim();
        return returnString;
    }


}
