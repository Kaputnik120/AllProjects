/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.network;

import de.buschbaum.java.pathfinder.api.Status;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 *
 * @author uli
 */
public class Sender {

    //MulticastSocket configuration

    private final static String multiCastAddress = "224.0.0.1";
    private final static int multiCastPort = 52684;
    //Buffer size, = maximum size of transferred object
    private final static int bufferSize = 1024 * 4;
    //MulticastSocket
    private static MulticastSocket s;
    private static InetAddress group;

    public Sender() throws UnknownHostException, IOException {
        //Create Socket
        System.out.println("Create socket on address " + multiCastAddress + " and port " + multiCastPort + ".");
        group = InetAddress.getByName(multiCastAddress);
        s = new MulticastSocket(multiCastPort);
        s.joinGroup(group);
        System.out.println("Socket created successfully!");
    }

    public void send(Status status) throws IOException {

        System.out.println("Sending datagram...");

        //Prepare Data
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(status);
        byte[] data = baos.toByteArray();
        
        //Send data
        s.send(new DatagramPacket(data, data.length, group, multiCastPort));
        System.out.println("Datagram sent!");
    }
}
