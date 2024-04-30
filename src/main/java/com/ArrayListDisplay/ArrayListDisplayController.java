package com.ArrayListDisplay;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;


public class ArrayListDisplayController implements Initializable {

    ListView listView;

    @FXML
    private HBox hboxId;

    private void populateData() {
        listView.getItems().add(1);
        listView.getItems().add(76);
        listView.getItems().add(3);
        listView.getItems().add(2);
        listView.getItems().add(54);
        listView.getItems().add(6);
        listView.getItems().add(72);
        listView.getItems().add(8);
        listView.getItems().add(9);
        listView.getItems().add(100);
        listView.getItems().add(11);
        listView.getItems().add(5);
        listView.getItems().add(13);
        listView.getItems().add(14);
        listView.getItems().add(1);
        listView.getItems().add(2);
        listView.getItems().add(17);
        listView.getItems().add(3);
        listView.getItems().add(3);
        listView.getItems().add(4);
    }

    public void initialize(URL location, ResourceBundle resources) {
        listView = new ListView();
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        populateData();
        display();
    }

    private void display() {
        hboxId.getChildren().clear();
        hboxId.getChildren().addAll(listView);
    }


    @FXML
    private TextField addPosition;

    @FXML
    private TextField addValue;

    @FXML
    private void addButtonAction(ActionEvent event) {
        String position = addPosition.getText();
        System.out.println(position);
        Integer positionInteger = Integer.valueOf(position);

        String value  = addValue.getText();
        System.out.println(value);
        Integer valueInteger = Integer.valueOf(value);

        listView.getItems().add(positionInteger, valueInteger);
        display();
    }

    // Delete
    @FXML
    private Button deleteButton;


    @FXML
    private TextField deletePosition;


    @FXML
    private void deleteButtonAction(ActionEvent event) {
        String position = deletePosition.getText();
        System.out.println(position);
        Integer positionInteger = Integer.valueOf(position);
        listView.getItems().remove(positionInteger);
        display();
    }

    // Sort and display
    @FXML
    private void sortAndDisplayAction(ActionEvent event) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.addAll(listView.getItems().sorted());

        listView = new ListView();
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for(int i = 0; i < numbers.size(); i++ ) {
            listView.getItems().add(numbers.get(i));
        }

        display();
    }


    // Size display
    @FXML
    private Label sizeLabel;

    @FXML
   private void displaySizeAction(ActionEvent event) {
      int size = listView.getItems().size();
      String sizeStr = String.valueOf(size);
      sizeLabel.setText("Size is " + sizeStr);
    }

    // Search Value
    @FXML
    private TextField searchValue;

    @FXML
    private Label countLabel;


    @FXML
    private void searchValueAction(ActionEvent event) {
        String value  = searchValue.getText();
        System.out.println(value);
        Integer valueInteger = Integer.valueOf(value);
        listView.getSelectionModel().clearSelection();

        Integer count = 0;
        String positions = "";
        int size = listView.getItems().size();
        for(int i = 0; i < size; i++ ){
            System.out.println(listView.getItems().get(i));
             if (valueInteger == listView.getItems().get(i)) {
                 count++;
                 listView.getSelectionModel().selectIndices(i);
             }
        }
        String countStr = String.valueOf(count);
        countLabel.setText("Count is " + countStr);
    }

    @FXML
    private void displayAction(ActionEvent event) {
        display();
    }

}

