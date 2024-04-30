package com.Learning;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ControllerLearning {

    Image image;
    Image image2;

    @FXML
    private Label labelx;

    @FXML
    private TextField fieldy;

    @FXML
    private ImageView imageViewx;


    @FXML
    private Button buttonz;

    public void initialize() throws FileNotFoundException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        labelx.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
         image = new Image(new FileInputStream("/Users/ankurpandey/IdeaProjects/parrot.jpeg"));
        image2 = new Image(new FileInputStream("/Users/ankurpandey/IdeaProjects/icon-bird-7.jpeg"));
        imageViewx.setImage(image);
    }


    @FXML
    private void buttonzClick(ActionEvent event) {
        String inputField =  fieldy.getText();
        labelx.setText(inputField);
        imageViewx.setImage(image2);
    }


}

