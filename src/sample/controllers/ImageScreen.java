package sample.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;

public class ImageScreen extends VBox {
    VBox vBox;
    private Image image;
    private String msg;
    ImageScreen(String msg, Image image) {
        this.msg = msg;
        this.image = image;
        VBox uiError = buildError(msg, image);
    }

    private VBox buildError(String msg, Image image) {
        File f = new File("style.css");
        getStylesheets().add(f.toURI().toString());
        setPadding(new Insets(10, 10, 10, 10));
        vBox = new VBox();
        getStyleClass().add("background-error");
        HBox stringsBox = new HBox();
        stringsBox.setAlignment(Pos.BASELINE_CENTER);
        ImageView newImageView = new ImageView();
        newImageView.setImage(image);
        newImageView.setFitHeight(250);
        newImageView.setFitWidth(420);

        Label newLabel = new Label();
        newLabel.getStyleClass().add("label-advice");
        newLabel.setText(msg);

        newLabel.setWrapText(true);


        newLabel.setAlignment(Pos.BOTTOM_CENTER);

        // newLabel.setGraphic(newImageView);
        HBox hBox = new HBox();
        getChildren().add(hBox);
        hBox.getChildren().add(newImageView);
        stringsBox.getChildren().add(newLabel);
        getChildren().add(stringsBox);

        return vBox;
    }

}
