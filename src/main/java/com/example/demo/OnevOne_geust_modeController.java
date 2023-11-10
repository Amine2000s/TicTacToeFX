package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class OnevOne_geust_modeController {

    //Game Logic
    //we need a variable that determine the player role
    /*
    * action event for button -> if that button is empty then refill ->check wining condition or tie condition if met
    * if not switch turn
    * keeep going
    * needed variable :player Variable x or o and set settings with it
    * needed functions : function for  switching player ,  for marking on the Lablel , win detect , tie detect
    * pane for wining ,tie : contains if we should repeat or exit
    * add a button for return
    *
    *
    *
    * */
            @FXML
            Button One;
            @FXML
            Button Two;
            @FXML
            Button Three;
            @FXML
            Button four;
            @FXML
            Button five;
            @FXML
            Button six;
            @FXML
            Button seven;
            @FXML
            Button eight;
            @FXML
            Button nine;

            //@FXML
            @FXML
            public Pane MainPane ;
    char PlayerMark = 'X';

    Scene reusltscene ;
    Stage reusltstage ;
    Parent reusltroot ;


    public OnevOne_geust_modeController(){};
    public void OnClickedButton(ActionEvent event) throws IOException {

        System.out.println("you clicked ");
        //((Node)event.getSource()).getScene().getStylesheets().add("/OnevOne.CSS");
        Button temp = (Button) event.getSource();


        if(temp.getText().equals(" ")){

            MarkPlayer(temp,PlayerMark);

            if(CheckWin()){

                System.out.println("here is a WIn");

                if(PlayerMark=='X'){
                    ShowResultScreen("Player 1 Won ");
                    System.out.println("Player 1 Won");
                    /*
                    * create a pop win panel
                    * */
                }else{
                    ShowResultScreen("Player 2 Won ");

                    System.out.println("Player 2 Won");

                }

            }else if(checktie()){
                ShowResultScreen("Tie");

                System.out.println("tiiiie a wedi");
            }else {
                PlayerMark = switchtrun(PlayerMark);
            }

        }

            /*
        * if empty fill it
        * then check for wininig codnitions
        * tie conditions
        * if both of them did not happen
        * switch the turn ou khlas og3od ostna the Other yl3b
        *
        * */


    }
    //marking the player
    public void MarkPlayer(Button btn, char mark ){

        if(btn.getText().equals(" ")){

            btn.setText(String.valueOf(mark));

        }

    }

    public boolean CheckWin(){


        if(checkVerticalWin()) return true ;
        if(checkHorizontalWin()) return true ;
        if(checkDiagonalWin()) return true ;

        return  false ;




    }

    public boolean checkVerticalWin(){

        if(!One.getText().equals(" ")) {if(One.getText().equals(Two.getText()) && Two.getText().equals(Three.getText()))return true;}
        if(!four.getText().equals(" ")){if(four.getText().equals(five.getText()) && five.getText().equals(six.getText()))return true;}
        if(!seven.getText().equals(" ")){if(seven.getText().equals(eight.getText()) && eight.getText().equals(nine.getText()))return true;}

        return false;



    }
    public boolean checkHorizontalWin(){

        if(!One.getText().equals(" ")) {if(One.getText().equals(four.getText()) && four.getText().equals(seven.getText()))return true;}
        if(!Two.getText().equals(" ")) {if(Two.getText().equals(five.getText()) && five.getText().equals(eight.getText()))return true;}
        if(!Three.getText().equals(" ")) {if(Three.getText().equals(six.getText()) && six.getText().equals(nine.getText()))return true;}

        return false;



    }public boolean checkDiagonalWin(){

        if(!One.getText().equals(" ")) {if(One.getText().equals(five.getText()) && five.getText().equals(nine.getText()))return true;}
        if(!Three.getText().equals(" ")) {if(Three.getText().equals(five.getText()) && five.getText().equals(seven.getText()))return true;}

        return false;



    }

    public boolean checktie(){

        boolean full = true ;

        ArrayList<Button> list = new ArrayList<>();
        list.add(One);
        list.add(Two);
        list.add(Three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(nine);
        for(Button l : list){
            if(l.getText().equals(" ")) full=false ;
        }

        return full ;
    }

    public  char  switchtrun( char mark ) {

        char c;
        if ( mark =='X') {


            c = 'O';
        } else {

            c = 'X';

        }
        return c ;
    }

    public  void resetpane(){
        One.setText(" ");
        Two.setText(" ");
        Three.setText(" ");
        four.setText(" ");
        five.setText(" ");
        six.setText(" ");
        seven.setText(" ");
        eight.setText(" ");
        nine.setText(" ");

    }


    public void ShowResultScreen(String result) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultPane.fxml"));

        AnchorPane p1  = loader.load();
        StackPane mainpane = new StackPane();
        mainpane.getChildren().add(new ImageView("C:\\Users\\amin\\IdeaProjects\\demo\\src\\MediaResources\\Wallpaper.jpg"));

        mainpane.getChildren().add(p1);
        Scene scene = new Scene(mainpane,500,300);

        Stage stage = new Stage() ;

        stage.setScene(scene);

        ResultPaneController controller =  loader.getController();

        controller.setStage(stage);

        controller.setWinnerLabel(result);

        stage.initModality(Modality.APPLICATION_MODAL);

        //stage.initOwner(stage);
        stage.setResizable(false );
        stage.showAndWait();

        /*if(controller.isPlayAgainClicked())
            resetpane();
        else

            stage.close();
*/
        if ((controller.isPlayAgainClicked())) {
            resetpane();
        } else {
            stage.close();
        }


    }
}
