package workout.workoutsession;

import exceptions.workout.workoutsession.DeleteFormatException;
import ui.workout.workoutsession.WorkoutSessionUi;
import models.Exercise;

public class WorkoutSessionParser {

    public static String[] workoutSessionParser(String input) {

        return input.split(" ");
    }

    public static Exercise addParser(String[] input) throws NumberFormatException {
        Exercise exercise = null;

        String[] returnString = new String[4];
        for (int i = 0; i < returnString.length; i++) {
            returnString[i] = "";
        }
        int tracker = 0;
        for (String s : input) {
            if (s.compareTo("/n") == 0) {
                tracker = 2;
            } else if (s.compareTo("/w") == 0) {
                tracker = 3;
            } else if (s.compareTo("add") == 0) {
                tracker = 1;
            } else if (tracker == 2 || tracker == 3) {
                returnString[tracker] = s;
            } else {
                returnString[tracker] += (s + " ");
            }
        }
        exercise = new Exercise(returnString[1].trim(), Integer.parseInt(returnString[2]),
                Integer.parseInt(returnString[3]));

        return exercise;
    }


    public static int deleteParser(String[] input) throws DeleteFormatException {
        int returnInt = 0;
        try {
            returnInt = Integer.parseInt(input[1]);
        } catch (NumberFormatException e) {
            throw new DeleteFormatException();
        }
        return returnInt;
    }

    public static String searchParser(String[] input) {
        String returnString = new String();
        for (int i = 1; i < input.length; i++) {
            returnString += input[i];
        }
        return returnString.trim();
    }
}
