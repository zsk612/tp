package diet.dietsession;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DietSessionTest {
    static final String FILEPATH = "/saves/diet/";

    /* @Test
    void testSaveDietSession_noInput_returnsDietSession() throws FileNotFoundException {
        SchwarzeneggerLogger.initSchwarzeneggerLogger();
        DietManagerUi dietManagerUi = new DietManagerUi();
        Storage storage = new Storage();
        DietSession ds = new DietSession(dietManagerUi.extractMeal(null), dietManagerUi.extractDate(null));
        ds.saveToFile();
        assertEquals(ds, storage.readDietSession(dietManagerUi.extractMeal(null) + " "
                + dietManagerUi.extractDate(null) + ".json"));
    }

     */
}
