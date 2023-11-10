package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class OnlineMenuController {


    Stage stage ;

    Scene scene;

    Parent root ;

    @FXML
    Button HostButton ;
    @FXML
    Button GeustButton ;

    ServerSocket serverSocket ;

    Socket socket ;
    DataInputStream in ;

    DataOutputStream out ;

    FXMLLoader waiting_loader;


    public void OnReturnButoon(ActionEvent event) throws IOException {

        ImageView Background = new ImageView();

        Background.setImage(new Image("C:\\Users\\amin\\IdeaProjects\\demo\\src\\MediaResources\\Wallpaper.jpg"));
        Background.setFitWidth(500); Background.setFitHeight(500);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayMenu.fxml")));


        StackPane PLPane = new StackPane();

        PLPane.getChildren().add(Background);
        PLPane.getChildren().add(root);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Play Menu ");

        scene = new Scene(PLPane,500,500);

        stage.setScene(scene);

        stage.show();

    }

    public void onHostButton() throws IOException {

        FXMLLoader waiting_loader = new FXMLLoader(getClass().getResource("waiting_for_geust_to_connect.fxml"));

        Parent parent = waiting_loader.load();

        Scene scene2 = new Scene(parent);

        Stage miniStage = new Stage();
        miniStage.setResizable(false);

        miniStage.setScene(scene2);

        miniStage.show();

        new Thread(()->{

            try {
                serverSocket = new ServerSocket(8000);
                socket =serverSocket.accept();
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());

                if(socket.isConnected()){
                    miniStage.close();

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        });

    }



}
