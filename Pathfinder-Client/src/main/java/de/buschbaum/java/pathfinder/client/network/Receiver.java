/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.client.network;

import de.buschbaum.java.pathfinder.api.Status;
import de.buschbaum.java.pathfinder.client.FXMLController;
import de.buschbaum.java.pathfinder.client.Model;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javafx.application.Platform;

/**
 *
 * @author uli
 */
public class Receiver extends Thread {

    //MulticastSocket configuration
    private final static String multiCastAddress = "224.0.0.1";
    private final static int multiCastPort = 52684;
    //Buffer size, = maximum size of transferred object
    private final static int bufferSize = 1024 * 4;
    //MulticastSocket
    private static MulticastSocket s;
    private static InetAddress group;
    //Instance of FXController for redraw callbacks
    private final FXMLController fXMLController;

    public Receiver(FXMLController fXMLController) throws UnknownHostException, IOException {
        this.fXMLController = fXMLController;

        //Create Socket
        System.out.println("Create socket on address " + multiCastAddress + " and port " + multiCastPort + ".");
        group = InetAddress.getByName(multiCastAddress);
        s = new MulticastSocket(multiCastPort);
        s.joinGroup(group);
        System.out.println("Socket created successfully!");
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (fXMLController.run) {
                    Status status = receive();
                    Platform.runLater(() -> {
                        //Direct bindings are updated
                        Model.positionX.setValue(status.getPos()[0]);
                        Model.positionY.setValue(status.getPos()[1]);
                        Model.dimensionX.setValue(status.getMapDimensions()[0]);
                        Model.dimensionY.setValue(status.getMapDimensions()[1]);
                        Model.angle.setValue(status.getAngle());
                        Model.sizeRobotX.setValue(status.getRobotSize()[0]);
                        Model.sizeRobotY.setValue(status.getRobotSize()[1]);
                        Model.maxMs.setValue(status.getMaxMs());
                        Model.speed.setValue(status.getSpeed());
                        Model.rotationX.setValue(status.getRotationX());
                        Model.rotationY.setValue(status.getRotationY());
                        Model.rotationZ.setValue(status.getRotationZ());

                        //Mapped status fields are updated
                        Model.barriers = new ArrayList<>(1);
                        Model.barriers.addAll(status.getBarriers());
                        Model.accX = status.getAccX();
                        Model.accY = status.getAccY();
                        Model.accZ = status.getAccZ();
                        Model.pointerX = status.getPointerX();
                        Model.pointerY = status.getPointerY();
                        Model.pointerZ = status.getPointerZ();
                        Model.gyroX = status.getGyroX();
                        Model.gyroY = status.getGyroY();
                        Model.gyroZ = status.getGyroZ();
                        Model.pointerGyroX = status.getPointerX();
                        Model.pointerGyroY = status.getPointerY();
                        Model.pointerGyroZ = status.getPointerZ();

                        //Explicitely call update of drawings
                        fXMLController.updateMap();
                        fXMLController.updateAccelerometers();

                    });
                }
            } catch (Exception ex) {
                System.out.println("Status couldn't be read from diagram:" + ex);
            }
        }
    }

    private Status receive() throws IOException, ClassNotFoundException {

        System.out.println("Wating for datagram to be received...");

        //Create buffer
        byte[] buffer = new byte[bufferSize];
        s.receive(new DatagramPacket(buffer, bufferSize, group, multiCastPort));
        System.out.println("Datagram received!");

        //Deserialze object
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object readObject = ois.readObject();
        if (readObject instanceof Status) {
            Status status = (Status) readObject;
            System.out.println("Status is: " + status);
            return status;
        } else {
            throw new RuntimeException("The received object is not of type Status!");
        }
    }
}
