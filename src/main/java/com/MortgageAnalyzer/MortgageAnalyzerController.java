package  com.MortgageAnalyzer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MortgageAnalyzerController implements Initializable {

    MortgageAnalyzer mortgageAnalyzer;
    CalculateMortgageDetails calculateMortgageDetails;

    @FXML
    private Label monthlyPaymentLabel;

    @FXML
    private Label totalInterestPaidLabel;

    @FXML
    private Button analyzerButton;

    @FXML
    private Button calculatorButton;

    @FXML
    private TextField principalField;

    @FXML
    private TextField interestRateField;

    @FXML
    private TextField durationField;


    public void initialize(URL location, ResourceBundle resources) {
        mortgageAnalyzer = new MortgageAnalyzer();
        calculateMortgageDetails = new CalculateMortgageDetails();
    }


    @FXML
    private void analyzerButtonAction(ActionEvent event) {
        String principal =  principalField.getText();
        String interestRate =  interestRateField.getText();
        String  duration = durationField.getText();

        double principalDouble = Double.valueOf(principal) ;
        double interestRateDouble = Double.valueOf(interestRate) ;
        float durationFloat = Float.valueOf(duration);

        monthlyPaymentLabel.setText("");
        totalInterestPaidLabel.setText("");

        mortgageAnalyzer.enterLoanAmount(principalDouble);
        mortgageAnalyzer.annualRateOfInterest(interestRateDouble);
        mortgageAnalyzer.durationOfTheLoan(durationFloat);


        if (mortgageAnalyzer.verify()) {
            String dialogText = "Success : Inputs are valid";
            dialogHandler(dialogText);
        } else {
            String dialogText ="Error: " + mortgageAnalyzer.correctInput() + ". Please correct your details";
            dialogHandler(dialogText);
        }

    }

    @FXML
    private void calculatorButtonAction(ActionEvent event) {

        String principal =  principalField.getText();
        String interestRate =  interestRateField.getText();
        String  duration = durationField.getText();

        double principalDouble = Double.valueOf(principal) ;
        double interestRateDouble = Double.valueOf(interestRate) ;
        float durationFloat = Float.valueOf(duration);

        double monthlyInterestRate = interestRateDouble/12;

        double monthlyPayment  = calculateMortgageDetails.getMonthlyPayment(principalDouble, monthlyInterestRate, durationFloat);
        double totalInterest  = calculateMortgageDetails.getTotalInterest(principalDouble, monthlyInterestRate, durationFloat);
        String  monthlyPaymentStr = String.valueOf(monthlyPayment);
        String  totalInterestStr = String.valueOf(totalInterest);

        monthlyPaymentLabel.setText(monthlyPaymentStr);
        totalInterestPaidLabel.setText(totalInterestStr);
    }


    private void dialogHandler(String dialogText) {

        Dialog dialog = new Dialog();
        dialog.setTitle("Dialog");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(dialogText);
        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

}




