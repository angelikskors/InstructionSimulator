package sample.controllers;


import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AlgoritmsController extends VBox {

    public ImageView imageView;
    public VBox vBox;

    AlgoritmsController() {
        VBox uiNewUser = buildUIForNewUser();
        getChildren().add(uiNewUser);
    }

    private VBox buildUIForNewUser() {
        File f = new File("style.css");
        getStylesheets().add(f.toURI().toString());
        getStyleClass().add("background-algorithm");
        vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(50);
        HBox hBox = new HBox();
        Button algoritm = new Button();
        algoritm.setDefaultButton(true);
        algoritm.setText("Algorithm");

        algoritm.setAlignment(Pos.BASELINE_LEFT);
        algoritm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Image image = new Image("file: algorithm.png");
                imageView = new ImageView();
                imageView.setImage(image);
                vBox.getChildren().add(imageView);
            }
        });
        hBox.getChildren().add(algoritm);
        vBox.getChildren().add(hBox);
        Button action = new Button();
        action.setText("Actions");
        action.setAlignment(Pos.BASELINE_LEFT);
        HBox hBox1 = new HBox();

        action.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vBox.getStyleClass().add("background-for-text");
                HBox hbox = new HBox();
                Image image = new Image("file: preventiveAct.png");
                imageView = new ImageView();
                imageView.setImage(image);
                hbox.getChildren().add(imageView);
                vBox.getChildren().add(hbox);
            }
        });
        hBox1.getChildren().add(action);
        vBox.getChildren().add(hBox1);


        return vBox;
    }

//    public void handleCurrent(ActionEvent actionEvent) {
//        Image image = new Image("file: algorithm.png");
//        imageView=new ImageView();
//        imageView.setImage(image);
//    }
//
//    public void handleFirst(ActionEvent actionEvent) {
//
//       vBox=new BorderPane();
//        vBox.getStyleClass().add("background-for-text");
//        HBox hbox=new HBox();
//        Image image = new Image("file: preventiveAct.png");
//        imageView=new ImageView();
//        imageView.setImage(image);
//        hbox.getChildren().add(imageView);
//        vBox.getChildren().add(hbox);
//    }
//
//    public void handleSecond(ActionEvent actionEvent) {
//
//    }


}
