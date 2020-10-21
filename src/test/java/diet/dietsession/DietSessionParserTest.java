package diet.dietsession;

import diet.dietmanager.DietManagerParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DietSessionParserTest {
    @Test
    void parseString_ValidInput_Success() {
        String input = "First Second";
        DietManagerParser parser = new DietManagerParser();
        String[] expected = {"First", "Second"};
        String[] result = parser.parse(input);
        assertTrue(Arrays.equals(expected, result));
    }
}
