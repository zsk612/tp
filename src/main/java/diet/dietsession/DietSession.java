package diet.dietsession;

import diet.dietsession.command.Command;

import java.util.ArrayList;

public class DietSession {
    public ArrayList<Food> foodList;

    private final DietSessionUI dietSessionUI;
    private final diet.dietsession.CommandLib cl;
    private final DietSessionParser parser = new DietSessionParser();
    public boolean endDietSession = false;

    public DietSession() {
        this.cl = new CommandLib();
        this.foodList = new ArrayList<>();
        dietSessionUI = new DietSessionUI();
    }

    public void setEndDietSession(Boolean hasEnded) {
        this.endDietSession = hasEnded;
    }

//    public void Start() {
//
//        setEndDietSession(false);
//
//
//        String input = dietSessionUI.getInput();
//        while (!input.equals("end")) {
//            parser.dietSessionProcessCommand(input, foodList);
//            input = dietSessionUI.getInput();
//        }
//        setEndDietSession(true);
//
//    }

    public void start() {
        dietSessionUI.printOpening();
        setEndDietSession(false);
        String input = dietSessionUI.getInput();
        while(!input.equals("end")) {

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
        cl.initDietManagerCL();
        Command command = cl.get(commParts[0]);

        System.out.println("keyword: " + commParts[0]);
        System.out.println("description: " + commParts[1]);
        command.execute(commParts[1], foodList);
    }
}
