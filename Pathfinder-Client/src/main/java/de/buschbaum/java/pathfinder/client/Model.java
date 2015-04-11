/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.client;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author uli
 */
public class Model {

    //JavaFX Properties
    @SuppressWarnings("PublicField")
    public static IntegerProperty positionX = new SimpleIntegerProperty(0);
    public static IntegerProperty positionY = new SimpleIntegerProperty(0);
    public static IntegerProperty dimensionX = new SimpleIntegerProperty(1);
    public static IntegerProperty dimensionY = new SimpleIntegerProperty(1);
    public static DoubleProperty sizeRobotX = new SimpleDoubleProperty(1);
    public static DoubleProperty sizeRobotY = new SimpleDoubleProperty(1);
    public static IntegerProperty angle = new SimpleIntegerProperty(1);
    public static DoubleProperty maxMs = new SimpleDoubleProperty(1);
    public static DoubleProperty speed = new SimpleDoubleProperty(1);
    public static IntegerProperty rotationX = new SimpleIntegerProperty(1);
    public static IntegerProperty rotationY = new SimpleIntegerProperty(1);
    public static IntegerProperty rotationZ = new SimpleIntegerProperty(1);

    //Status model field
    public static List<int[]> barriers = new ArrayList<>(1);
    public static Double[] accX = new Double[1];
    public static Double[] accY = new Double[1];
    public static Double[] accZ = new Double[1];
    public static int pointerX = 1;
    public static int pointerY = 1;
    public static int pointerZ = 1;
    public static Double[] gyroX = new Double[1];
    public static Double[] gyroY = new Double[1];
    public static Double[] gyroZ = new Double[1];
    public static int pointerGyroX = 1;
    public static int pointerGyroY = 1;
    public static int pointerGyroZ = 1;

}
