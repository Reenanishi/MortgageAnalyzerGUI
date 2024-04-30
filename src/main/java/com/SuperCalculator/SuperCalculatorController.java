package  com.SuperCalculator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SuperCalculatorController implements Initializable {

    @FXML
    private TextField firstNumberField;

    @FXML
    private TextField secondNumberField;

    @FXML
    private TextField resultNumberField;

    @FXML
    private Label displayActionLabel;

    @FXML
    private Button addButton;

    @FXML
    private Button subtractButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button divideButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button exitButton;

    public void initialize(URL location, ResourceBundle resources) {}


    @FXML
    private void addButtonAction(ActionEvent event) {
        Double num1 =  Double.parseDouble(firstNumberField.getText());
        Double num2 =  Double.parseDouble(secondNumberField.getText());
        Double result = num1 + num2;
        resultNumberField.setText(result.toString());
        displayActionLabel.setText("adding...");
    }

    @FXML
    private void subtractButtonAction(ActionEvent event) {
        Double num1 =  Double.parseDouble(firstNumberField.getText());
        Double num2 =  Double.parseDouble(secondNumberField.getText());
        Double result = num1 - num2;
        resultNumberField.setText(result.toString());
        displayActionLabel.setText("subtracting...");
    }

    @FXML
    private void multiplyButtonAction(ActionEvent event) {
        Double num1 =  Double.parseDouble(firstNumberField.getText());
        Double num2 =  Double.parseDouble(secondNumberField.getText());
        Double result = num1 * num2;
        resultNumberField.setText(result.toString());
        displayActionLabel.setText("multiplying...");
    }

    @FXML
    private void divideButtonAction(ActionEvent event) {
        Double num1 =  Double.parseDouble(firstNumberField.getText());
        Double num2 =  Double.parseDouble(secondNumberField.getText());
        displayActionLabel.setText("dividing...");

        if (num2 == 0) {
            resultNumberField.setText("Inf");
            return;
        }

        Double result = num1 / num2;
        resultNumberField.setText(result.toString());
    }

    @FXML
    private void clearButtonAction(ActionEvent event) {
        resultNumberField.setText("");
        firstNumberField.setText("");
        secondNumberField.setText("");
        displayActionLabel.setText("");
    }

    @FXML
    private void exitButtonAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
