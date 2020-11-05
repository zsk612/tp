package diet.dietmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@@author CFZeon
public class DietManagerParserTest {

    @Test
    void parseString_ValidInput_Success() {
        String input = "First Second";
        DietManagerParser parser = new DietManagerParser();
        String[] expected = {"First", "Second"};
        String[] result = parser.parse(input);
        assertTrue(Arrays.equals(expected, result));
    }

    @Test
    void parseString_InvalidInput_Failure() {
        String input = "FirstSecond";
        DietManagerParser parser = new DietManagerParser();
        String[] expected = {"First", "Second"};
        String[] result = parser.parse(input);
        Assertions.assertFalse(Arrays.equals(expected, result));
    }
}
