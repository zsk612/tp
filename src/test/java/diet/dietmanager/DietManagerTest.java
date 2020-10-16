package diet.dietmanager;

import diet.dietmanager.command.DietSessionCreate;
import diet.dietsession.DietSession;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DietManagerTest {

    @Test
    void testCreateDietSession_noInput_returnsDietSession() {
        DietManager dm = new DietManager();
        DietManagerUI ui = new DietManagerUI();
        DietSession ds = new DietSession(ui.extractMeal(null), ui.extractDate(null));

    }
}
