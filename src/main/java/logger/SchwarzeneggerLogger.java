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
    private static SchwarzeneggerLogger singleInstance = null;
    private Logger logger;

    /**
     * Constructs SchwarzeneggerLogger object.
     */
    private SchwarzeneggerLogger() {
        try {
            File file = new File(LOG_FILE_PATH);
            file.getParentFile().mkdirs();
            file.createNewFile();

            SimpleFormatter formatter = new SimpleFormatter();
            FileHandler fh = new FileHandler(LOG_FILE_PATH);
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

    /**
     * Gets logger attribute of SchwarzeneggerLogger.
     *
     * @return Logger.
     */
    public static Logger getInstanceLogger() {
        if (singleInstance == null) {
            singleInstance = new SchwarzeneggerLogger();
        }
        return singleInstance.logger;
    }
}
