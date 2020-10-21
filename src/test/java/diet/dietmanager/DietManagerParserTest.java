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
    void parseString_ValidInput_Success() {
        String input = "First Second";
        DietManagerParser parser = new DietManagerParser();
        String[] expected = {"First", "Second"};
        String[] result = parser.parse(input);
        assertTrue(Arrays.equals(expected, result));
    }
}
