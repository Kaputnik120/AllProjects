package de.buschbaum.java.pathfinder.client;

import de.buschbaum.java.pathfinder.client.network.Receiver;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {

    @FXML
    private Label posX;
    @FXML
    private Label posY;
    @FXML 
    private Canvas map;

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
    
    public void updateCanvas() {
        double width = map.getWidth();
        double height = map.getHeight();
        GraphicsContext gc = map.getGraphicsContext2D();
        
        int x = Model.dimensionX.get();
        int y = Model.dimensionY.get();
        
        double sizeX = width / x;
        double sizeY = width / y;
        
        System.out.println("X-Size of 1 mapPart is "+sizeX);
        System.out.println("Y-Size of 1 mapPart is "+sizeY);
    }
    
}
