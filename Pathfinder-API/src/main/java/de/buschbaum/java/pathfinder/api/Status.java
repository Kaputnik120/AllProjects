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

    private Double[] gyroX;
    private Double[] gyroY;
    private Double[] gyroZ;

    private int pointerGyroX;
    private int pointerGyroY;
    private int pointerGyroZ;

    private double speed;

    private int rotationX;
    private int rotationY;
    private int rotationZ;

    public Double[] getGyroX() {
        return gyroX;
    }

    public void setGyroX(Double[] gyroX) {
        this.gyroX = gyroX;
    }

    public Double[] getGyroY() {
        return gyroY;
    }

    public void setGyroY(Double[] gyroY) {
        this.gyroY = gyroY;
    }

    public Double[] getGyroZ() {
        return gyroZ;
    }

    public void setGyroZ(Double[] gyroZ) {
        this.gyroZ = gyroZ;
    }

    public int getPointerGyroX() {
        return pointerGyroX;
    }

    public void setPointerGyroX(int pointerGyroX) {
        this.pointerGyroX = pointerGyroX;
    }

    public int getPointerGyroY() {
        return pointerGyroY;
    }

    public void setPointerGyroY(int pointerGyroY) {
        this.pointerGyroY = pointerGyroY;
    }

    public int getPointerGyroZ() {
        return pointerGyroZ;
    }

    public void setPointerGyroZ(int pointerGyroZ) {
        this.pointerGyroZ = pointerGyroZ;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getRotationX() {
        return rotationX;
    }

    public void setRotationX(int rotationX) {
        this.rotationX = rotationX;
    }

    public int getRotationY() {
        return rotationY;
    }

    public void setRotationY(int rotationY) {
        this.rotationY = rotationY;
    }

    public int getRotationZ() {
        return rotationZ;
    }

    public void setRotationZ(int rotationZ) {
        this.rotationZ = rotationZ;
    }

    private int angle;

    private double maxMs;

    public double getMaxMs() {
        return maxMs;
    }

    public void setMaxMs(double maxMs) {
        this.maxMs = maxMs;
    }

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
