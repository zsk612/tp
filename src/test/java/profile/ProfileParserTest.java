package profile;

import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidCommandFormatException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static profile.ProfileParser.extractCommandTagAndInfo;

class ProfileParserTest {

    @Test
    void testParseCommand_inputTwoWords_returnNonEmptyStringInSecondElement() {
        ProfileParser profileParser = new ProfileParser();
        String rawUserInput = "add /n";
        String[] expectedSplit = {"add", "/n"};

        assertEquals(Arrays.toString(expectedSplit),
                Arrays.toString(profileParser.parseCommand(rawUserInput)));
    }

    @Test
    void testParseCommand_inputOneWord_returnEmptyStringInSecondElement() {
        ProfileParser profileParser = new ProfileParser();
        String rawUserInput = "add";
        String[] expectedSplit = {"add", ""};

        assertEquals(Arrays.toString(expectedSplit),
                Arrays.toString(profileParser.parseCommand(rawUserInput)));
    }

    @Test
    void testExtractCommandTagAndInfo_missingSplashInput_throwInvalidCommandFormatException() {
        assertThrows(InvalidCommandFormatException.class, () ->
                extractCommandTagAndInfo("add", "add n Schwarzenegger"));
    }

    @Test
    void testExtractCommandTagAndInfo_excessiveSplashInput_throwInvalidCommandFormatException() {
        assertThrows(InvalidCommandFormatException.class, () ->
                extractCommandTagAndInfo("add", "add //n Schwarzenegger"));
    }

    @Test
    void testExtractCommandTagAndInfo_validInput_returnValidParsedParams() throws SchwarzeneggerException {
        HashMap<String, String> parsedParams = new HashMap<>();
        parsedParams.put("/n", "Schwarzenegger");
        parsedParams.put("/c", "2500");
        parsedParams.put("/h", "188");
        parsedParams.put("/w", "113");
        parsedParams.put("/e", "100");

        String command = "add";
        String commandArgs = "/n Schwarzenegger /c 2500 /h 188 /w 113 /e 100";

        assertEquals(parsedParams.toString(), extractCommandTagAndInfo(command, commandArgs).toString());
    }
}
