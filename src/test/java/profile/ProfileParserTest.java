package profile;

import commands.profile.AddProfile;
import commands.profile.DeleteProfile;
import commands.profile.EditProfile;
import commands.profile.EndProfile;
import commands.profile.HelpProfile;
import commands.profile.ViewProfile;
import exceptions.profile.InvalidCommandFormatException;
import exceptions.profile.InvalidCommandWordException;
import exceptions.profile.RedundantParamException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static profile.ProfileParser.extractCommandTagAndInfo;

class ProfileParserTest {

    @Test
    void testParseCommand_inputAdd_returnAddProfile() throws RedundantParamException, InvalidCommandWordException {
        ProfileParser profileParser = new ProfileParser();
        String testUserInputString = "add /n Schwarzenegger /a 30 /h 188 /w 113 /e 100";

        assertTrue(profileParser.parseCommand(testUserInputString) instanceof AddProfile);
    }

    @Test
    void testParseCommand_inputHelp_returnHelpProfile() throws RedundantParamException, InvalidCommandWordException {
        ProfileParser profileParser = new ProfileParser();
        String testUserInputString = "help";

        assertTrue(profileParser.parseCommand(testUserInputString) instanceof HelpProfile);
    }

    @Test
    void testParseCommand_inputDelete_returnDeleteProfile() throws RedundantParamException,
            InvalidCommandWordException {
        ProfileParser profileParser = new ProfileParser();
        String testUserInputString = "delete";

        assertTrue(profileParser.parseCommand(testUserInputString) instanceof DeleteProfile);
    }

    @Test
    void testParseCommand_inputView_returnViewProfile() throws RedundantParamException, InvalidCommandWordException {
        ProfileParser profileParser = new ProfileParser();
        String testUserInputString = "view";

        assertTrue(profileParser.parseCommand(testUserInputString) instanceof ViewProfile);
    }

    @Test
    void testParseCommand_inputEdit_returnEditProfile() throws RedundantParamException, InvalidCommandWordException {
        ProfileParser profileParser = new ProfileParser();
        String testUserInputString = "edit /w 80";

        assertTrue(profileParser.parseCommand(testUserInputString) instanceof EditProfile);
    }

    @Test
    void testParseCommand_inputEnd_returnEndProfile() throws RedundantParamException, InvalidCommandWordException {
        ProfileParser profileParser = new ProfileParser();
        String testUserInputString = "end";

        assertTrue(profileParser.parseCommand(testUserInputString) instanceof EndProfile);
    }

    @Test
    void testParseCommand_invalidInput_throwInvalidCommandWordException() throws RedundantParamException {
        ProfileParser profileParser = new ProfileParser();
        String testUserInputString = "test";

        assertThrows(InvalidCommandWordException.class, () -> {
            profileParser.parseCommand(testUserInputString);
        });
    }

    @Test
    void testSplitCommandWordAndArgs_inputTwoWords_returnNonEmptyStringInSecondElement() {
        ProfileParser profileParser = new ProfileParser();
        String rawUserInput = "add /n";
        String[] expectedSplit = {"add", "/n"};

        assertEquals(Arrays.toString(expectedSplit),
                Arrays.toString(profileParser.splitCommandWordAndArgs(rawUserInput)));
    }

    @Test
    void testSplitCommandWordAndArgs_inputOneWord_returnEmptyStringInSecondElement() {
        ProfileParser profileParser = new ProfileParser();
        String rawUserInput = "add";
        String[] expectedSplit = {"add", ""};

        assertEquals(Arrays.toString(expectedSplit),
                Arrays.toString(profileParser.splitCommandWordAndArgs(rawUserInput)));
    }

    @Test
    void testExtractCommandTagAndInfo_missingSplashInput_throwInvalidCommandFormatException() {
        assertThrows(InvalidCommandFormatException.class, () -> {
            extractCommandTagAndInfo("add", "add n Schwarzenegger");
        });
    }

    @Test
    void testExtractCommandTagAndInfo_excessiveSplashInput_throwInvalidCommandFormatException() {
        assertThrows(InvalidCommandFormatException.class, () -> {
            extractCommandTagAndInfo("add", "add //n Schwarzenegger");
        });
    }

    @Test
    void testExtractCommandTagAndInfo_validInput_returnValidParsedParams() throws InvalidCommandFormatException {
        HashMap<String, String> parsedParams = new HashMap<>();
        parsedParams.put("/n", "Schwarzenegger");
        parsedParams.put("/a", "30");
        parsedParams.put("/h", "188");
        parsedParams.put("/w", "113");
        parsedParams.put("/e", "100");

        String command = "add";
        String commandArgs = "/n Schwarzenegger /a 30 /h 188 /w 113 /e 100";

        assertEquals(parsedParams.toString(), extractCommandTagAndInfo(command, commandArgs).toString());
    }
}
