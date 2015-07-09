package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.File;
import java.util.Random;

public class StartScreen extends VBox {
    private HBox hBox;
    private VBox vBox;
    private static boolean answer;
    private static int stageCount;
    Image image;

    StartScreen(Image image) {
        this.image = image;
        VBox uiNewUser = buildUIForNewUser(image);
        getChildren().add(uiNewUser);
    }

    private VBox buildUIForNewUser(Image image) {
        File f = new File("style.css");
        getStylesheets().add(f.toURI().toString());
        vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(5);

        HBox image1 = new HBox();
        ImageView newImageView = new ImageView();
        newImageView.setImage(image);
        newImageView.setFitHeight(500);
        newImageView.setFitWidth(600);
        vBox.getChildren().add(image1);
        image1.getChildren().add(newImageView);
        HBox option = new HBox();
        option.setSpacing(50);
        vBox.getChildren().add(option);
        Button sendMMS = new Button();
        sendMMS.setAlignment(Pos.BOTTOM_LEFT);
        sendMMS.setText("Send MMS");
        sendMMS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Image image1 = new Image("file:count.png");

                createImageWindow(image1, "The MMS is sent");
                answer = true;
            }
        });
        option.getChildren().add(sendMMS);

        HBox option2 = new HBox();
        Button momAnswer = new Button();
        momAnswer.setAlignment(Pos.BOTTOM_CENTER);
        momAnswer.setText("Mom answer");
        momAnswer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (answer | generateAnswer()) {
                    stageCount++;
                    System.out.println(stageCount);
                    goNextWindow();
                } else {
                    System.out.println("NO true");

                }

            }
        });
        vBox.getChildren().add(option2);
        option2.getChildren().add(momAnswer);
        return vBox;
    }

    private void createImageWindow(Image image1, String message) {
        ImageView newImageView = new ImageView();
        newImageView.setImage(image1);
        newImageView.setFitHeight(55);
        newImageView.setFitWidth(55);
        Stage stage = new Stage();
        ImageScreen root = new ImageScreen(message, image1);
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }

    private void goNextWindow() {

        StartScreen startScreen = new StartScreen(image);

        Scene scene = new Scene(startScreen, 400, 400);
        MainWindowController.thisStage.setScene(scene);
        System.out.println("New Stage");
    }

    ;


    private boolean generateAnswer() {
        Random random = new Random();
        double rand = random.nextDouble();
        if (rand < 0.5) {
            createWindowError("");
            HBox hBox=new HBox();
            vBox.getChildren().add(hBox);
            Button details=new Button();
            details.setText("TO DO");
            hBox.getChildren().add(details);
            return answer = false;
        } else
            return answer = true;
    }

    private void createWindowError(String message) {
        Image image = new Image("file:questions1.jpg");
        ErrorScreen error = new ErrorScreen(message, image);
        Stage stage = new Stage();
        stage.setTitle("ERROR");
        Scene scene = new Scene(error, 360, 140);
        stage.setScene(scene);
        stage.show();
    }


}
