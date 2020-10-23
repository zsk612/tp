package commands.workout.workoutsession;

import commands.Command;
import storage.workout.Storage;
import ui.CommonUi;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import workout.workoutsession.exercise.ExerciseList;


public class WorkoutSessionSearch extends Command {
    private static CommonUi printer = new CommonUi();

    @Override
    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        String searchTerm = WorkoutSessionParser.searchParser(inputs).toLowerCase();
        StringBuilder searchResult = new StringBuilder();

        if (searchTerm.length() > 0) {

            for (int i = 0; i < exerciseList.exerciseList.size(); i++) {

                if (exerciseList.exerciseList.get(i).getDescription().toLowerCase().contains(searchTerm)) {
                    searchResult.append(exerciseList.exerciseList.get(i).toString() + "\n\t ");
                }
            }

            if (searchResult.length() != 0) {
                printer.showToUser(searchResult.toString().trim());
            } else {
                WorkoutSessionUi.searchResultsEmpty();
            }

        } else {
            WorkoutSessionUi.searchInputError();
        }
    }
}
