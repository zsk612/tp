package commands.workout.workoutsession;

import commands.Command;
import storage.workout.Storage;
import ui.CommonUi;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import workout.workoutsession.exercise.Exercise;

import java.util.ArrayList;

public class WorkoutSessionSearch extends Command {
    private static CommonUi printer = new CommonUi();

    @Override
    public void execute(String[] input, ArrayList<Exercise> exercise,
                        String filePath, Storage storage, boolean[] endWorkoutSession) {
        String searchTerm = WorkoutSessionParser.searchParser(input).toLowerCase();
        StringBuilder searchResult = new StringBuilder();
        if (searchTerm.length() > 0) {
            for (int i = 0; i < exercise.size(); i++) {
                if (exercise.get(i).getDescription().toLowerCase().contains(searchTerm)) {
                    searchResult.append(exercise.get(i).toString() + "\n\t ");
                }
            }
            if(searchResult.length()!=0) {
                printer.showToUser(searchResult.toString().trim());
            } else {
                WorkoutSessionUi.searchResultsEmpty();
            }
        } else {
            WorkoutSessionUi.searchInputError();
        }
    }
}
