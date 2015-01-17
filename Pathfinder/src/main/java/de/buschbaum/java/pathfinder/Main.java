package de.buschbaum.java.pathfinder;

import de.buschbaum.java.pathfinder.device.dcmotors.MotorController;
import de.buschbaum.java.pathfinder.logic.PositionController;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {
        try {
            initialize();
            while (true) {
                run();
            }
        } catch (Exception e) {
            System.err.println(e);
            MotorController.stop();
        }
    }

    private static void run() throws Exception {
        PositionController.update();
    }

    private static void initialize() throws Exception {
        MotorController.initialize();
        PositionController.initialize();
    }
}
