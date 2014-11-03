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
public class AnotherThread extends Thread {

    @Override
    public void run() {
        while (true) {
            double atan1 = Math.atan(0.352664317532);
            double atan2 = Math.atan(0.35262241);
            double atan3 = Math.atan(0.352656421642);
            double atan4 = Math.atan(0.352664316432);
            System.out.println(atan1);
            System.out.println(atan2);
            System.out.println(atan3);
            System.out.println(atan4);
        }
    }
}
