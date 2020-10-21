package diet.dietmanager;

import commands.CommandLib;
import commands.diet.dietmanager.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandLibTest {
    @Test
    void get_DietManagerUnrecognisedCommand_returnNull() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.get("asdf") instanceof DietSessionWrong);
    }

    @Test
    void get_list_returnListCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.get("list") instanceof DietSessionList);
    }

    @Test
    void get_delete_returnDeleteCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.get("delete") instanceof DietSessionDelete);
    }

    @Test
    void get_new_returnNewCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.get("meal") instanceof DietSessionCreate);
    }

    @Test
    void get_clear_returnClearCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.get("clear") instanceof DietSessionClear);
    }

    @Test
    void get_edit_returnEditCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.get("edit") instanceof DietSessionEdit);
    }

    @Test
    void get_help_returnHelpCommand() {
        CommandLib cl = new CommandLib();
        cl.initDietManagerCL();
        assertTrue(cl.get("help") instanceof DietSessionHelp);
    }
}
