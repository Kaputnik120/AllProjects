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
        final int duration = 5000;
        
//        long started = System.nanoTime();
//        MotorController.test();
//        TimingController.timeSlot(duration, started);
//        started = System.nanoTime();
//        MotorController.stop();
//        TimingController.timeSlot(duration, started);
        
        
        long started = System.nanoTime();
        MotorController.driveForward();
        TimingController.timeSlot(duration, started);
        started = System.nanoTime();
        MotorController.stop();
        TimingController.timeSlot(duration, started);
        
        started = System.nanoTime();
        MotorController.turnLeft();
        TimingController.timeSlot(duration, started);
        started = System.nanoTime();
        MotorController.stop();
        TimingController.timeSlot(duration, started);
        
        started = System.nanoTime();
        MotorController.driveBackward();
        TimingController.timeSlot(duration, started);
        started = System.nanoTime();
        MotorController.stop();
        TimingController.timeSlot(duration, started);
        
        started = System.nanoTime();
        MotorController.turnRight();
        TimingController.timeSlot(duration, started);
        started = System.nanoTime();
        MotorController.stop();
        TimingController.timeSlot(duration, started);
    }

    private static void initialize() throws Exception {
        MotorController.initialize();
        PositionController.initialize();
    }
}
