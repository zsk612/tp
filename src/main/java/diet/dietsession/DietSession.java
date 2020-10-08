package diet.dietsession;

import diet.dietsession.command.Command;
import storage.DietSessionStorage;

import java.util.ArrayList;
import java.util.Date;

public class DietSession {
    private final ArrayList<Food> foodList;

    private String dateInput;
    private String mealInput;

    private final DietSessionUI dietSessionUI;
    private final diet.dietsession.CommandLib cl;
    private final DietSessionStorage storage;
    private final DietSessionParser parser = new DietSessionParser();
    public boolean endDietSession = false;

    public DietSession(String dateInput, String mealInput) {
        this.cl = new CommandLib();
        cl.initDietManagerCL();
        this.dateInput = dateInput;
        this.mealInput = mealInput;
        this.foodList = new ArrayList<>();
        storage = new DietSessionStorage();
        dietSessionUI = new DietSessionUI();
    }

    public String getDateInput() {
        return dateInput;
    }

    public String getMealInput() {
        return mealInput;
    }

    public void setEndDietSession(Boolean hasEnded) {
        this.endDietSession = hasEnded;
    }

    public void start() {
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
        dietSessionUI.printExit();
    }

    public void processCommand(String input) throws NullPointerException {
        String[] commParts = parser.parse(input);
        Command command = cl.get(commParts[0]);
        command.execute(commParts[1], foodList, storage);
    }
}
