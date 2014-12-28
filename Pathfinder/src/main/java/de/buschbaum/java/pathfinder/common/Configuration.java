/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.common;

/**
 *
 * @author uli
 */
public class Configuration {

    /**
     * The size of one time slot in ms
     */
    public static final byte TIME_SLOT_LENGTH = 50;

    /**
     * The size of the buffer of the accelerator measurements
     */
    public static final short ACC_BUFFER_SIZE = 1000 / TIME_SLOT_LENGTH;
    /**
     * The minimum absolute value to be recognized as acceleration. For example
     * if ACC_THRESHOLD is 1000 values between -1000 and 1000 are handled as
     * noise. Noise is handled via {@link de.buschbaum.java.pathfinder.logic.PositionController#applyThreshold(short, short).
     * Setting this to 0 disables the Threshold normalization.
     * }
     */
    public static final short ACC_THRESHOLD = 0;

    /**
     * This value is always added to the measured values.
     */
    //TODO This value must be adjusted dynamically to the initial self test values.
    public static final short ACC_X_CORRECTION = 1260;

    /**
     * 2g (as configured) per 16-bit (as AD-conversion of Mpu6050)
     */
    public static final double ACC_RESOLUTION = 2 / (double) Short.MAX_VALUE;
    /**
     * Weight applied to the newest data while calculating the moving average.
     * See {@link  de.buschbaum.java.pathfinder.common.Mathematics#movingAverage(short[], short, byte)
     * }
     */
    public static final byte MOVING_AVERAGE_WEIGHT = 20;
    /**
     * Defines how many of the values measured last are used for the calculation
     * of the moving average. Settings this to 1 effectively disables the moving
     * average normalization.
     */
    public static final byte MOVING_AVERAGE_SIZE = 1;
}
