/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.client.network;

import de.buschbaum.java.pathfinder.api.Status;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 *
 * @author uli
 */
public class Receiver {

    //MulticastSocket configuration
    private final static String multiCastAddress = "224.0.0.1";
    private final static int multiCastPort = 52684;
    //Buffer size, = maximum size of transferred object
    private final static int bufferSize = 1024 * 4;
    //MulticastSocket
    private static MulticastSocket s;
    private static InetAddress group;

    public Receiver() throws UnknownHostException, IOException {
        //Create Socket
        System.out.println("Create socket on address " + multiCastAddress + " and port " + multiCastPort + ".");
        group = InetAddress.getByName(multiCastAddress);
        s = new MulticastSocket(multiCastPort);
        s.joinGroup(group);
        System.out.println("Socket created successfully!");
    }

    public Status receive() throws IOException, ClassNotFoundException {

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
