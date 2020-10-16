package diet.dietsession;

import diet.dietmanager.DietManager;
import diet.dietmanager.DietManagerUI;
import storage.diet.Storage;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static profile.components.Constants.EXAMPLE_PROFILE_STRING;

public class DietSessionTest {
    static final String FILEPATH = "/saves/diet/";

    @Test
    void testSaveDietSession_noInput_returnsDietSession() throws FileNotFoundException {
        DietManagerUI dmui = new DietManagerUI();
        Storage storage = new Storage();
        DietSession ds = new DietSession(dmui.extractMeal(null), dmui.extractDate(null));
        ds.saveToFile();
        assertEquals(ds, storage.readDietSession(dmui.extractMeal(null) + " "
                + dmui.extractDate(null) + ".json"));
    }
}
