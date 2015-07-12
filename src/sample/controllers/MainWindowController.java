package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import sample.utils.FXMLHelper;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController {
    public static Stage thisStage;
    public ImageView skype;
    @FXML
    private ImageView imgMom;
    @FXML
    private ImageView imgSon;

    public void initialize(URL location, ResourceBundle resources) {
        Image imgSkype=new Image("file:skype.png");
        Image imageMom = new Image("file: imgMom.png");
        Image imageSon = new Image("file:imgSon.jpg");
        skype=new ImageView();
        skype.setImage(imgSkype);
        imgMom = new ImageView();
        imgMom.setImage(imageMom);
        imgSon = new ImageView();
        imgSon.setImage(imageSon);


    }

    @FXML
    public void handleShowInputData() {
        ResourceBundle resources = FXMLHelper.resources();
        FXMLLoader fxmlLoader = FXMLHelper.loader("fxml/show_data.fxml", resources);

        Parent root1 = null;
        try {
            root1 = fxmlLoader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        showNewWindow("Input DATA", root1,250,240);
    }

    @FXML
    public void handleShowAlgoritms(ActionEvent actionEvent) {
//        ResourceBundle resources = FXMLHelper.resources();
//        FXMLLoader loader = FXMLHelper.loader("fxml/show_algoritms.fxml", resources);
//
//        Parent root = null;
//        try {
//            root = loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Image image = new Image("file:algorithm.png");
        AlgoritmsController startScreen = new AlgoritmsController();

        Scene scene = new Scene(startScreen, 2000, 1000);
        thisStage = new Stage();
        thisStage.setScene(scene);
        thisStage.show();
        // showNewWindow("Algoritms", root,2000,1000);

    }

    public void showNewWindow(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showNewWindow(String title, Parent root,int height, int width) {
        Stage stage = new Stage();
        stage.setTitle(title);
        Scene scene = new Scene(root,height,  width);
        stage.setScene(scene);
        stage.show();
    }


    public void handleStart(ActionEvent actionEvent) {
        Image image=new Image("file:dialog.png");
        StartScreen startScreen = new StartScreen(image);
        if (StartScreen.stageCount == 5) {
            Scene scene = new Scene(startScreen, 600, 300);
            thisStage = new Stage();
            thisStage.setScene(scene);
            thisStage.show();
        } else {
            Scene scene = new Scene(startScreen, 650, 630);
            thisStage = new Stage();
            thisStage.setScene(scene);
            thisStage.show();
        }


    }

    public void handleShowInfo(ActionEvent actionEvent) {
        ResourceBundle resources = FXMLHelper.resources();
        FXMLLoader loader = FXMLHelper.loader("fxml/show_info.fxml", resources);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showNewWindow("Information", root,500,350);

    }
}