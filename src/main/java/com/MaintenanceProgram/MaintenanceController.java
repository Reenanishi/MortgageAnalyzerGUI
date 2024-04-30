package  com.MaintenanceProgram;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MaintenanceController implements Initializable {

    FileHandler fileHandler;
    ListView originalListView;
    ListView listView;

    @FXML
    private HBox hboxId;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button loadButton;

    @FXML
    private Button addButton;

    @FXML
    private Button selectButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button exitButton;


    @FXML
    private void loadButtonAction(ActionEvent event) {
        hboxId.getChildren().clear();
        listView.getItems().clear();
        listView.getItems().addAll(originalListView.getItems());
        hboxId.getChildren().addAll(listView);
    }

    @FXML
    private void addButtonAction(ActionEvent event) {
        String name =  nameTextField.getText();
        listView.getItems().add(name);
        hboxId.getChildren().clear();
        hboxId.getChildren().addAll(listView);
    }


    @FXML
    private void selectButtonAction(ActionEvent event) {
        ObservableList<ListView> selectedItems = listView.getSelectionModel().getSelectedItems();
        dialogHandler(selectedItems);
    }

    private void dialogHandler(ObservableList<ListView> selectedItems) {

        Dialog dialog = new Dialog();
        dialog.setTitle("Dialog");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);

        //Setting the content of the dialog
        String result = "";

        for(int i = 0; i < selectedItems.size(); i++) {
            result += selectedItems.get(i) + " \n ";
        }



        dialog.setContentText(result);

        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);

        dialog.showAndWait();
    }

    @FXML
    private void removeButtonAction(ActionEvent event) {
        ObservableList<ListView> selectedItems = listView.getSelectionModel().getSelectedItems();
        listView.getItems().removeAll(selectedItems);
        hboxId.getChildren().clear();
        hboxId.getChildren().addAll(listView);
    }


    @FXML
    private void resetButtonAction(ActionEvent event) {
        hboxId.getChildren().clear();
        listView.getItems().clear();
        listView.getItems().addAll(originalListView.getItems());
        hboxId.getChildren().addAll(listView);
    }

    @FXML
    private void exitButtonAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();

    }

    public void initialize(URL location, ResourceBundle resources) {
        String filename = "/Users/ankurpandey/IdeaProjects/hellofx/src/hellofx/MaintenanceProgram/names.txt";
        fileHandler = new FileHandler(filename, filename);
        ArrayList<String> names = new ArrayList<String>();
        fileHandler.readFromeFile(names);
        originalListView = new ListView();

        for(String name: names) {
            originalListView.getItems().add(name);
        }

        listView = new ListView();
        originalListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }




}
