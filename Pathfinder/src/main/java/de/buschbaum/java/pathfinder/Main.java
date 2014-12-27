package de.buschbaum.java.pathfinder;

import de.buschbaum.java.pathfinder.device.mpu6050.Mpu6050Controller;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        initialize();
        while (true) {
            run();
        }
    }

    private static void run() {

    }

    private static void initialize() throws IOException, InterruptedException {
        System.out.println("Initializing Mpu6050");
        Mpu6050Controller.initialize();
        System.out.println("Mpu6050 initialized!");
    }
}
