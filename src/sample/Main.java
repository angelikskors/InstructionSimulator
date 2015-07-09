package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.utils.FXMLHelper;

import java.io.IOException;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {




    public static void main(String[] args) throws IOException {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(new Locale("", ""));
        ResourceBundle resources = FXMLHelper.resources();
        FXMLLoader loader = FXMLHelper.loader("fxml/MainWindow.fxml");
        Parent root = loader.load();
        primaryStage.setTitle(resources.getString("key_title"));
        root.getStyleClass().add("sample.css.style.css");
        primaryStage.setScene(new Scene(root, 1000, 560));
        primaryStage.show();
    }
}