/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.logic;

import de.buschbaum.java.pathfinder.common.Configuration;
import de.buschbaum.java.pathfinder.common.Mathematics;
import de.buschbaum.java.pathfinder.device.mpu6050.Mpu6050Controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author uli
 */
public class PositionController {

    /**
     * As a offset in cm from the starting position
     */
    private static double[] vehiclePosition = new double[]{0, 0};
    /**
     * The raw values of the y-axis of the MPU6050
     */
    private static final double[] accYRawBuffer = new double[Configuration.ACC_BUFFER_SIZE];
    /**
     * The values of the y-axis with moving average and conversion to g-force
     * applied
     */
    private static final double[] accYNormBuffer = new double[Configuration.ACC_BUFFER_SIZE];

    /**
     * Current position in the buffers
     */
    private static short pos = 0;

//    private static double accYSum = 0;
//
//    private static double accYSumAvg = 0;
    /**
     * Current speed on the y-axis as m/s
     */
    private static double accYSpeed = 0;

    private static short executionCounter = 0;

    private static List<double[]> octaveList = new ArrayList<>();
    private static List<double[]> octaveList2 = new ArrayList<>();

    private static double lowX = 10000;
    private static double lowY = 10000;
    private static double lowZ = 10000;
    private static double highX = -10000;
    private static double highY = -10000;
    private static double highZ = -10000;

    public static void initialize() throws Exception {
        System.out.println("Initializing Mpu6050");
        Mpu6050Controller.initialize();
        System.out.println("Mpu6050 initialized!");
        System.out.println("The g-force resolution is " + Configuration.ACC_RESOLUTION);
    }

    public static void update() throws Exception {
//        //Increment execution counter
//        executionCounter++;
//
//        //Update acceleration values, speed and position
//        updateAccelerationValues();
//        accYSpeed += accYNormBuffer[pos];
////        System.out.println("Current speed is: " + accYSpeed + " m/s");
//        vehiclePosition[1] += (accYSpeed * 100);
////        System.out.println("Current position is: " + Arrays.toString(vehiclePosition) + " cm");
//
//        octaveList.add(new double[]{0, accYSpeed, 0});
//        if (octaveList.size() % 100 == 0) {
//            System.out.print("speedY = [");
//            for (double[] value : octaveList) {
//                System.out.print(value[1] + " ");
//            }
//            System.out.println("]");
//        }
//        octaveList2.add(new double[]{0, accYNormBuffer[pos], 0});
//        if (octaveList2.size() % 100 == 0) {
//            System.out.print("accY = [");
//            for (double[] value : octaveList2) {
//                System.out.print(value[1] + " ");
//            }
//            System.out.println("]");
//        }
//
//        //Correct speed every second
//        if ((executionCounter * Configuration.TIME_SLOT_LENGTH) == 1000) {
//            eraseLowSpeed();
//            executionCounter = 0;
//        }
        double[] accVector = Mpu6050Controller.getAlignedAccelerationValues();
        lowX = Math.min(accVector[0], lowX);
        lowY = Math.min(accVector[1], lowY);
        lowZ = Math.min(accVector[2], lowZ);
        highX = Math.max(accVector[0], highX);
        highY = Math.max(accVector[1], highY);
        highZ = Math.max(accVector[2], highZ);
        System.out.println(accVector[0] + "\t" + accVector[1] + "\t" + accVector[2]);
        System.out.println("Lows:" + lowX + "\t" + lowY + "\t" + lowZ);
        System.out.println("Highs:" + highX + "\t" + highY + "\t" + highZ);
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public static double[] getPosition() {
        return vehiclePosition;
    }

    public static float getAngle() {
        return 0f;
    }

    private static void eraseLowSpeed() {
        accYSpeed = Mathematics.applyThreshold(accYSpeed, Configuration.MINIMUM_SPEED);
//        System.out.println("Speed resetted to " + accYSpeed);
    }

    private static void updateAccelerationValues() throws Exception {
        //Read values
        double[] accs = Mpu6050Controller.getAlignedAccelerationValues();

        //Moving average
        pos = writeToBufferArray(pos, accYRawBuffer, accs[1]);
        double accYAvg = Mathematics.movingAverage(accYRawBuffer, pos, (byte) 10);

        //G-force calculation
        double accYAvgG = accYAvg * Configuration.ACC_RESOLUTION;
        writeToBufferArray(pos, accYNormBuffer, accYAvgG);

        //Print list for Octave
//        accList.add(new double[]{0, accYAvg, 0});
//        if (accList.size() % 100 == 0) {
//            System.out.print("accYSumAvg=" + accYSumAvg + "[");
//            for (double[] acc : accList) {
//                System.out.print(acc[1] + " ");
//            }
//            System.out.println("]");
//        }
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
