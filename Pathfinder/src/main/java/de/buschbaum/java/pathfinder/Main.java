package de.buschbaum.java.pathfinder;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.system.NetworkInfo;
import com.pi4j.system.SystemInfo;
import java.io.IOException;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            System.out.println("Creating I2C bus");
            I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);
            System.out.println("Creating I2C device");
            I2CDevice device = bus.getDevice(0x68);
            
            int iterations = 0;
            
            String readsPerIterationProp = args[0].substring(2, args[0].length());
            int readsPerIteration = Integer.parseInt(readsPerIterationProp);
            
            String startRegisterProp = args[1].substring(2, args[1].length());
            byte startRegister = Byte.parseByte(startRegisterProp);
            
            String waitReadTimeProp = args[2].substring(2, args[2].length());
            long waitReadTime = Long.parseLong(waitReadTimeProp);
            
            String wakeUpRegisterProp = args[3].substring(2, args[3].length());
            byte wakeUpRegister = Byte.parseByte(wakeUpRegisterProp);
            
            System.out.println("Using readsPerIteration " + readsPerIteration);
            System.out.println("Using startRegister " + startRegister);
            
            System.out.println("Waking device up");
            device.write(wakeUpRegister);
            device.write((byte) 0);
            System.out.println("Device waked up");
            
            Thread.sleep(3000);
            
            while (true) {

                //Setting registers
//                Wire.beginTransmission(MPU);
//                Wire.write(0x6B);  // PWR_MGMT_1 register
//                Wire.write(0);     // set to zero (wakes up the MPU-6050)
//                Wire.endTransmission(true);
//                device.write((byte) 0x6B);
//                device.write((byte) 0);
                //Reading registers
                if (startRegister > 0) {
//                    System.out.println("StartRegister sent: " + startRegister);
                    device.write(startRegister);  // starting with register 0x3B (ACCEL_XOUT_H)
                } else {
//                    System.out.println("Not sending StartRegister to MPU6050");
                }

//
//                int acX = device.read() << 8 | device.read();  // 0x3B (ACCEL_XOUT_H) & 0x3C (ACCEL_XOUT_L)    
//                int acY = device.read() << 8 | device.read();  // 0x3D (ACCEL_YOUT_H) & 0x3E (ACCEL_YOUT_L)
//                int acZ = device.read() << 8 | device.read();  // 0x3F (ACCEL_ZOUT_H) & 0x40 (ACCEL_ZOUT_L)
//                int tmp = device.read() << 8 | device.read();  // 0x41 (TEMP_OUT_H) & 0x42 (TEMP_OUT_L)
//                int gyX = device.read() << 8 | device.read();  // 0x43 (GYRO_XOUT_H) & 0x44 (GYRO_XOUT_L)
//                int gyY = device.read() << 8 | device.read();  // 0x45 (GYRO_YOUT_H) & 0x46 (GYRO_YOUT_L)
//                int gyZ = device.read() << 8 | device.read();  // 0x47 (GYRO_ZOUT_H) & 0x48 (GYRO_ZOUT_L)
//
//                System.out.println("acX: " + acX);
//                System.out.println("acY: " + acY);
//                System.out.println("acZ: " + acZ);
//                System.out.println("tmp: " + tmp);
//                System.out.println("gyX: " + gyX);
//                System.out.println("gyY: " + gyY);
//                System.out.println("gyZ: " + gyZ);
                int registers[] = new int[readsPerIteration];
                for (int i = 0; i < readsPerIteration; i++) {
                    Thread.sleep(1);
                    registers[i] = device.read();
                    System.out.print(registers[i] + "\t");
                    if (i % 10 == 0) {
                        System.out.println();
                    }
                }

//                System.out.println("Nr. 8: " + registers[8]);
//                System.out.println("Nr. 13: " + registers[13]);
//                System.out.println("Nr. 19: " + registers[19]);
//                System.out.println("Nr. 20: " + registers[20]);
//                System.out.println("Nr. 21: " + registers[21]);
//                System.out.println("Nr. 22: " + registers[22]);
//                System.out.println("Nr. 23: " + registers[23]);
//                System.out.println("Nr. 24: " + registers[24]);
//                System.out.println("Nr. 25: " + registers[25]);
//                System.out.println("Nr. 26: " + registers[26]);
//                System.out.println();
//                System.out.println("--------------------------------------------" + iterations + "---------------------------------------------");
//                System.out.println();
                iterations++;
                Thread.sleep(waitReadTime);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
