package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class OptionsMenuController {

    private Stage stage;
    private Scene scene ;
    private Parent root ;
    public void OnReturnButton(ActionEvent event) throws IOException {

        ImageView Background = new ImageView();

        Background.setImage(new Image("C:\\Users\\amin\\IdeaProjects\\demo\\src\\MediaResources\\Wallpaper.jpg"));
        Background.setFitWidth(500); Background.setFitHeight(500);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainMenu.fxml")));


        StackPane PLPane = new StackPane();

        PLPane.getChildren().add(Background);
        PLPane.getChildren().add(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu ");

        scene = new Scene(PLPane,500,500);

        stage.setScene(scene);

        stage.show();





    };
}
