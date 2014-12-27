package de.buschbaum.java.pathfinder;

import de.buschbaum.java.pathfinder.device.mpu6050.Mpu6050Controller;
import de.buschbaum.java.pathfinder.logic.PositionController;
import de.buschbaum.java.pathfinder.logic.TimingController;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class Main {

    private static int TIME_SLOT_LENGTH = 8;

    public static void main(String[] args) throws Exception {
        initialize();
        while (true) {
            run();
        }
    }

    private static void run() throws Exception {
        PositionController.update();
//        int[] position = PositionController.getPosition();
//        System.out.println("Current position: " + position[0] + " / " + position[1]);
        TimingController.timeSlot(TIME_SLOT_LENGTH, System.nanoTime());
//        System.out.println("Date: " + new Date());
    }

    private static void initialize() throws Exception {
        System.out.println("Initializing Mpu6050");
        Mpu6050Controller.initialize();
        System.out.println("Mpu6050 initialized!");
    }
}
