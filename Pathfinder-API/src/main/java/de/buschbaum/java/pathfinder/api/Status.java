/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.api;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author uli
 */
public class Status implements Serializable {

    private int[] pos;

    private int[] mapDimensions;

    private List<int[]> barriers;

    private double[] robotSize;

    private Double[] accX;
    private Double[] accY;
    private Double[] accZ;

    private int pointerX;
    private int pointerY;
    private int pointerZ;

    private int angle;

    public Double[] getAccY() {
        return accY;
    }

    public void setAccY(Double[] accY) {
        this.accY = accY;
    }

    public Double[] getAccZ() {
        return accZ;
    }

    public void setAccZ(Double[] accZ) {
        this.accZ = accZ;
    }

    public int getPointerX() {
        return pointerX;
    }

    public void setPointerX(int pointerX) {
        this.pointerX = pointerX;
    }

    public int getPointerY() {
        return pointerY;
    }

    public void setPointerY(int pointerY) {
        this.pointerY = pointerY;
    }

    public int getPointerZ() {
        return pointerZ;
    }

    public void setPointerZ(int pointerZ) {
        this.pointerZ = pointerZ;
    }

    public Double[] getAccX() {
        return accX;
    }

    public void setAccX(Double[] accX) {
        this.accX = accX;
    }

    public double[] getRobotSize() {
        return robotSize;
    }

    public void setRobotSize(double[] robotSize) {
        this.robotSize = robotSize;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

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

    public List<int[]> getBarriers() {
        return barriers;
    }

    public void setBarriers(List<int[]> barriers) {
        this.barriers = barriers;
    }

}
