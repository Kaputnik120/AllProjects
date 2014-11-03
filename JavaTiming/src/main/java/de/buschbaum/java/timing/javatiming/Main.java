/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.timing.javatiming;

/**
 *
 * @author uli
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Start another Thread to simulate other system loads
//        AnotherThread anotherProcess = new AnotherThread();
//        anotherProcess.setPriority(Thread.MIN_PRIORITY);
//        anotherProcess.start();

        //Start the Thread tracking the execution times
        TrackedThread trackedThread = new TrackedThread();
        trackedThread.setPriority(Thread.MAX_PRIORITY);
        trackedThread.start();

        //Stop the other Thread
//        anotherProcess.stop();
    }
    
}
