package diet.dietmanager;

import diet.dietsession.DietSessionParser;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import diet.dietmanager.DietManagerParser;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class DietManagerParserTest {

    @Test
    void processFoodName_ValidInput_Success() {
        String input = "Food /c 123";
        DietSessionParser parser = new DietSessionParser();
        String expected = "Food ";
        String result = parser.processFoodName(input);
        assertEquals(expected, result);
    }

    @Test
    void processFoodCalories_ValidInput_Success() {
        String input = "Food /c 123";
        DietSessionParser parser = new DietSessionParser();
        Double expected = 123.0;
        double result = parser.processFoodCalories(input);
        assertEquals(expected, result);
    }

    @Test
    void parseDate_ValidInput_Success() {
        DietSessionParser parser = new DietSessionParser();
        LocalDate expected = LocalDate.parse("2020-05-04");
        String input = "04/05/2020";
        LocalDate actual = parser.parseDate(input);
        assertEquals(expected, actual);
    }
}
