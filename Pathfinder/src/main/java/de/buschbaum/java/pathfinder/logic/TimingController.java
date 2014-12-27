/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.logic;

/**
 *
 * @author uli
 */
public class TimingController {

    public static void timeSlot(int length, long startTime) throws InterruptedException {
        long currentTime = System.nanoTime();
        int diffTime = (int) ((currentTime - startTime) / (1000 * 1000));
        if (diffTime >= length) {
            throw new RuntimeException("TimeSlot of " + length + " ms could not be met.");
        } else {
            Thread.sleep(length - diffTime);
        }

    }
}
