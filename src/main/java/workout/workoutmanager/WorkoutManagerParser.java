package workout.workoutmanager;

import models.PastWorkoutSessionRecord;
import workout.DateParser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class WorkoutManagerParser {

    private static final int NOTHING = 0;
    private static final int TAG = 1;
    private static final int DATE = 2;

    public static String[] parse(String comm) {
        return comm.split(" ");
    }

    public static ArrayList<String> parseTags(String[] arr) {
        ArrayList<String> result = new ArrayList<>();
        try {
            if (!arr[0].equals("/t")) {
                return result;
            }
            for (int i = 1; i < arr.length; i++) {
                if (!result.contains(arr[i])) {
                    result.add(arr[i]);
                }
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return result;
    }

    public static ArrayList<Predicate<PastWorkoutSessionRecord>> parseSearchConditions(String[] arr) {
        ArrayList<String> tags = new ArrayList<>();
        ArrayList<Predicate<PastWorkoutSessionRecord>> test = new ArrayList<>();
        int lookingFor = NOTHING;

        for (String s: arr) {
            if (s.equals("/t")) {
                lookingFor = TAG;
            } else if (s.equals("/d")) {
                lookingFor = DATE;
            } else if (lookingFor == TAG) {
                System.out.println("adding a tag");
                tags.add(s);
            } else if (lookingFor == DATE) {
                LocalDate finalDate = DateParser.parseDate(s).toLocalDate();
                if (finalDate != null) {
                    test.add(x -> x.isCreatedOn(finalDate));
                }
            }
        }

        test.add(x -> x.containsAll(tags));

        return test;
    }
}
