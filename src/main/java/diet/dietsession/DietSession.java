package diet.dietsession;

import diet.dietsession.command.Command;
import storage.diet.Storage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DietSession {
    private final ArrayList<Food> foodList;

    private String dateInput;
    private String typeInput;
    private LocalDate date;

    private final DietSessionUI dietSessionUI;
    private final diet.dietsession.CommandLib cl;
    private final Storage storage;
    private final DietSessionParser parser = new DietSessionParser();
    public boolean endDietSession = false;

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
        storage.writeToStorageDietSession(typeInput + " " + date.toString(), this);

        dietSessionUI.printExit();
    }

    public void processCommand(String input) throws NullPointerException {
        String[] commParts = parser.parse(input);
        Command command = cl.get(commParts[0]);
        command.execute(commParts[1], foodList, storage);
    }
}
