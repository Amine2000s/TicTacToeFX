package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController {

    @FXML
    Button ExitButton ;
    @FXML
    AnchorPane APane;


     private Stage stage;
     private Scene scene ;
     private Parent root ;

    //Stage stage;
    public void OnExitButtonClick(ActionEvent e ) {

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("LOGOUT");
        a.setHeaderText("You re About to Logout");
        a.setContentText("do You Want to Save Before Exiting ");

        if(a.showAndWait().get()== ButtonType.OK) {
            stage = (Stage) APane.getScene().getWindow();
            stage.close();
        }



    }

    public void SwitchToPlayMenu(ActionEvent event) throws Exception {

        ImageView background = new ImageView();


        root =  FXMLLoader.load((Objects.requireNonNull(getClass().getResource("PlayMenu.fxml"))));
        //FXMLLoader fxmlLoader = new FXMLLoader(PlayMenuController.class.getResource("MainMenu.fxml"));
        // = new FXMLLoader(PlayMenuController.class.getResource("MainMenu.fxml"));
        ////////////background ////////////////////////////////////////////
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("PlayMenu");
        background.setImage(new Image("C:\\Users\\amin\\IdeaProjects\\demo\\src\\MediaResources\\Wallpaper.jpg"));
        background.setFitHeight(500);
        background.setFitWidth(500);
        /////////////////////////////////////////////////////////////////////////////////
        StackPane Lpane = new StackPane();
        Lpane.getChildren().add(background);
        Lpane.getChildren().add(root);
        scene = new Scene(Lpane,500,500);
        stage.setScene(scene);

        stage.show();

    }

    public void SwitchToOptionMenu(ActionEvent event) throws Exception {
         ImageView background = new ImageView();

        root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("OptionsMenu.fxml")));
        //FXMLLoader fxmlLoader = new FXMLLoader(OptionsMenuController.class.getResource("OptionMenu.fxml"));
        //StackPane p = new StackPane();
      //  p.getChildren().add(fxmlLoader.load());

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("OptionsMenu");
        ////////////background ////////////////////////////////////////////
        background.setImage(new Image("C:\\Users\\amin\\IdeaProjects\\demo\\src\\MediaResources\\Wallpaper.jpg"));
        background.setFitHeight(500);
        background.setFitWidth(500);
        /////////////////////////////////////////////////////////////////////////////////
        StackPane Lpane = new StackPane();
        Lpane.getChildren().add(background);
        Lpane.getChildren().add(root);
        scene = new Scene(Lpane,500,500);

        stage.setScene(scene);

        stage.show();

    }

}
