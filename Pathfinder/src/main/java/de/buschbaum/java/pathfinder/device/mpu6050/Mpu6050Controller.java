/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.device.mpu6050;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import de.buschbaum.java.pathfinder.Helper;
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

    public static short readAccXRegister() throws IOException {
        byte accXL = readRegister(Mpu6050Registers.MPU6050_RA_ACCEL_XOUT_L);
        byte accXH = readRegister(Mpu6050Registers.MPU6050_RA_ACCEL_XOUT_H);
        short accX = accXH; //Assign accXH
        accX = (short) (accX << 8); //Shift accXH to high 8 bits
        accX += accXL; //Add accXL as 8 low bits
        return accX;
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
            System.out.println(successText + Helper.formatBinary(returnedRegisterData));
        } else {
            throw new RuntimeException("Tried to write " + Helper.formatBinary(registerData) + " to "
                    + register + ", but validiating value returned " + Helper.formatBinary(returnedRegisterData));
        }
    }
}
