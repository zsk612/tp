package diet.dietmanager;

import commands.CommandLib;
import commands.diet.dietmanager.DietSessionClear;
import commands.diet.dietmanager.DietSessionCreate;
import commands.diet.dietmanager.DietSessionDelete;
import commands.diet.dietmanager.DietSessionEdit;
import commands.diet.dietmanager.DietSessionHelp;
import commands.diet.dietmanager.DietSessionList;
import commands.diet.dietmanager.DietSessionWrong;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandLibTest {
    @Test
    void get_DietManagerUnrecognisedCommand_returnNull() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("asdf") instanceof DietSessionWrong);
    }

    @Test
    void get_list_returnListCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("list") instanceof DietSessionList);
    }

    @Test
    void get_delete_returnDeleteCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("delete") instanceof DietSessionDelete);
    }

    @Test
    void get_new_returnNewCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("new") instanceof DietSessionCreate);
    }

    @Test
    void get_clear_returnClearCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("clear") instanceof DietSessionClear);
    }

    @Test
    void get_edit_returnEditCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("edit") instanceof DietSessionEdit);
    }

    @Test
    void get_help_returnHelpCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.getCommand("help") instanceof DietSessionHelp);
    }
}
