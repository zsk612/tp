package diet.dietsession;

import diet.dietsession.command.Command;
import storage.diet.Storage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> 62fd2c83c5d18eef0a090f6d0c813ed0a9d47d2b

public class DietSession {
    private final ArrayList<Food> foodList;

    private final String dateInput;
    private final String typeInput;
    private final LocalDate date;

    private final DietSessionUI dietSessionUI;
    private final diet.dietsession.CommandLib cl;
    private final Storage storage;
    private final DietSessionParser parser = new DietSessionParser();
    public boolean endDietSession = false;

<<<<<<< HEAD
=======
    private static Logger logger = Logger.getLogger("java.diet.dietsession");

>>>>>>> 62fd2c83c5d18eef0a090f6d0c813ed0a9d47d2b
    public DietSession(String typeInput, String dateInput) {
        this.cl = new CommandLib();
        cl.initDietManagerCL();
        this.dateInput = dateInput;
        this.date = parser.parseDate(dateInput);
        this.typeInput = typeInput;
        this.foodList = new ArrayList<>();
        storage = new Storage();
        dietSessionUI = new DietSessionUI();
    }

    public String getDateInput() {
        return dateInput;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTypeInput() {
        return typeInput;
    }

    public void setEndDietSession(Boolean hasEnded) {
        this.endDietSession = hasEnded;
    }

    public void start() throws IOException {
<<<<<<< HEAD
=======
        logger.log(Level.INFO, "starting profile session");
>>>>>>> 62fd2c83c5d18eef0a090f6d0c813ed0a9d47d2b
        dietSessionUI.printOpening();
        setEndDietSession(false);
        String input = dietSessionUI.getInput();
        while (!input.equals("end")) {

            try {
                processCommand(input);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                break;
            }
            input = dietSessionUI.getInput();
        }
        setEndDietSession(true);
<<<<<<< HEAD

        storage.init(typeInput + " " + date.toString());
        storage.writeToStorageDietSession(typeInput + " " + date.toString(), this);
=======
        logger.log(Level.INFO, "saving profile session to file");
        try {
            storage.init(typeInput + " " + date.toString());
            storage.writeToStorageDietSession(typeInput + " " + date.toString(), this);
        } catch (IOException e) {
            logger.log(Level.WARNING, "save profile session failed");
            System.out.println("Failed to save your diet session!");
        }
>>>>>>> 62fd2c83c5d18eef0a090f6d0c813ed0a9d47d2b
        dietSessionUI.printExit();
    }

    public void processCommand(String input) throws NullPointerException {
        String[] commParts = parser.parse(input);
        Command command = cl.get(commParts[0]);
        command.execute(commParts[1], foodList, storage);
    }
}
