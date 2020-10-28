package commands.workout.workoutsession;

import commands.Command;
import models.PastWorkoutSessionRecord;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import models.Exercise;
import models.ExerciseList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ui.CommonUi.LS;

public class WorkoutSessionList extends Command {

    @Override
    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        try {
            printList(exerciseList.exerciseList);
            storage.writeToStorage(filePath, exerciseList);
        } catch (IOException e) {
            WorkoutSessionUi.printError();
        }
    }

    private void printList(ArrayList<Exercise> exercise) {
        assert exercise != null : "exercise list not found";
        if (exercise.size() <= 0) {
            WorkoutSessionUi.emptyListError();
        } else {
            ui.showToUser(formatList(exercise));
        }
    }

    private String formatList(ArrayList<Exercise> exercise) {

        ArrayList<String> exerciseNames = (ArrayList<String>) exercise.stream()
                .map(Exercise::getDescription).collect(Collectors.toList());
        int descriptionMaxLenInt = Math.max(20,
                exerciseNames.stream().max(Comparator.comparingInt(String::length)).get().length());

        String descriptionFormat = "%-" + String.format("%d", descriptionMaxLenInt + 1) + "s";

        String returnString = String.format("%-8s", "Index") + String.format(descriptionFormat, "Exercise")
                + String.format("%-12s", "Repetitions") + String.format("%-10s", "Weight") + LS;

        StringBuilder infoBuilder = new StringBuilder(returnString);

        String listDescriptionFormat = "%-" + String.format("%d", descriptionMaxLenInt) + "s %-11s %s";
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
