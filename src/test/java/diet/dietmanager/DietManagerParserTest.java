package diet.dietmanager;

import exceptions.InvalidDateFormatException;
import exceptions.profile.InvalidCommandFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static logic.parser.ProfileParser.extractCommandTagAndInfo;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void extractTagAndInfo_missingSlashInput_Success() {
        assertThrows(InvalidCommandFormatException.class, () ->
                extractCommandTagAndInfo("search", "t breakfast"));
    }
    @Test
    void extractTagAndInfo_multipleSlashInput_throwInvalidCommandFormatException() {
        assertThrows(InvalidCommandFormatException.class, () ->
                extractCommandTagAndInfo("search", "//t breakfast"));
    }

    @Test
    void extractNewDate_ValidDateInput_Success() throws InvalidCommandFormatException, InvalidDateFormatException {
        String input = "/d 2020-05-04";
        String expected = "04-05-2020";
        StringBuilder message = new StringBuilder();
        DietManagerParser parser = new DietManagerParser();
        HashMap<String, String> parsedParams = parser.extractDietManagerCommandTagAndInfo("new", input);
        String extractedDate = parser.extractNewDate(parsedParams, message);
        assertEquals(expected, extractedDate);
    }

    @Test
    void extractNewDate_InvalidDateInput_throwInvalidDateFormatException() {
        String input = "/d 2020-05-04";
        String expected = "04-05-2020";
        StringBuilder message = new StringBuilder();
        DietManagerParser parser = new DietManagerParser();
        HashMap<String, String> parsedParams = parser.extractDietManagerCommandTagAndInfo("new", input);
        String extractedDate = parser.extractNewDate(parsedParams, message);
        assertEquals(expected, extractedDate);
    }
}
