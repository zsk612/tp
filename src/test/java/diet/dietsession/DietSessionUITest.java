package diet.dietsession;

import diet.dietmanager.DietManagerUI;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DietSessionUITest {

    @Test
    void extractDate_dateCorrectFormat_returnsDateString() {
        String input = "/d 2020-11-11 /t lunch";
        DietManagerUI ui = new DietManagerUI();
        String dateString = ui.extractDate(input);
        assertEquals(dateString, "11-11-2020");
    }

    @Test
    void extract_dateWrongFormat_expectsException() {
        String input = "/d 2020-22-22 /t lunch";
        DietManagerUI ui = new DietManagerUI();
        assertThrows(DateTimeParseException.class, () -> ui.extractDate(input));
    }
}
