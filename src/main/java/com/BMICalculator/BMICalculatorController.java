package  com.BMICalculator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class BMICalculatorController implements Initializable {
    BMICalculator bmiCalculator;

    @FXML
    private TextField weightField;

    @FXML
    private TextField heightField;

    @FXML
    private Label BMIMessageLabel;

    @FXML
    private Button calculateBMIButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bmiCalculator = new BMICalculator();
    }


    @FXML
    private void calculateBMIButtonAction(ActionEvent event) {
        Float weight =  Float.parseFloat(weightField.getText());
        Float height =  Float.parseFloat(heightField.getText());
        bmiCalculator.setWeight(weight);
        bmiCalculator.setHeight(height);
        Float bmi = bmiCalculator.getBMIIndex();
        String message = bmiCalculator.getMessage(bmi);
        String result = "BMI index is " + bmi.toString() + " \n" + message;
        BMIMessageLabel.setText(result);
        dialogHandler(bmi);
    }


    private void dialogHandler(Float bmi) {
        if (bmi > 18.5 && bmi < 35.0) {
            return;
        }

        Dialog dialog = new Dialog();
        dialog.setTitle("Dialog");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);

        //Setting the content of the dialog
        if (bmi < 18.5) {
            dialog.setContentText("Consult the Doctor immediately due to seriously underweight BMI indication");
        } else {
            dialog.setContentText("Consult the Doctor immediately due to overly obese BMI indication");
        }

        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);

        dialog.showAndWait();
    }

}

