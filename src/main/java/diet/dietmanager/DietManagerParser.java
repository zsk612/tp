package diet.dietmanager;

public class DietManagerParser {

    /**
     * Parses user input to extract command words and instructions.
     * @param comm user input for command
     * @return a string array containing command words and instructions
     */
    public String[] parse(String comm) {
        if (comm.contains(" ")) {
            return comm.split(" ", 2);
        } else {
            return new String[]{comm, "filler"};
        }
    }
}
