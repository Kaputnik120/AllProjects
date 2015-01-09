package de.buschbaum.java.pathfinder;

import de.buschbaum.java.pathfinder.common.Configuration;
import de.buschbaum.java.pathfinder.logic.PositionController;
import de.buschbaum.java.pathfinder.logic.TimingController;

/**
 * Hello world!
 *
 */
public class Main {
   
    public static void main(String[] args) throws Exception {
        initialize();
        while (true) {
            run();
        }
    }

    private static void run() throws Exception {
        PositionController.update();
        TimingController.timeSlot(Configuration.TIME_SLOT_LENGTH, System.nanoTime());
    }

    private static void initialize() throws Exception {
        PositionController.initialize();
    }
}
