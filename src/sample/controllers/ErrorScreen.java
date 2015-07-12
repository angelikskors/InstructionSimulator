package sample.controllers;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;

public class ErrorScreen extends VBox {
    private String msg;
    private VBox vBox;
    private Image image;

    ErrorScreen(String msg, Image image) {
        this.msg = msg;
        this.image = image;
        VBox uiError = buildError(msg);
    }

    ErrorScreen(String msg) {
        this.msg = msg;

        VBox uiAdvice = buildAdvice(msg);
    }

    ErrorScreen(Image image) {

        this.image = image;
        VBox uiError = buildError(msg);
    }

    private VBox buildAdvice(String msg) {
        File f = new File("style.css");
        getStylesheets().add(f.toURI().toString());
        setPadding(new Insets(10, 10, 10, 10));
        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        getStyleClass().add("background-advice");
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Label newLabel = new Label();
        newLabel.getStyleClass().add("label-advice");
        newLabel.setText(msg);
        newLabel.setWrapText(true);
        newLabel.setAlignment(Pos.CENTER);
        getChildren().add(hBox);
        hBox.getChildren().add(newLabel);


        return vBox;

    }

    private VBox buildError(String msg) {
        File f = new File("style.css");
        getStylesheets().add(f.toURI().toString());
        setPadding(new Insets(10, 10, 10, 10));
        vBox = new VBox();
        getStyleClass().add("background-error");
        HBox stringsBox = new HBox();

        ImageView newImageView = new ImageView();
        newImageView.setImage(image);
        newImageView.setFitHeight(110);
        newImageView.setFitWidth(140);
        newImageView.setLayoutX(0);
        Label newLabel = new Label();
        newLabel.getStyleClass().add("error");
        newLabel.setText(msg);
        newLabel.setWrapText(true);


        newLabel.setAlignment(Pos.BOTTOM_CENTER);

        newLabel.setGraphic(newImageView);
        HBox hBox = new HBox();
        getChildren().add(hBox);
        hBox.getChildren().add(newImageView);
        hBox.getChildren().add(newLabel);
        getChildren().add(stringsBox);

        return vBox;
    }

}