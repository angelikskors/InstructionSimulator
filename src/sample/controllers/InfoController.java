package sample.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class InfoController  implements Initializable{
    public Label text;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text.setText("The idea of application is to transfer to the client the possibility of his parents being taught of the beginner steps in communication using technologies. Why? Since the older generation rarely takes  an interest in advanced technologies so it's more difficult for them to get used to permanent accelerating changes in the world. Our application enables our relatives to keep up with the running world and it also gives us an opportunity to keep in touch with our relatives . We hope our project will make it  easier.   ");
    }
}
