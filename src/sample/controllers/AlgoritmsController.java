package sample.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AlgoritmsController implements Initializable {
    public Image image;
    public ImageView imageView;

    public void handleCurrent(ActionEvent actionEvent) {

    }

    public void handleFirst(ActionEvent actionEvent) {

    }

    public void handleSecond(ActionEvent actionEvent) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image = new Image("file: imgMom.png");
        imageView.setImage(image);
    }
}
