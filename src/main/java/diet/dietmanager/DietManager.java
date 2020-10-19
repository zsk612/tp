package diet.dietmanager;

import commands.CommandLib;
import commands.Command;
import logger.SchwarzeneggerLogger;
import storage.diet.Storage;
import ui.diet.dietmanager.DietManagerUi;

import java.util.logging.Logger;


public class DietManager {

    private final CommandLib cl;
    private final DietManagerParser parser;
    private final DietManagerUi dietManagerUI;
    private final Storage storage;
    private final Logger logger;

    public DietManager(SchwarzeneggerLogger schwarzeneggerLogger) {
        logger = schwarzeneggerLogger.getLogger();
        storage = new Storage(logger);
        cl = new CommandLib();
        cl.initDietManagerCL();
        parser = new DietManagerParser();
        dietManagerUI = new DietManagerUi();
    }

    public void start() {
        DietManagerUi.printOpening();
        String input = dietManagerUI.getInput();
        while (!input.equals("end")) {
            try {
                processCommand(input);
            } catch (ExitException e) {
                System.out.println(e.getMessage());
                break;
            }
            input = dietManagerUI.getInput();
        }
        System.out.println("you have exited Diet Manager.");
    }

    public void processCommand(String input) throws ExitException {
        String[] commParts = parser.parse(input.trim());
        assert !commParts[0].isEmpty();
        Command command = cl.get(commParts[0]);
        assert !commParts[1].isEmpty();
        command.execute(commParts[1], storage, logger);
    }
}
