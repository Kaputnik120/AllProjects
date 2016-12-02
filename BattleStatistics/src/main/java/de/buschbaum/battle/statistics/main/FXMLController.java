package de.buschbaum.battle.statistics.main;

import de.buschbaum.battle.statistics.model.BinomialTableModel;
import de.buschbaum.battle.statistics.model.OtherTableModel;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView binomialResult;
    @FXML
    private TableView otherResult;

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

        
        //TableViews
        TableColumn binomailLostWoundsColumn = new TableColumn("Lost Wounds");
        TableColumn binomialChanceColumn = new TableColumn("At least chance");
        binomialResult.getColumns().addAll(binomailLostWoundsColumn, binomialChanceColumn);        
        ObservableList<BinomialTableModel> binomialRow = FXCollections.observableArrayList(new BinomialTableModel("0", "0"));
        binomailLostWoundsColumn.setCellValueFactory(new PropertyValueFactory<>("lostWounds"));
        binomialChanceColumn.setCellValueFactory(new PropertyValueFactory<>("chance"));
        binomialResult.setItems(binomialRow);
        
        TableColumn otherPointsColumn = new TableColumn("Point effectiveness");
        TableColumn otherSingleHitChanceColumn = new TableColumn("Single hit chance");
        otherResult.getColumns().addAll(otherPointsColumn, otherSingleHitChanceColumn);        
        ObservableList<OtherTableModel> otherRow = FXCollections.observableArrayList(new OtherTableModel("0", "0"));
        otherPointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        otherSingleHitChanceColumn.setCellValueFactory(new PropertyValueFactory<>("singleHitChance"));
        otherResult.setItems(otherRow);
    }
}
