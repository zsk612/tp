package commands.diet.dietmanager.command;

import storage.diet.Storage;

import java.io.File;

public class DietSessionDelete implements Command {
    static final String FILEPATH = "saves/diet/";

    @Override
    public void execute(String input, Storage storage) {
        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();
        try {
            assert !input.isEmpty();
            int index = Integer.parseInt(input);
            assert listOfFiles != null;
            String fileName = listOfFiles[Integer.parseInt(input) - 1].getName();
            System.out.println("Oh no! You have deleted " + fileName);
            listOfFiles[Integer.parseInt(input) - 1].delete();
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Sorry! It seems like you've entered an invalid number or input!");
        }
    }
}
