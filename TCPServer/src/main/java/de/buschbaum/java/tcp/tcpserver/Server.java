/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.tcp.tcpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author uli
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //Address
        String multiCastAddress = "224.0.0.1";
        final int multiCastPort = 52684;

        //Create Socket
        System.out.println("Create socket on address " + multiCastAddress + " and port " + multiCastPort + ".");
        InetAddress group = InetAddress.getByName(multiCastAddress);
        MulticastSocket s = new MulticastSocket(multiCastPort);
        s.joinGroup(group);

        //Send data
        byte[] data = "Hello Socket!".getBytes(StandardCharsets.UTF_8);
        int size = data.length;
        s.send(new DatagramPacket(data, size, group, multiCastPort));
        while (true) {}
    }

}
