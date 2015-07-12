package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.util.Random;

public class StartScreen extends VBox {
    public static int stageCount;
    private static boolean answer;
    Image image;
    Button momAnswer;
    private HBox hBox;
    private VBox vBox;
    StartScreen(Image image) {
        this.image = image;
        VBox uiNewUser = buildUIForNewUser(image);
        getChildren().add(uiNewUser);

    }

    private VBox buildUIForNewUser(Image image) {
        File f = new File("style.css");
        getStylesheets().add(f.toURI().toString());
        getStyleClass().add("background");
        vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(5);

        HBox image1 = new HBox();
        ImageView newImageView = new ImageView();
        newImageView.setImage(image);
        if (stageCount == 5) {
            newImageView.setFitHeight(400);
            newImageView.setFitWidth(1000);
            Label label = new Label();
            label.getStyleClass().add("label-big");
            label.setText("Good job!");
            Label label1 = new Label();
            label1.getStyleClass().add("label-little");
            label1.setText("I see you! :)");
            Label label2 = new Label();
            label2.setText("Hi! ");
            label2.getStyleClass().add("label-little");

            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            vBox.getChildren().add(hBox);
            hBox.getChildren().add(label);
            HBox hBox1 = new HBox();
            hBox1.setSpacing(60);
            hBox1.setAlignment(Pos.CENTER_RIGHT);
            vBox.getChildren().add(hBox1);
            HBox hBox2 = new HBox();
            hBox2.setAlignment(Pos.CENTER_LEFT);
            vBox.getChildren().add(hBox2);
            hBox2.getChildren().add(label2);
            hBox1.getChildren().add(label1);
        } else
            newImageView.setFitHeight(500);
        newImageView.setFitWidth(600);
        vBox.getChildren().add(image1);
        image1.getChildren().add(newImageView);

        if (stageCount < 5) {
            HBox option = new HBox();
            option.setSpacing(300);
            vBox.getChildren().add(option);
            Button sendMMS = new Button();
            sendMMS.getStyleClass().add("button");
            sendMMS.setAlignment(Pos.BOTTOM_LEFT);
            sendMMS.setText("Send MMS");
            sendMMS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Image image1 = new Image("file:count.png");
                    createImageWindow(image1, "The MMS is sent");
                    answer = true;
                    momAnswer.setVisible(true);
                }
            });
            option.getChildren().add(sendMMS);

            HBox option2 = new HBox();
            momAnswer = new Button();
            momAnswer.setAlignment(Pos.BOTTOM_CENTER);
            momAnswer.getStyleClass().add("button");
            momAnswer.setText("Mom answer");
            momAnswer.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    if (generateAnswer() || answer) {
                        stageCount++;
                        System.out.println(stageCount);
                        goNextWindow();
                    } else {
                        HBox hBox = new HBox();
                        vBox.getChildren().add(hBox);

                        Button details = new Button();

                        details.setText("TO DO");
                        hBox.getChildren().add(details);
                        details.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                if (stageCount == 1) {
                                    createWindowInstruction("If you don't see any movement on the screen despite moving the mouse you should turn the mouse over and switch it on.you may as well use touchpad. Try to put cursor straight on the circle and touch the touchpad twice using the same finger. ");
                                } else if (stageCount == 2) {
                                    createWindowInstruction("Put the cursor into the end of the sentence you've entered into the search panel and press button delete until it becomes empty. Then reenter the link .");
                                } else if (stageCount == 3) {
                                    createWindowInstruction("Try to look through the filled in fields more carefully");
                                } else if (stageCount == 4) {
                                    createWindowInstruction("Check all necessary fields to be filled in and  if you don't know what login to enter click twice on the empty field and choose the most suitable, in regard to password you can enter the mail password .");
                                }
                                momAnswer.setVisible(true);
                            }
                        });
                        momAnswer.setVisible(false);


                        System.out.println("NO true");

                    }

                }
            });
            vBox.getChildren().add(option2);
            option.getChildren().add(momAnswer);
        }
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
        if (stageCount == 1) {
            Image image = new Image("file:dialog11.png");

            StartScreen startScreen = new StartScreen(image);
            Scene scene = new Scene(startScreen, 650, 630);
            MainWindowController.thisStage.setScene(scene);
        } else if (stageCount == 2) {
            Image image = new Image("file:dialog12.png");
            StartScreen startScreen = new StartScreen(image);
            Scene scene = new Scene(startScreen, 650, 630);
            MainWindowController.thisStage.setScene(scene);
        } else if (stageCount == 3) {
            Image image = new Image("file:dialog13.png");
            StartScreen startScreen = new StartScreen(image);
            Scene scene = new Scene(startScreen, 650, 630);
            MainWindowController.thisStage.setScene(scene);
        } else if (stageCount == 4) {
            Image image = new Image("file:dialog14.png");
            StartScreen startScreen = new StartScreen(image);
            Scene scene = new Scene(startScreen, 650, 630);
            MainWindowController.thisStage.setScene(scene);
        } else if (stageCount == 5) {
            Image image = new Image("file:dialog15.png");
            StartScreen startScreen = new StartScreen(image);
            Scene scene = new Scene(startScreen, 650, 630);
            MainWindowController.thisStage.setScene(scene);
        }
        if (stageCount == 5) {
            Image image = new Image("file:end.png");
            StartScreen startScreen = new StartScreen(image);
            Scene scene = new Scene(startScreen, 650, 630);
            MainWindowController.thisStage.setScene(scene);
            stageCount = 0;
        } else if (stageCount > 5) {
            getScene().getWindow().hide();

        }

    }

    ;


    private boolean generateAnswer() {
        Random random = new Random();
        double rand = random.nextDouble();
        System.out.println("rand" + rand);
        if (rand < 0.5) {
            if (stageCount == 0) {
                createWindowError("I am busy now");
                getScene().getWindow().hide();
                return answer = false;
            } else if (stageCount == 1) {
                createWindowError("I don't see the cursor on the screen. I can't handle with clicking");

                return answer = false;
            } else if (stageCount == 2) {
                createWindowError(" I don't see anything but white page");

                return answer = false;
            } else if (stageCount == 3) {
                createWindowError("It's difficult to manage to fill in this form");

                return answer = false;
            } else if (stageCount == 4) {
                createWindowError("I have an error that information is incorrect");

                return answer = false;
            } else if (stageCount == 5) {

            }
            return answer = false;

        } else
            return answer = true;
    }

    private void createWindowError(String message) {
        Image image = new Image("file:question1.jpg");
        ErrorScreen error = new ErrorScreen(message, image);
        Stage stage = new Stage();
        stage.setTitle("ERROR");
        Scene scene = new Scene(error, 360, 140);
        stage.setScene(scene);
        stage.show();
    }

    private void createWindowInstruction(String message) {

        ErrorScreen error = new ErrorScreen(message);
        Stage stage = new Stage();
        stage.setTitle("ADVICE");
        Scene scene = new Scene(error, 400, 350);
        stage.setScene(scene);
        stage.show();
    }



}
