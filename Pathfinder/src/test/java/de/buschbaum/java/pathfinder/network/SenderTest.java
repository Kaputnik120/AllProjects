/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.network;

import de.buschbaum.java.pathfinder.api.Status;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author uli
 */
public class SenderTest {
    
    public SenderTest() {
    }
    
    @Test
    public void testSender() throws IOException {
        Sender sender = new Sender();
        Status status = new Status();
        status.setPos(new int[] {12,15});
        sender.send(status);
    }
    
}
