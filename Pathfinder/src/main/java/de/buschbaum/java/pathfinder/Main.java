package de.buschbaum.java.pathfinder;

import de.buschbaum.java.pathfinder.device.dcmotors.MotorController;
import de.buschbaum.java.pathfinder.logic.PositionController;
import de.buschbaum.java.pathfinder.logic.TimingController;

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
        long started = System.nanoTime();
        MotorController.driveForward();
        TimingController.timeSlot(2000, started);
        started = System.nanoTime();
        MotorController.stop();
        TimingController.timeSlot(2000, started);
        
        started = System.nanoTime();
        MotorController.turnLeft();
        TimingController.timeSlot(2000, started);
        started = System.nanoTime();
        MotorController.stop();
        TimingController.timeSlot(2000, started);
        
        started = System.nanoTime();
        MotorController.driveBackward();
        TimingController.timeSlot(2000, started);
        started = System.nanoTime();
        MotorController.stop();
        TimingController.timeSlot(2000, started);
        
        started = System.nanoTime();
        MotorController.turnRight();
        TimingController.timeSlot(2000, started);
        started = System.nanoTime();
        MotorController.stop();
        TimingController.timeSlot(2000, started);
    }

    private static void initialize() throws Exception {
        MotorController.initialize();
        PositionController.initialize();
    }
}
