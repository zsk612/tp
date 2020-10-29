package commands.workout.workoutsession;

import commands.Command;
import models.Exercise;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import models.ExerciseList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import static ui.CommonUi.LS;


public class WorkoutSessionSearch extends Command {
    private boolean isEmptySearchResult = true;

    @Override
    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        String searchTerm = WorkoutSessionParser.searchParser(inputs).toLowerCase();

        if (searchTerm.length() > 0) {

            String searchResult = formatList(exerciseList.exerciseList, searchTerm);

            if (!isEmptySearchResult) {
                ui.showToUser(searchResult);
            } else {
                WorkoutSessionUi.searchResultsEmpty();
            }
        } else {
            WorkoutSessionUi.searchInputError();
        }
    }

    private String formatList(ArrayList<Exercise> exercise, String searchTerm) {

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
            if (exercise.get(i).getDescription().toLowerCase().contains(searchTerm)) {
                String rowContent = String.format(listDescriptionFormat, exercise.get(i).getDescription(),
                        exercise.get(i).getRepetitions(), exercise.get(i).getWeight());
                String row = String.format("%-8s", i + 1) + rowContent + LS;
                infoBuilder.append(row);
                isEmptySearchResult = false;
            }
        }
        returnString = infoBuilder.toString().trim();
        return returnString;
    }
}
