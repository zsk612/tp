package workout.workoutsession;

import exceptions.workout.workoutsession.AddFormatException;
import exceptions.workout.workoutsession.DeleteFormatException;

import models.Exercise;

import java.util.Arrays;


public class WorkoutSessionParser {

    public static String[] workoutSessionParser(String input) {

        return input.split(" ");
    }

    public static Exercise addParser(String[] input) throws NumberFormatException, AddFormatException {
        String[] returnString = new String[4];
        Arrays.fill(returnString, "");
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
        int repetitions = Integer.parseInt(returnString[2]);
        double weight = Double.parseDouble(returnString[3]);
        String description = returnString[1].trim();
        if (repetitions < 0 || weight < 0 || description.length() <= 0) {
            throw new AddFormatException();
        }

        return new Exercise(description, repetitions, weight);
    }


    public static int deleteParser(String[] input) throws DeleteFormatException {
        int returnInt;
        try {
            returnInt = Integer.parseInt(input[1]);
        } catch (NumberFormatException e) {
            throw new DeleteFormatException();
        }
        return returnInt;
    }

    public static String searchParser(String[] input) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 1; i < input.length; i++) {
            returnString.append(" ").append(input[i]);
        }
        return returnString.toString().trim();
    }
}
