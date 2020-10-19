package logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static seedu.duke.Constant.LOG_FILE_PATH;

/**
 * A class to handle file logging.
 */
public class SchwarzeneggerLogger {
    public static Logger logger;
    private static FileHandler fh;

    /**
     * Initialises SchwarzeneggerLogger object.
     */
    public static void initSchwarzeneggerLogger() {
        try {
            File file = new File(LOG_FILE_PATH);
            file.getParentFile().mkdirs();
            file.createNewFile();

            SimpleFormatter formatter = new SimpleFormatter();
            fh = new FileHandler(LOG_FILE_PATH, true);
            fh.setFormatter(formatter);

            logger = Logger.getLogger("SchwarzeneggerLogger");
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
