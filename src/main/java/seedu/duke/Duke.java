package seedu.duke;

import profile.Profile;
import profile.exceptions.SchwarzeneggerException;
import profile.storage.Storage;
import profile.ui.ProfileUi;

public class Duke {
    ProfileUi profileUi;
    Storage storage;
    Profile profile;

    public Duke() {
        try {
            profileUi = new ProfileUi();
            storage = new Storage();
            profile = storage.loadData();

            if (!storage.getHasExistingDataFile()) {
                profile = profileUi.getFirstTimeProfile();
                storage.saveData(profile);
            } else {
                profileUi.showToUser(profile.toString());
            }
        } catch (SchwarzeneggerException e) {
            profileUi.showToUser(e.getMessage());
        } catch (Exception e) {
            profileUi.showToUser(e.toString());
        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke().run();
    }

    private void run() {
        start();
    }

    private void start() {
        profileUi.greetUser();
    }
}
