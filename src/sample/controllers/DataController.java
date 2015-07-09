package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class DataController implements Initializable {
    private final ObservableList<Data> datas = FXCollections.observableArrayList();
    @FXML
    private TableView<Data> equipment;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datas.add(new Data("Devices", "laptop, mouse, power cable"));
        datas.add(new Data("Software", "Windows 8"));
        datas.add(new Data("Browser", "Chrome"));
        equipment.setItems(datas);

    }
    public void handleCreateAction(ActionEvent actionEvent) {
    }

    public void handleUpdateAction(ActionEvent actionEvent) {

    }

    public void handleDeleteAction(ActionEvent actionEvent) {
        Data selectedData = equipment.getSelectionModel().getSelectedItem();
        if (selectedData != null) {
            datas.remove(selectedData);
        }

    }


}
