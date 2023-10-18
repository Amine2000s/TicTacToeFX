package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResultPaneController {

    @FXML
    Pane ResultPane;
    @FXML
    Label WinnerLabel ;
    @FXML
    Button PlayAgainButton ;
    @FXML
    Button CancelButton  ;

    //Parent root ;

    //Scene scene ;

    Stage stage ;

    private boolean playAgainClicked = false;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isPlayAgainClicked() {
        return playAgainClicked;
    }

    @FXML
    private void playAgainAction() {
        playAgainClicked = true;
        stage.close();
    }
    @FXML
    private void cancelAction() {
        stage.close();
    }

   /* public  ResultPane() throws IOException {

        root = FXMLLoader.load(getClass().getResource("LocalGameMenu.fxml"));

    };
*/
    public void setWinnerLabel(String newExpression){
            WinnerLabel.setText(newExpression);
    }
/*
    public void showpane(){

        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
    */

    /*public void OnPLayAgainButton(ActionEvent event ){

        OnevOneController one = new OnevOneController();

        one.resetpane();

        stage.close();

    }
*/
/*
    public void OnCancelButoon(ActionEvent event) throws IOException{

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

*/
}
