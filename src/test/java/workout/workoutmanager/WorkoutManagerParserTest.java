package workout.workoutmanager;

import org.junit.jupiter.api.Test;
import models.PastWorkoutSessionRecord;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static workout.workoutmanager.WorkoutManagerParser.parseSearchConditions;
import static workout.workoutmanager.WorkoutManagerParser.parseTags;

class WorkoutManagerParserTest {

    @Test
    void parseTags_ValidInput_Success() {
        String args = "/t legs, chest";
        ArrayList<String> result = parseTags(args);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("legs");
        expected.add("chest");
        assertEquals(expected, result);
    }

    @Test
    void parseTags_MissingOrWrongIdentifierKey_Empty() {
        String in1 = "/tt legs chest";
        ArrayList<String> out1 = parseTags(in1);
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, out1);

        String in2 = "legs /t chest";
        ArrayList<String> out2 = parseTags(in2);
        assertEquals(expected, out2);

        String in3 = "legs chest";
        ArrayList<String> out3 = parseTags(in3);
        assertEquals(expected, out3);
    }

    @Test
    void parseSearchConditions_CorrectDateTagCondition_success() {
        List<String> tg = Arrays.asList("legs", "chest");
        ArrayList<String> tags = new ArrayList<>(tg);

        LocalDateTime date = LocalDateTime.of(2020,
                10,
                17,
                12,
                0);
        PastWorkoutSessionRecord record = new PastWorkoutSessionRecord("random",
                date, date, tags);
        String in1 = "/d 20201017";
        List<Boolean> expected1 = Arrays.asList(true);
        ArrayList<Boolean> testResults1 = new ArrayList<>();
        ArrayList<Predicate<PastWorkoutSessionRecord>> tests = parseSearchConditions(in1);

        for (Predicate<PastWorkoutSessionRecord> t : tests) {
            testResults1.add(t.test(record));
        }
        assertEquals(expected1, testResults1);

        String in2 = "/d 20201017 /t arms";
        List<Boolean> expected2 = Arrays.asList(false, true);
        ArrayList<Boolean> testResults2 = new ArrayList<>();
        tests = parseSearchConditions(in2);

        for (Predicate<PastWorkoutSessionRecord> t : tests) {
            testResults2.add(t.test(record));
        }
        assertEquals(expected2, testResults2);

        String in3 = "/d 20201017 /t legs, chest";
        List<Boolean> expected3 = Arrays.asList(true, true);
        ArrayList<Boolean> testResults3 = new ArrayList<>();
        tests = parseSearchConditions(in3);

        for (Predicate<PastWorkoutSessionRecord> t : tests) {
            testResults3.add(t.test(record));
        }
        assertEquals(expected3, testResults3);
    }

    @Test
    void parseSearchConditions_WrongConditionFormat_EmptyChecks() {
        List<String> tg = Arrays.asList("legs", "chest");
        ArrayList<String> tags = new ArrayList<>(tg);

        LocalDateTime date = LocalDateTime.of(2020,
                10,
                17,
                12,
                0);
        PastWorkoutSessionRecord record = new PastWorkoutSessionRecord("random",
                date, date, tags);
        String in1 = "20201017 /d";
        List<Boolean> expected1 = new ArrayList<>();
        ArrayList<Boolean> testResults1 = new ArrayList<>();
        ArrayList<Predicate<PastWorkoutSessionRecord>> tests = parseSearchConditions(in1);

        for (Predicate<PastWorkoutSessionRecord> t : tests) {
            testResults1.add(t.test(record));
        }
        assertEquals(expected1, testResults1);

        String in2 = "20201017 arms";
        List<Boolean> expected2 = new ArrayList<>();
        ArrayList<Boolean> testResults2 = new ArrayList<>();
        tests = parseSearchConditions(in2);

        for (Predicate<PastWorkoutSessionRecord> t : tests) {
            testResults2.add(t.test(record));
        }
        assertEquals(expected2, testResults2);
    }

}