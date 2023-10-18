package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
        StackPane all = new StackPane();
         ImageView background = new ImageView();
        background.setImage(new Image("C:\\Users\\amin\\IdeaProjects\\demo\\src\\MediaResources\\Wallpaper.jpg"));
        background.setFitHeight(500);
        background.setFitWidth(500);
        all.getChildren().add(background);
        all.getChildren().add(fxmlLoader.load());


        Scene scene = new Scene(all,500,500);

        //Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MainMenu!");
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.setFullScreen(true);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            OnExitButtonClick(stage);
        });




    }

    public void OnExitButtonClick(Stage stage ) {

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("LOGOUT");
        a.setHeaderText("You re About to Logout");
        a.setContentText("do You Want to Save Before Exiting ");

        if(a.showAndWait().get()== ButtonType.OK) {
            //stage = (Stage) APane.getScene().getWindow();
            stage.close();
        }



    }

    public static void main(String[] args) {
        launch();
    }
}