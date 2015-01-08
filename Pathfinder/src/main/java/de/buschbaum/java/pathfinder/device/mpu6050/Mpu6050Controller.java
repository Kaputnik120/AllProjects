/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.device.mpu6050;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import de.buschbaum.java.pathfinder.common.Configuration;
import de.buschbaum.java.pathfinder.common.Printer;
import de.buschbaum.java.pathfinder.logic.TimingController;
import java.io.IOException;

/**
 *
 * @author uli
 */
public class Mpu6050Controller {

    private static I2CBus bus = null;
    private static I2CDevice mpu6050 = null;

    public static void initialize() throws IOException, InterruptedException {
        initializeI2C();
        configureMpu6050();
    }

    public static void calibrate() throws IOException, InterruptedException {
        System.out.println("Calibrating x-axis accelerometer...");
        int sumX = 0;
        int sumY = 0;
        int sumZ = 0;

        int i = 1;
//        for (i = 1; i <= Configuration.CALIBRATION_COUNT; i++) {
        while (true) {
            short x = readAccXRegisters();
            short y = readAccYRegisters();
            short z = readAccZRegisters();
            sumX += x;
            sumY += y;
            sumZ += z;
            System.out.println("Calibration: " + sumX / (double) i + "\t" + sumY / (double) i + "\t" + sumZ / (double) i);
            //The number printed is not correct. E.g. the number 
            //2059(0000100000001011) is printed
            //This is 100000001011 as a two-complement value, which is
            //-2037
            //Reasonableness of the value can be checked, by checking if the value for 16g resolution is
            //within -2047 and +2047
            //This must be corrected!!!
            System.out.println((short) x + "(" + Printer.formatBinary(x) + ")" + "\t"
                    + (short) y + "(" + Printer.formatBinary(y) + ")" + "\t"
                    + (short) z + "(" + Printer.formatBinary(z) + ")" + "\t");
            i++;
            TimingController.timeSlot(Configuration.CALIBRATION_TIME_SLOT, System.nanoTime());
        }

//        }
//        short result = (short) ((sumX / i) * (-1));
//        System.out.println("Calibrated x-axis accelerometer to " + result);
//        return result;
    }

    public static short readAccXRegisters() throws IOException {
        short accX = readRegistertsAndShiftWithLsb(Mpu6050Registers.MPU6050_RA_ACCEL_XOUT_L,
                Mpu6050Registers.MPU6050_RA_ACCEL_XOUT_H,
                Configuration.ACC_LSB);
        return accX;
    }

    public static short readAccYRegisters() throws IOException {
        short accY = readRegistertsAndShiftWithLsb(Mpu6050Registers.MPU6050_RA_ACCEL_YOUT_L,
                Mpu6050Registers.MPU6050_RA_ACCEL_YOUT_H,
                Configuration.ACC_LSB);
        return accY;
    }

    public static short readAccZRegisters() throws IOException {
        short accZ = readRegistertsAndShiftWithLsb(Mpu6050Registers.MPU6050_RA_ACCEL_ZOUT_L,
                Mpu6050Registers.MPU6050_RA_ACCEL_ZOUT_H,
                Configuration.ACC_LSB);
        return accZ;
    }

    private static short readRegistertsAndShiftWithLsb(byte lowByteRegister, byte highByteRegister, byte lsb) throws IOException {
        //Read
        byte lowByte = readRegister(lowByteRegister);
        byte highByte = readRegister(highByteRegister);

        //Shift
        short result = shiftBytesTogether(lowByte, highByte);

        return result;
    }

    public static short applyLeastSignificantBit(short data, byte lsb) {
        int shift = Integer.SIZE - lsb;
        // shift sign into position
        int result = data << shift;
        // Java right shift uses sign extension, but only works on integers or longs
        result >>= shift;
        return (short) result;
    }

    public static short shiftBytesTogether(byte lowByte, byte highByte) {
        short result = highByte;
        result = (short) (result << 8);
        result += lowByte;
        return result;
    }

    private static void initializeI2C() throws IOException {
        System.out.println("Creating I2C bus");
        bus = I2CFactory.getInstance(I2CBus.BUS_1);
        System.out.println("Creating I2C device");
        mpu6050 = bus.getDevice(0x68);
    }

    private static void configureMpu6050() throws IOException, InterruptedException {

        //1 Waking the device up
        writeConfigRegisterAndValidate(
                "Waking up device",
                "Wake-up config succcessfully written: ",
                Mpu6050Registers.MPU6050_RA_PWR_MGMT_1,
                Mpu6050RegisterValues.MPU6050_RA_PWR_MGMT_1);

        //2 Configure sample rate
        writeConfigRegisterAndValidate(
                "Configuring sample rate",
                "Sample rate succcessfully written: ",
                Mpu6050Registers.MPU6050_RA_SMPLRT_DIV,
                Mpu6050RegisterValues.MPU6050_RA_SMPLRT_DIV);

        //3 Setting global config
        writeConfigRegisterAndValidate(
                "Setting global config (digital low pass filter)",
                "Global config succcessfully written: ",
                Mpu6050Registers.MPU6050_RA_CONFIG,
                Mpu6050RegisterValues.MPU6050_RA_CONFIG);

        //4 Configure Gyroscope
        writeConfigRegisterAndValidate(
                "Configuring gyroscope",
                "Gyroscope config successfully written: ",
                Mpu6050Registers.MPU6050_RA_GYRO_CONFIG,
                Mpu6050RegisterValues.MPU6050_RA_GYRO_CONFIG);

        //5 Configure Accelerometer
        writeConfigRegisterAndValidate(
                "Configuring accelerometer",
                "Accelerometer config successfully written: ",
                Mpu6050Registers.MPU6050_RA_ACCEL_CONFIG,
                Mpu6050RegisterValues.MPU6050_RA_ACCEL_CONFIG);

        //6 Configure interrupts
        writeConfigRegisterAndValidate(
                "Configuring interrupts",
                "Interrupt config successfully written: ",
                Mpu6050Registers.MPU6050_RA_INT_ENABLE,
                Mpu6050RegisterValues.MPU6050_RA_INT_ENABLE);

        //7 Configure low power operations
        writeConfigRegisterAndValidate(
                "Configuring low power operations",
                "Low power operation config successfully written: ",
                Mpu6050Registers.MPU6050_RA_PWR_MGMT_2,
                Mpu6050RegisterValues.MPU6050_RA_PWR_MGMT_2);
    }

    private static void writeRegister(byte register, byte data) throws IOException {
        mpu6050.write(register, data);
    }

    private static byte readRegister(byte register) throws IOException {
        int data = mpu6050.read(register);
        return (byte) data;
    }

    private static byte readRegister() throws IOException {
        int data = mpu6050.read();
        return (byte) data;
    }

    private static void writeConfigRegisterAndValidate(String initialText, String successText, byte register, byte registerData) throws IOException {
        System.out.println(initialText);
        writeRegister(register, registerData);
        byte returnedRegisterData = Mpu6050Controller.readRegister(register);
        if (returnedRegisterData == registerData) {
            System.out.println(successText + Printer.formatBinary(returnedRegisterData));
        } else {
            throw new RuntimeException("Tried to write " + Printer.formatBinary(registerData) + " to "
                    + register + ", but validiating value returned " + Printer.formatBinary(returnedRegisterData));
        }
    }
}
