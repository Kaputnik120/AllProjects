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
public class PositionController {

    private static int[] position = new int[]{0, 0};

    public static void update() {
        position[0] = 0;
        position[1] = 0;
    }

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public static int[] getPosition() {
        return position;
    }

    public static float getAngle() {
        return 0f;
    }

}
