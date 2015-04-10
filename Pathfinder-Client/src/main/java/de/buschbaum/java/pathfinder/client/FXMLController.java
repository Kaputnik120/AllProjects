package de.buschbaum.java.pathfinder.client;

import de.buschbaum.java.pathfinder.client.network.Receiver;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FXMLController implements Initializable {

    @FXML
    private Label posX;
    @FXML
    private Label posY;
    @FXML
    private Pane map;
    @FXML
    private Pane accX;
    @FXML
    private Pane accY;
    @FXML
    private Pane accZ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            System.out.println("Initializing UI bindings...");
            posX.textProperty().bind(Bindings.concat("PositionX: ").concat(Model.positionX));
            posY.textProperty().bind(Bindings.concat("PositionY: ").concat(Model.positionY));

            System.out.println("Starting Receiver thread...");
            Receiver receiver = new Receiver(this);
            receiver.start();

            System.out.println("Controller set up.");
        } catch (IOException ex) {
            System.out.println("Controller couldn't be initialized!");
            ex.printStackTrace();
        }
    }

    public void updateAccelerometers() {

    }

    public void updateMap() {

        map.getChildren().clear();

        double width = map.getWidth();
        double height = map.getHeight();

        int x = Model.dimensionX.get();
        int y = Model.dimensionY.get();

        double sizeX = width / x;
        double sizeY = width / y;

        //Draw grid
        for (int i = 0; i <= x; i++) {
            Rectangle rect = new Rectangle();
            rect.setLayoutX(sizeX * i);
            rect.setLayoutY(0);
            rect.setWidth(1);
            rect.setHeight(height);
            map.getChildren().add(rect);
        }
        for (int i = 0; i <= y; i++) {
            Rectangle rect = new Rectangle();
            rect.setLayoutX(0);
            rect.setLayoutY(sizeY * i);
            rect.setWidth(width);
            rect.setHeight(1);
            map.getChildren().add(rect);
        }

        //Draw barriers
        for (int[] barrier : Model.barriers) {
            Rectangle barrierRect = getBarrier(barrier[0], barrier[1], sizeX, sizeY, Color.BLACK);
            map.getChildren().add(barrierRect);
        }

        //Draw in robot with angle, position and line of sight
        List<Rectangle> robot = getRobot(Model.positionX.get(), Model.positionY.get(), Model.angle.get(),
                sizeX, sizeY, Model.sizeRobotX.get(), Model.sizeRobotY.get(),
                Math.max(map.getPrefWidth(), map.getPrefHeight()), Color.BLUE);
        map.getChildren().addAll(robot);

        //Apply clipping to the map
        Rectangle clip = new Rectangle(map.getPrefWidth() + 1, map.getPrefHeight() + 1);
        clip.setLayoutX(0);
        clip.setLayoutY(0);
        map.setClip(clip);

        //Draw accelerometers
        accX.getChildren().clear();
        List<Rectangle> accelerometer = getAccelerometer(accX.getPrefWidth(), accX.getPrefHeight(), 0,
                Model.accX, Color.BLACK);
        accX.getChildren().addAll(accelerometer);

    }

    private List<Rectangle> getAccelerometer(double width, double height,
            int pointer, Double[] values, Color color) {
        
        List<Rectangle> accelerometer = new ArrayList<>(1000);
        
        double max = Collections.max(Arrays.asList(values));
        double min = Collections.min(Arrays.asList(values));
        double count = values.length;
        double spacing = width / count;
        double heightFactor = height / (max - min);

        for (int i = 0; i < count; i++) {
            Rectangle point = new Rectangle(1, 1, color);
            double x = (i+1) * spacing;
            double y = (max - values[i]) * heightFactor;
            point.setLayoutX(x);
            point.setLayoutY(y);
            accelerometer.add(point);
        }

        Rectangle yAxis = new Rectangle(1, height, color);
        yAxis.setLayoutX(0);
        yAxis.setLayoutY(0);

        Rectangle xAxis = new Rectangle(width, 1, color);
        xAxis.setLayoutX(0);
        xAxis.setLayoutY(height);

        
        accelerometer.add(xAxis);
        accelerometer.add(yAxis);

        return accelerometer;
    }

    private List<Rectangle> getRobot(int xCoordinate, int yCoordinate, int angle,
            double sizeX, double sizeY, double sizeRobotX, double sizeRobotY,
            double maxSize, Color color) {

        double footprintWidth = sizeX * sizeRobotX;
        double footprintHeight = sizeY * sizeRobotY;
        double posFootprintX = xCoordinate * sizeX - (sizeX / 2) - (footprintWidth / 2);
        double posFootprintY = yCoordinate * sizeY - (sizeY / 2) - (footprintHeight / 2);

        Rectangle footprint = new Rectangle(footprintWidth, footprintHeight, color);
        footprint.setLayoutX(posFootprintX);
        footprint.setLayoutY(posFootprintY);
        footprint.setRotate(angle);

        double lineOfSightWidth = 1;
        double lineOfSightHeight = maxSize * 2;
        double posLineOfSightX = posFootprintX + (footprintWidth / 2);
        double posLineOfSightY = posFootprintY + (footprintHeight / 2) - (lineOfSightHeight / 2);

        Rectangle lineOfSight = new Rectangle(lineOfSightWidth, lineOfSightHeight, color);
        lineOfSight.setLayoutX(posLineOfSightX);
        lineOfSight.setLayoutY(posLineOfSightY);
        lineOfSight.setRotate(angle);

        List<Rectangle> robot = new ArrayList<>(2);
        robot.add(footprint);
        robot.add(lineOfSight);

        return robot;
    }

    private Rectangle getBarrier(int xCoordinate, int yCoordinate, double sizeX, double sizeY, Color color) {
        //Top right border
        double x = xCoordinate * sizeX;
        double y = yCoordinate * sizeY;

        Rectangle rect = new Rectangle(sizeX, sizeY, color);
        rect.setLayoutX(x - sizeX);
        rect.setLayoutY(y - sizeY);

        return rect;
    }

}
