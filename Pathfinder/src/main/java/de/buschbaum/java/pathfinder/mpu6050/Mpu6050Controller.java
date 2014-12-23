/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.mpu6050;

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
        configureAndTestMpu6050();
    }

    private static void initializeI2C() throws IOException {
        System.out.println("Creating I2C bus");
        bus = I2CFactory.getInstance(I2CBus.BUS_1);
        System.out.println("Creating I2C device");
        mpu6050 = bus.getDevice(0x68);
    }

    private static void configureAndTestMpu6050() throws IOException, InterruptedException {
//        System.out.println("Setting sample rate to 8000/1+7 = 1000Hz");
//        //0b00000001 (1) => 01111111 (127)
//        //0b00000010 (2) => 10000001 (-127)
//        //0b00000011 (3) => 01011111 (95)
//
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_SMPLRT_DIV, (byte) 0b00000011);
//        Helper.printValue("MPU6050_RA_SMPLRT_DIV", readMpu6050());
//        Helper.printValue("MPU6050_RA_SMPLRT_DIV", readMpu6050Register(Mpu6050Registers.MPU6050_RA_SMPLRT_DIV));

        //0b00000000 (0) => 10000011 (-125)
        //0 (0) => 10000011 (-125)
//        System.out.println("Disable sensor output to FIFO buffer");
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_INT_ENABLE, (byte) 0b00000011);
//        Helper.printValue("MPU6050_RA_INT_ENABLE", readMpu6050());
//        Helper.printValue("MPU6050_RA_INT_ENABLE", readMpu6050());
//        Helper.printValue("MPU6050_RA_INT_ENABLE", readMpu6050());
//        Helper.printValue("MPU6050_RA_INT_ENABLE", readMpu6050Register(Mpu6050Registers.MPU6050_RA_INT_ENABLE));
//        Helper.printValue("MPU6050_RA_INT_ENABLE", readMpu6050Register(Mpu6050Registers.MPU6050_RA_INT_ENABLE));
//        Helper.printValue("MPU6050_RA_INT_ENABLE", readMpu6050Register(Mpu6050Registers.MPU6050_RA_INT_ENABLE));
//        Helper.printValue("MPU6050_RA_INT_ENABLE", readMpu6050Register(Mpu6050Registers.MPU6050_RA_INT_ENABLE));
//        Thread.sleep(1000);
//        Helper.printValue("MPU6050_RA_INT_ENABLE", readMpu6050Register(Mpu6050Registers.MPU6050_RA_INT_ENABLE));
//        Thread.sleep(1000);
//        Helper.printValue("MPU6050_RA_INT_ENABLE", readMpu6050Register(Mpu6050Registers.MPU6050_RA_INT_ENABLE));
//        Thread.sleep(1000);
        // 11111100 => 10100111
        // 00111111 => 10100111
        // 00000000 => 10100111
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_CONFIG, (byte) 0b00000000);
        // 00000000 => 10000011
        // 00011000 => 10000011
        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_GYRO_CONFIG, (byte) 0b00011000);
        byte registerDataGyroConfig = readMpu6050Register(Mpu6050Registers.MPU6050_RA_GYRO_CONFIG);
        System.out.println("registerDataGyroConfig:\t" + Helper.formatBinary(registerDataGyroConfig));
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_ACCEL_CONFIG, (byte) 0b01010101);
//        System.out.println("List of matching values:");
        for (byte i = 59; i <= 72; i++) {
//            for (byte j = -127; j < 127; j++) {
//                writeMpu6050Register(i, j);
//                byte registerData = readMpu6050Register(i);
//                if (registerData == j) {
//                    System.out.println(i + "\t\tRegisterData:" + Helper.formatBinary(registerData) + "\t\tWritten data:" + Helper.formatBinary(j));
//                }
//            }
            byte registerData = readMpu6050Register(i);
            System.out.println(i + "\t\tRegisterData:" + Helper.formatBinary(registerData));
        }

        System.exit(0);
//        System.out.println("Enable data ready interrupt");
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_INT_ENABLE, (byte) 2);
//        Helper.printValue("MPU6050_RA_INT_ENABLE", readMpu6050());
//
//        System.out.println("Reset sensor signal paths");
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_SIGNAL_PATH_RESET, (byte) 3);
//
//        System.out.println("Sets clock source to internal clock");
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_PWR_MGMT_1, (byte) 4);
//        Helper.printValue("MPU6050_RA_PWR_MGMT_1", readMpu6050());
//
//        System.out.println("Controls frequency of wakeups in accel low power mode plus the sensor standby modes");
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_PWR_MGMT_2, (byte) 5);
//        Helper.printValue("MPU6050_RA_PWR_MGMT_2", readMpu6050());
//        System.out.println("Selftesting accelerometers");
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_ACCEL_CONFIG, (byte) 0b10000000);
//        Thread.sleep(1000);
//        Helper.printValue("Accelerometer X self test", readMpu6050());
//        Thread.sleep(1000);
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_ACCEL_CONFIG, (byte) 0b01000000);
//        Thread.sleep(1000);
//        Helper.printValue("Accelerometer Y self test", readMpu6050());
//        Thread.sleep(1000);
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_ACCEL_CONFIG, (byte) 0b00100000);
//        Thread.sleep(1000);
//        Helper.printValue("Accelerometer Z self test", readMpu6050());
//        Thread.sleep(1000);
//
//        System.out.println("Disable gyro self tests, scale of 500 degrees/s");
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_GYRO_CONFIG, (byte) 0);
//        System.out.println("Disable accel self tests, scale of +-2g, no DHPF");
//        writeMpu6050Register(Mpu6050Registers.MPU6050_RA_ACCEL_CONFIG, (byte) 0);
    }

    private static void writeMpu6050Register(byte register, byte data) throws IOException {
//        System.out.println("Writing register: Writing " + Integer.toBinaryString(data) + "(" + data + ")" + " to " + Integer.toBinaryString(register) + "(" + register + ")");
        mpu6050.write(register, data);
    }

    public static byte readMpu6050Register(byte register) throws IOException {
        int data = mpu6050.read(register);
//        System.out.println("Reading register: register " + Integer.toBinaryString(register) + "(" + register + ")" + ", data " + Integer.toBinaryString(data) + "(" + (byte) data + ")");

        return (byte) data;
    }

    public static byte readMpu6050() throws IOException {
        int data = mpu6050.read();
//        System.out.println("Reading current register: Read " + Integer.toBinaryString(data) + "(" + (byte) data + ")");
        return (byte) data;
    }
}
