package diet.dietmanager;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@@author CFZeon
public class DietManagerTest {
    private static final String TEST_SAVES_FOLDER_DIET = "src/test/java/diet/dietmanager/saves/";
    private static final String TEST_DATE = "2020-04-04";
    private static final Double TEST_CALORIES = 444.0;

    @Test
    void getDateTotalCalories_validInput_returnDouble() {
        DietManager dietManager = new DietManager();
        LocalDate date = LocalDate.parse(TEST_DATE);
        Double expected = TEST_CALORIES;
        Double totalCalories = dietManager.getDateTotalCalories(TEST_SAVES_FOLDER_DIET, date);
        assertEquals(expected, totalCalories);
    }
}
