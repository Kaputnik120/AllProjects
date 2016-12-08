package de.buschbaum.battle.statistics.main;

import de.buschbaum.battle.statistics.core.CalculationService;
import de.buschbaum.battle.statistics.model.BinomialTableModel;
import de.buschbaum.battle.statistics.model.CalculationModel;
import de.buschbaum.battle.statistics.model.OtherTableModel;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private CheckBox shootingWoundsReroll1s;
    @FXML
    private CheckBox instantDeath;
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
    private ComboBox shotCoverSave;
    @FXML
    private CheckBox shotCoverSaveReroll;
    @FXML
    private CheckBox shotCoverSaveReroll1s;
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
    private void handleCalculateAction(ActionEvent event) {
        CalculationModel calculationModel = convert();

        if (calculationModel != null) {
            System.out.println("Start calculating!");
            CalculationService.calculate(calculationModel);
        }

    }

    private CalculationModel convert() {
        CalculationModel calculationModel = new CalculationModel();

        if (shootingHitsReroll.isSelected() && shootingHitsReroll1s.isSelected()) {
            raiseValidationError("Please select either one \"Hit: Reroll 1s\" or \"Hit: Reroll\"!");
            return null;
        }
        if (shotArmourSaveReroll.isSelected() && shotArmourSaveReroll1s.isSelected()) {
            raiseValidationError("Please select either one \"Armour Save: Reroll 1s\" or \"Armour Save: Reroll\"!");
            return null;
        }
        if (shotInvulnerableSaveReroll.isSelected() && shotInvulnerableSaveReroll1s.isSelected()) {
            raiseValidationError("Please select either one \"Invulnerable Save: Reroll 1s\" or \"Invulnerable Save: Reroll\"!");
            return null;
        }
        if (shotFNPSaveReroll.isSelected() && shotFNPSaveReroll1s.isSelected()) {
            raiseValidationError("Please select either one \"Feel no pain Save: Reroll 1s\" or \"Feel no pain Save: Reroll\"!");
            return null;
        }

        calculationModel.setRerollHit(shootingHitsReroll.isSelected());
        calculationModel.setReroll1sHit(shootingHitsReroll1s.isSelected());
        calculationModel.setRerollArmourSave(shotArmourSaveReroll.isSelected());
        calculationModel.setReroll1sArmourSave(shotArmourSaveReroll1s.isSelected());
        calculationModel.setRerollInvulnerableSave(shotInvulnerableSaveReroll.isSelected());
        calculationModel.setReroll1sInvulnerableSave(shotInvulnerableSaveReroll1s.isSelected());
        calculationModel.setRerollCoverSave(shotCoverSaveReroll.isSelected());
        calculationModel.setReroll1sCoverSave(shotCoverSaveReroll1s.isSelected());
        calculationModel.setReroll1sFnpSave(shotFNPSaveReroll1s.isSelected());
        calculationModel.setRerollFnpSave(shotFNPSaveReroll.isSelected());
        calculationModel.setReroll1sWound(shootingWoundsReroll1s.isSelected());
        calculationModel.setInstantDeath(instantDeath.isSelected());

        calculationModel.setRending(shootingRending.isSelected());
        calculationModel.setRerollWound(shootingWoundsReroll.isSelected());

        int hit = sanitizeD6((String) shootingHit.getSelectionModel().getSelectedItem());
        calculationModel.setHit(hit);
        int strength = sanitize((String) shootingStrength.getSelectionModel().getSelectedItem());
        calculationModel.setStrength(strength);
        int ap = sanitizeD6((String) shootingAP.getSelectionModel().getSelectedItem());
        calculationModel.setAp(ap);

        try {
            int points = sanitize(shootingPoints.getText());
            calculationModel.setShootingPoints(points);
        } catch (Exception e) {
            raiseValidationError("Points must be a number!");
            return null;
        }
        try {
            int shots = sanitize(shootingShots.getText());
            calculationModel.setShots(shots);
        } catch (Exception e) {
            raiseValidationError("Shots must be a number!");
            return null;
        }

        int toughness = sanitize((String) shotToughness.getSelectionModel().getSelectedItem());
        calculationModel.setToughness(toughness);
        int armourSave = sanitizeD6((String) shotArmourSave.getSelectionModel().getSelectedItem());
        calculationModel.setArmourSave(armourSave);
        int invulnerableSave = sanitizeD6((String) shotInvulnerableSave.getSelectionModel().getSelectedItem());
        calculationModel.setInvulnerableSave(invulnerableSave);
        int coverSave = sanitizeD6((String) shotCoverSave.getSelectionModel().getSelectedItem());
        calculationModel.setCoverSave(coverSave);
        int fnpSave = sanitizeD6((String) shotFNPSave.getSelectionModel().getSelectedItem());
        calculationModel.setFnpSave(fnpSave);

        try {
            int woundsCount = sanitize(wounds.getText());
            calculationModel.setWounds(woundsCount);
        } catch (Exception e) {
            raiseValidationError("Wounds must be a number!");
            return null;
        }
        try {
            int pointsCount = sanitize(points.getText());
            calculationModel.setPoints(pointsCount);
        } catch (Exception e) {
            raiseValidationError("Shots must be a number!");
            return null;
        }

        return calculationModel;
    }

    private int sanitize(String s) {
        String sanitizedHit = s.replace("-", "-1").replace("+", "").replace("Automatic", "-1").replace("D", "-1");
        return Integer.parseInt(sanitizedHit);
    }

    private int sanitizeD6(String s) {
        String sanitizedHit = s.replace("-", "7").replace("+", "").replace("Automatic", "-1").replace("D", "-1");
        return Integer.parseInt(sanitizedHit);
    }

    private void raiseValidationError(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Input validation failed");
        alert.setHeaderText(message);
        alert.showAndWait();
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