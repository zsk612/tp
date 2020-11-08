package logic.commands.diet.dietmanager;

import logic.commands.CommandResult;
import org.junit.jupiter.api.Test;
import storage.diet.DietStorage;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.diet.dietmanager.DietManagerUi.*;

//@@author CFZeon
public class DietSessionDeleteTest {
    private static String EMPTY_STRING = "";

    @Test
    void testExecute_validInput_success() {
        String deleteInput = "1";
        DietStorage storage = new DietStorage();
        // to ensure there is something to delete
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        new DietSessionCreate().execute(EMPTY_STRING, storage);
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        CommandResult result = new DietSessionDelete().execute(deleteInput, storage);
        assertEquals(DIET_DELETE_SUCCESS, result.getFeedbackMessage());
    }

    @Test
    void testExecute_outOfBoundsInput_resultOutOfBounds() {
        String deleteInput = "0";
        DietStorage storage = new DietStorage();
        // to ensure there is something to delete
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        new DietSessionCreate().execute(EMPTY_STRING, storage);
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        CommandResult result = new DietSessionDelete().execute(deleteInput, storage);
        assertEquals(DIET_FILE_ARRAY_OUT_OF_BOUND, result.getFeedbackMessage());
    }

    @Test
    void testExecute_wrongInput_resultDeleteWrongFormat() {
        String deleteInput = "a";
        DietStorage storage = new DietStorage();
        // to ensure there is something to delete
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        new DietSessionCreate().execute(EMPTY_STRING, storage);
        System.setIn(new ByteArrayInputStream("end".getBytes()));
        CommandResult result = new DietSessionDelete().execute(deleteInput, storage);
        assertEquals(DIET_DELETE_WRONG_FORMAT, result.getFeedbackMessage());
    }
}
