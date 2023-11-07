package main;

import it.sauronsoftware.junique.AlreadyLockedException;
import it.sauronsoftware.junique.JUnique;

import static application.MENU.LaunchGUI;

public class Main {
    public static void main(String[] args) {

        String appname = "Jean's office";
        boolean alreadyRunning;

        try {
            JUnique.acquireLock(appname);
            alreadyRunning = false;
        } catch (AlreadyLockedException e) {
            alreadyRunning = true;
        }
        if (!alreadyRunning) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    LaunchGUI(appname);
                }
            });
        }
    }
}