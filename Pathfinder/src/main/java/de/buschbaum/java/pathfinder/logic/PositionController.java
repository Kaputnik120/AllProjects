/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.logic;

import de.buschbaum.java.pathfinder.common.Configuration;
import de.buschbaum.java.pathfinder.common.Mathematics;
import de.buschbaum.java.pathfinder.device.mpu6050.Mpu6050Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uli
 */
public class PositionController {

    private static int[] position = new int[]{0, 0};

    private static final double[] accYBuffer = new double[Configuration.ACC_BUFFER_SIZE];

    private static short pos = 0;
//    private static final double[] accYNormBuffer = new double[Configuration.ACC_BUFFER_SIZE];

    private static double accYSum = 0;

    private static double accYSumAvg = 0;

    private static byte accYSpeed = 0;

    private static List<double[]> accList = new ArrayList<>();

    public static void initialize() throws Exception {
        System.out.println("Initializing Mpu6050");
        Mpu6050Controller.initialize();
        System.out.println("Mpu6050 initialized!");
    }

    public static void update() throws Exception {
        position[0] = 0;
        position[1] = 0;
        updateAccelerationValues();
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public static int[] getPosition() {
        return position;
    }

    public static float getAngle() {
        return 0f;
    }

    private static void updateAccelerationValues() throws Exception {
        //Read values
        double[] accs = Mpu6050Controller.getAlignedAccelerationValues();

        //Sum of y-accs
        accYSum += accs[1]; //Add y value

        //Moving average
        pos = writeToBufferArray(pos, accYBuffer, accs[1]);
        double accYAvg = Mathematics.movingAverage(accYBuffer, pos, (byte) 10);
        accYSumAvg += accYAvg;

        //Print list for Octave
        accList.add(new double[]{0, accYAvg, 0});
        if (accList.size() % 100 == 0) {
            System.out.print("accYSumAvg=" + accYSumAvg + "[");
            for (double[] acc : accList) {
                System.out.print(acc[1] + " ");
            }
            System.out.println("]");
        }
//        System.out.println(accs[1] + " -> accYSum: " + accYSum + " || " + accYAvg + " -> accYSumAvg: " + accYSumAvg);
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    private static short writeToBufferArray(short pos, double[] buffer, double value) {
        //Write value
        buffer[pos] = value;

        //Increment pointer or reset
        pos = Mathematics.nextPos(pos, (short) buffer.length);

        return pos;
    }

}
