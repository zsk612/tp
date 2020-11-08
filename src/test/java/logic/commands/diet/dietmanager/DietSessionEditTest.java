package logic.commands.diet.dietmanager;

import logic.commands.CommandResult;
import org.junit.jupiter.api.Test;
import storage.diet.DietStorage;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.diet.dietmanager.DietManagerUi.*;

//@@author CFZeon
public class DietSessionEditTest {
    private static String EMPTY_STRING = "";

    @Test
    void testExecute_validInput_success() {
        String editInput = "1";
        DietStorage storage = new DietStorage();
        // to ensure there is something to edit
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        new DietSessionCreate().execute(EMPTY_STRING, storage);
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        CommandResult result = new DietSessionEdit().execute(editInput, storage);
        assertEquals(DIET_NEW_SUCCESS, result.getFeedbackMessage());
    }

    @Test
    void testExecute_invalidInput_resultArrayOutOfBound() {
        String editInput = "0";
        DietStorage storage = new DietStorage();
        // to ensure there is something to edit
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        new DietSessionCreate().execute(EMPTY_STRING, storage);
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        CommandResult result = new DietSessionEdit().execute(editInput, storage);
        assertEquals(DIET_FILE_ARRAY_OUT_OF_BOUND, result.getFeedbackMessage());
    }

    @Test
    void testExecute_emptyInput_resultEditWrongFormat() {
        String editInput = "";
        DietStorage storage = new DietStorage();
        // to ensure there is something to edit
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        new DietSessionCreate().execute(EMPTY_STRING, storage);
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        CommandResult result = new DietSessionEdit().execute(editInput, storage);
        assertEquals(DIET_EDIT_WRONG_FORMAT, result.getFeedbackMessage());
    }
}
