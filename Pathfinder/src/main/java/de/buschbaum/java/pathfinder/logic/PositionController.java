/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.logic;

import de.buschbaum.java.pathfinder.device.mpu6050.Mpu6050Controller;
import java.io.IOException;

/**
 *
 * @author uli
 */
public class PositionController {
    
    private static int[] position = new int[]{0, 0};
    
    private static final double ACC_RESOLUTION = 2 / (double) Short.MAX_VALUE;
    
    public static void update() throws IOException {
        position[0] = 0;
        position[1] = 0;
        short accX = Mpu6050Controller.readAccXRegister();
//        System.out.println("Raw:" + accX);
        System.out.println("g:" + getAcceleration(accX));
    }
    
    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public static int[] getPosition() {
        return position;
    }
    
    public static float getAngle() {
        return 0f;
    }
    
    private static double getAcceleration(short rawAcc) {
        return rawAcc * ACC_RESOLUTION;
    }
    
}
