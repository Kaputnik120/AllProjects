package de.buschbaum.battle.statistics.battlestatistics;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

    @FXML
    private TextField shootingUnitName;
    @FXML
    private ComboBox shootingHit;
    @FXML
    private CheckBox shootingHitsReroll;
    @FXML
    private CheckBox shootingHitsReroll1s;
    @FXML
    private ComboBox shootingStrength;
    @FXML
    private CheckBox shootingWoundsReroll;
    @FXML
    private CheckBox shootingRending;
    @FXML
    private ComboBox shootingAP;
    @FXML
    private TextField shootingShots;
    @FXML
    private TextField shootingPoints;

    @FXML
    private TextField shotUnitName;
    @FXML
    private ComboBox shotToughness;
    @FXML
    private ComboBox shotArmourSave;
    @FXML
    private CheckBox shotArmourSaveReroll;
    @FXML
    private CheckBox shotArmourSaveReroll1s;
    @FXML
    private ComboBox shotInvulnerableSave;
    @FXML
    private CheckBox shotInvulnerableSaveReroll;
    @FXML
    private CheckBox shotInvulnerableSaveReroll1s;
    @FXML
    private ComboBox shotFNPSave;
    @FXML
    private CheckBox shotFNPSaveReroll;
    @FXML
    private CheckBox shotFNPSaveReroll1s;
    @FXML
    private TextField wounds;
    @FXML
    private TextField points;

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL url, ResourceBundle rb) {
        shootingUnitName.setText("Space Marines");
        shootingHit.getItems().addAll(Arrays.asList(new String[]{"2+", "3+", "4+", "5+", "6+", "Automatic"}));
        shootingHit.getSelectionModel().select("3+");
        shootingHitsReroll.setSelected(false);
        shootingHitsReroll1s.setSelected(false);
        shootingStrength.getItems().addAll(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "D"}));
        shootingStrength.getSelectionModel().select("4");
        shootingWoundsReroll.setSelected(false);
        shootingRending.setSelected(false);
        shootingAP.getItems().addAll(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", "-"}));
        shootingAP.getSelectionModel().select("5");
        shootingShots.setText("20");
        shootingPoints.setText("170");

        shotUnitName.setText("Chaos Terminators");
        shotToughness.getItems().addAll(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        shotToughness.getSelectionModel().select("4");
        shotArmourSave.getItems().addAll(Arrays.asList(new String[]{"2+", "3+", "4+", "5+", "6+", "-"}));
        shotArmourSave.getSelectionModel().select("2+");
        shotArmourSaveReroll.setSelected(false);
        shotArmourSaveReroll1s.setSelected(false);
        shotInvulnerableSave.getItems().addAll(Arrays.asList(new String[]{"2+", "3+", "4+", "5+", "6+", "-"}));
        shotInvulnerableSave.getSelectionModel().select("5+");
        shotInvulnerableSaveReroll.setSelected(false);
        shotInvulnerableSaveReroll1s.setSelected(false);
        shotFNPSave.getItems().addAll(Arrays.asList(new String[]{"2+", "3+", "4+", "5+", "6+", "-"}));
        shotFNPSave.getSelectionModel().select("-");
        shotFNPSaveReroll.setSelected(false);
        shotFNPSaveReroll1s.setSelected(false);
        points.setText("200");
        wounds.setText("5");
    }
}
