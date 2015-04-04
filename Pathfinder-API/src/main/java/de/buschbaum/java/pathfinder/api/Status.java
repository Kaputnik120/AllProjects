/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.api;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author uli
 */
public class Status implements Serializable {

    private int[] pos;
    
    private int[] mapDimensions;

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public int[] getMapDimensions() {
        return mapDimensions;
    }

    public void setMapDimensions(int[] mapDimensions) {
        this.mapDimensions = mapDimensions;
    }
    
    

}
