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

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Arrays.hashCode(this.pos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Status other = (Status) obj;
        if (!Arrays.equals(this.pos, other.pos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Status{" + "pos=" + pos + '}';
    }

}
