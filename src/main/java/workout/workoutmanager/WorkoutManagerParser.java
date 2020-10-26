package workout.workoutmanager;

import exceptions.workoutmanager.NotANumberException;
import logger.SchwarzeneggerLogger;
import models.PastWorkoutSessionRecord;
import workout.DateParser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;

public class WorkoutManagerParser {

    /**
     * Parses user inputs into single words.
     * @param comm User's raw input.
     * @return An array of strings.
     */
    public static String[] parseCommandKw(String comm) {
        return comm.split(" ", 2);
    }

    /**
     * Parses user input into a list of tags.
     * @param arr User inputs.
     * @return A list of tags.
     */
    public static ArrayList<String> parseTags(String arr) {
        ArrayList<String> result = new ArrayList<>();
        String[] content = arr.split(" ", 2);

        try {
            if (!content[0].equals("/t")) {
                return result;
            }
            String[] tags = content[1].split(",");
            for (String tag : tags) {
                if (!result.contains(tag.trim())) {
                    result.add(tag.trim());
                }
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return result;
    }

    /**
     * Parses user input into a list of predicates which will be used as search conditions.
     * @param arr User input.
     * @return A list of predicate which will be used as search conditions.
     */
    public static ArrayList<Predicate<PastWorkoutSessionRecord>> parseSearchConditions(String arr) {
        ArrayList<String> tags = new ArrayList<>();
        ArrayList<Predicate<PastWorkoutSessionRecord>> test = new ArrayList<>();

        try {
            String[] part1 = arr.split("/t");
            String[] tagPart = part1[1].split("/d");
            String[] tgs = tagPart[0].split(",");
            for (String t : tgs) {
                tags.add(t.trim());
            }
            test.add(x -> x.containsAll(tags));
        } catch (ArrayIndexOutOfBoundsException e) {
            SchwarzeneggerLogger.getInstanceLogger().log(Level.INFO, "No tag identifier is given.");
        }

        try {
            String[] part2 = arr.split("/d");
            String[] datePart = part2[1].split("/t");
            LocalDateTime finalDate = DateParser.parseDate(datePart[0].trim());
            if (finalDate != null) {
                test.add(x -> x.isCreatedOn(finalDate.toLocalDate()));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            SchwarzeneggerLogger.getInstanceLogger().log(Level.INFO, "No date identifier is given.");
        }

        return test;
    }

    public static int parseIndex(String args) throws NotANumberException {
        int index;
        try {
            index = Integer.parseInt(args);
        } catch (NumberFormatException e) {
            throw new NotANumberException();
        }
        return index;
    }

    public static ArrayList<Predicate<PastWorkoutSessionRecord>> parseList(String args) {
        ArrayList<Predicate<PastWorkoutSessionRecord>> test = new ArrayList<>();

        // catch start date
        try {
            String[] part2 = args.split("/s");
            String[] datePart = part2[1].split("/e");
            LocalDateTime start = DateParser.parseDate(datePart[0].trim());
            if (start != null) {
                test.add(x -> x.isCreatedAfter(start.toLocalDate()));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            SchwarzeneggerLogger.getInstanceLogger().log(Level.INFO, "No start date identifier is given.");
        }

        // catch end date
        try {
            String[] part2 = args.split("/e");
            String[] datePart = part2[1].split("/s");
            LocalDateTime end = DateParser.parseDate(datePart[0].trim());
            if (end != null) {
                test.add(x -> x.isCreatedBefore(end.toLocalDate()));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            SchwarzeneggerLogger.getInstanceLogger().log(Level.INFO, "No end date identifier is given.");
        }

        return test;
    }


}
