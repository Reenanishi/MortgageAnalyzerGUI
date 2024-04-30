package com.IndividualHealthAssessmentProgram;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class HealthAssessmentController implements Initializable {

    @FXML
    private TextField BloodPressureField;

    @FXML
    private TextField BMIField;

    @FXML
    private TextField CholesterolLDLField;

    @FXML
    private TextField CholesterolHDLField;

    @FXML
    private TextField GlucoseBloodSugarField;

    @FXML
    private TextField TriglyceridesField;

    @FXML
    private Label BloodPressureStatusLabel;


    @FXML
    private Label BMIStatusLabel;

    @FXML
    private Label CholesterolLDLStatusLabel;

    @FXML
    private Label CholesterolHDLStatusLabel;

    @FXML
    private Label CholesterolTotalStatusLabel;

    @FXML
    private Label GlucoseBloodSugarStatusLabel;

    @FXML
    private Label TriglyceridesStatusLabel;

    @FXML
    private TextField fileNameTextField;

    @FXML
    private Button CalculateButton;


    public void initialize(URL location, ResourceBundle resources) {
    }


    @FXML
    private void calculateAction(ActionEvent event) {

        try {

            String bp = BloodPressureField.getText();
            Integer bpInt = Integer.valueOf(bp);
            String bpResult = calculateBloodPressure(bpInt);
            BloodPressureStatusLabel.setText(bpResult);

            String bmi = BMIField.getText();
            Float bmiFloat = Float.valueOf(bmi);
            String bmiResult = calculateBmi(bmiFloat);
            BMIStatusLabel.setText(bmiResult);


            String level = GlucoseBloodSugarField.getText();
            Integer levelInt = Integer.valueOf(level);
            String levelResult = calculateBloodGlucoseHemoglobin(levelInt);
            GlucoseBloodSugarStatusLabel.setText(levelResult);


            String tri = TriglyceridesField.getText();
            Integer triInt = Integer.valueOf(tri);
            String triResult = calculateTriglycerides(triInt);
            TriglyceridesStatusLabel.setText(triResult);


            String ldl = CholesterolLDLField.getText();
            Integer ldlInt = Integer.valueOf(ldl);
            String ldlResult = calculateLDLCholesterol(ldlInt);
            CholesterolLDLStatusLabel.setText(ldlResult);

            String hdl = CholesterolHDLField.getText();
            Integer hdlInt = Integer.valueOf(hdl);
            String hdlResult = calculateHDLCholesterol(hdlInt);
            CholesterolHDLStatusLabel.setText(hdlResult);

            Integer totalCholesterol = hdlInt + ldlInt;
            String totalCholesterolResult = totalCholesterol(totalCholesterol);
            CholesterolTotalStatusLabel.setText(totalCholesterolResult);

            checkSeverity(bpInt, bmiFloat, levelInt, triInt, ldlInt, hdlInt);
        } catch (Exception ex) {
            dialogHandler("Error: " + ex.getMessage());
        }
    }

    @FXML
    private void saveToFile(ActionEvent event) {
        try{

            Integer bloodPressure = Integer.valueOf(BloodPressureField.getText());
            Float bmi = Float.valueOf(BMIField.getText());
            Integer bloodGlucoseHemoglobin = Integer.valueOf(GlucoseBloodSugarField.getText());
            Integer triglycerides = Integer.valueOf(TriglyceridesField.getText());
            Integer cholesterolLDL = Integer.valueOf(CholesterolLDLField.getText());
            Integer cholesterolHDL = Integer.valueOf(CholesterolHDLField.getText());

            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(com.IndividualHealthAssessmentProgram.HealthReport.class.getPackage().getName(),
                    com.IndividualHealthAssessmentProgram.HealthReport.class.getClassLoader());
//
//            com.myexample.test.ObjectFactory objectFactory = new com .myexample.test.ObjectFactory();
//            JAXBContext jaxbContext = JAXBContext.newInstance(objectFactoryMessageBody.getClass());

//            JAXBContext jContext = JAXBContext.newInstance(hellofx.IndividualHealthAssessmentProgram.HealthReport.class);
            //creating the marshaller object
            Marshaller marshallObj = jContext.createMarshaller();
            //setting the property to show xml format output
            marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //setting the values in POJO class
            HealthReport healthReport = new HealthReport(bloodPressure, bmi, bloodGlucoseHemoglobin, triglycerides,
                    cholesterolLDL, cholesterolHDL);

            marshallObj.marshal(healthReport, System.out);
            //calling the marshall method
            marshallObj.marshal(healthReport, new FileOutputStream(fileNameTextField.getText()));

        } catch (Exception ex) {
            dialogHandler("Error saving: " + ex.getMessage());
        }
    }

    @FXML
    private void loadFromFile(ActionEvent event) {
        try{
            //getting the xml file to read
            File file = new File("/Users/ankurpandey/IdeaProjects/hellofx/src/hellofx/IndividualHealthAssessmentProgram/book.xml");

            if (file.exists()) {
                dialogHandler("File exists");
            }
            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(com.IndividualHealthAssessmentProgram.HealthReport.class );
            //creating the unmarshall object
            Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
            //calling the unmarshall method
            HealthReport healthReport=(HealthReport) unmarshallerObj.unmarshal(file);


            Integer bpInt = healthReport.getBloodPressure();
            BloodPressureField.setText(bpInt.toString());
            String bpResult = calculateBloodPressure(bpInt);
            BloodPressureStatusLabel.setText(bpResult);

            Float bmiFloat = healthReport.getBMI();
            BMIField.setText(bmiFloat.toString());
            String bmiResult = calculateBmi(bmiFloat);
            BMIStatusLabel.setText(bmiResult);

            Integer glucoseInt = healthReport.getBloodGlucoseHemoglobin();
            GlucoseBloodSugarField.setText(glucoseInt.toString());
            String glocuseResult = calculateBloodGlucoseHemoglobin(glucoseInt);
            GlucoseBloodSugarStatusLabel.setText(glocuseResult);

            Integer triInt = healthReport.geTriglycerides();
            TriglyceridesField.setText(triInt.toString());
            String triResult = calculateTriglycerides(triInt);
            TriglyceridesStatusLabel.setText(triResult);

            Integer ldlInt = healthReport.getCholesterolLDL();
            CholesterolLDLField.setText(ldlInt.toString());
            String ldlResult = calculateLDLCholesterol(ldlInt);
            CholesterolLDLStatusLabel.setText(ldlResult);

            Integer hdlInt = healthReport.getCholesterolHDL();
            CholesterolHDLField.setText(hdlInt.toString());
            String hdlResult = calculateHDLCholesterol(hdlInt);
            CholesterolHDLStatusLabel.setText(hdlResult);

            Integer totalCholesterol = hdlInt + ldlInt;
            String totalCholesterolResult = totalCholesterol(totalCholesterol);
            CholesterolTotalStatusLabel.setText(totalCholesterolResult);

            checkSeverity(bpInt, bmiFloat, glucoseInt, triInt, ldlInt, hdlInt);

        } catch (Exception ex) {
            dialogHandler("Error loading : " + ex.getMessage());
        }
    }

    private String calculateBloodPressure(Integer userInput) {
        if (userInput >= 50 && userInput < 90) {
            return "Low";
        } else if (userInput >= 90 && userInput < 140) {
            return "Normal";
        } else if (userInput >= 140 && userInput < 160) {
            return "Mild";
        } else if (userInput >= 160 && userInput < 180) {
            return "Moderate";
        } else if (userInput >= 180 && userInput < 210) {
            return "Severe";
        } else {
            return "Very severe";
        }
    }

    private String calculateBmi(Float userInput) {
        if (userInput < 18.5) {
            return "Underweight";
        } else if (userInput < 25) {
            return "Normal";
        } else if (userInput < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    private String calculateBloodGlucoseHemoglobin(Integer userInput) {
        if (userInput >= 80 && userInput <= 120) {
            return "Excellent";
        } else if (userInput >= 150 && userInput <= 180) {
            return "Good";
        } else if (userInput >= 210 && userInput <= 240) {
            return "Marginal";
        } else if (userInput >= 270 && userInput <= 310) {
            return "Poor";
        } else {
            return "Out of control";
        }
    }


    private String calculateTriglycerides(Integer userInput) {
        if (userInput < 250) {
            return "Optimal";
        } else {
            return "Not Optimal";
        }
    }


    private String calculateHDLCholesterol(Integer userInput) {
        if (userInput > 40) {
            return "Optimal";
        } else {
            return "Not Optimal";
        }
    }


    private String calculateLDLCholesterol(Integer userInput) {
        if (userInput < 100) {
            return "Optimal";
        } else {
            return "Not Optimal";
        }
    }


    private String totalCholesterol(Integer userInput) {
        if (userInput < 200) {
            return "Excellent";
        } else {
            return "Not Optimal";
        }
    }



    private void checkSeverity(Integer bp, Float bmi, Integer BloodGlucose, Integer Triglycerides, Integer  Ldl, Integer Hdl  ){
        if(bp > 210){
            dialogHandler("Consult the Doctor immediately due to Severe high bp");
        }
        if(bp < 50) {
            dialogHandler("Consult the Doctor immediately due to Severe low bp");
        }

        if(bmi > 130){
            dialogHandler("Consult the Doctor immediately,you are Obese");
        }

        if(bmi < 18.50){
            dialogHandler("Consult the Doctor immediately, you are Underweight");
        }
        if( BloodGlucose > 340) {
            dialogHandler("Consult the Doctor immediately due to Out of control");
        }
        if( BloodGlucose <  80 ) {
            dialogHandler("Consult the Doctor immediately due to low blood glucose");
        }

        if( Triglycerides > 340) {
            dialogHandler("Consult the Doctor immediately due to Out of control");
        }

        if( Ldl + Hdl > 600) {
            dialogHandler("Consult the Doctor immediately, your cholesterol is too high ");
        }

    }

    private void dialogHandler(String message) {
        Dialog dialog = new Dialog();
        dialog.setTitle("Dialog");
        ButtonType button = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialog.setContentText(message);
        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(button);
        dialog.showAndWait();
    }
}




