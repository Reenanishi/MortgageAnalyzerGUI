package com.GradeIO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class GradeIOController implements Initializable {
    FileHandler fileHandler;
    private ArrayList<String> gradesFromFile;

    @FXML
    private TextField readFileField;

    @FXML
    private ComboBox<String> comboBoxField;

    @FXML
    private Label GPALabel;

    @FXML
    private Label operationLabel;

    @FXML
    private Button readGradeFileButton;

    @FXML
    private Button calculateGPAButton;

    @FXML
    private Button okButton;

    @FXML
    private Button minimizeButton;


    public void initialize(URL location, ResourceBundle resources) {
        String filename = "/Users/ankurpandey/IdeaProjects/hellofx/src/hellofx/GradeIO/grades.txt";
        fileHandler = new FileHandler(filename, filename);
        gradesFromFile = new ArrayList<String>();
    }

    @FXML
    private void handleReadGrades(ActionEvent event) {
        // Read from file and populate in gradesFromFile
         String fileName = readFileField.getText();
        operationLabel.setText(fileName );

         fileHandler = new FileHandler(fileName, fileName);

         if (fileHandler.isFileToRead()) {
             fileHandler.readFromeFile(gradesFromFile);
             ObservableList<String> comboBoxData = FXCollections.observableArrayList(gradesFromFile);
             comboBoxField.setItems(comboBoxData);
             operationLabel.setText("Read file successful");
             GPALabel.setText("...");
         } else {
             operationLabel.setText("Read file not successful");
             GPALabel.setText("...");
         }
    }

    @FXML
    private void handleCalcGPA(ActionEvent event) {
        String grade = comboBoxField.getSelectionModel().getSelectedItem();
        String gradeNumber = convertGradeToGPA(grade);
        if (gradeNumber.length() != 0) {
            GPALabel.setText(gradeNumber);
        }
        operationLabel.setText("");
    }

    private String convertGradeToGPA(String grade) {
        if (grade.equals("A")) {
            return "4.0";
        } else if (grade.equals("A-")) {
            return "3.7";
        } else if (grade.equals("B+")) {
            return "3.3";
        } else if (grade.equals("B")) {
            return "3.0";
        } else if (grade.equals("B-")) {
            return "2.7";
        } else if (grade.equals("C+")) {
            return "2.3";
        } else if (grade.equals("C")) {
            return "2.0";
        } else if (grade.equals("C-")) {
            return "1.7";
        } else if (grade.equals("D+")) {
            return "1.3";
        } else if (grade.equals("D")) {
            return "1.0";
        } else if (grade.equals("D-")) {
            return "0.7";
        } else {
            return "0.0";
        }
    }


    @FXML
    private void okButtonAction(ActionEvent event) {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void minimizeButtonAction(ActionEvent event) {
        Stage stage = (Stage) minimizeButton.getScene().getWindow();
        stage.setIconified(true);
    }

}

