/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.buschbaum.java.pathfinder.client;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author uli
 */
public class Model {
    
    public static IntegerProperty positionX = new SimpleIntegerProperty(0);
    public static IntegerProperty positionY = new SimpleIntegerProperty(0);
    public static IntegerProperty dimensionX = new SimpleIntegerProperty(1);
    public static IntegerProperty dimensionY = new SimpleIntegerProperty(1);
    
}
