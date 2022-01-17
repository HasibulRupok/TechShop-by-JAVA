package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    String userName = "Bipul";
    String pass = "1234";

    @FXML
    private TextField tf_userName;

    @FXML
    private PasswordField tf_passWord;

    @FXML
    private Button btn_logIn;

    @FXML
    private Label invalidSMS;


    @FXML
    void changeScene(ActionEvent event) throws IOException {

        if (tf_passWord.getText().equals(pass) && tf_userName.getText().equals(userName)) {

        Parent parent = FXMLLoader.load(getClass().getResource("Home.fxml"));

        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
        }
        else{
            invalidSMS.setVisible(true);
        }

    }
}














//
//        Parent parent = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
//        Scene scene2 = new Scene(parent);
//
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(scene2);
//        window.show();
//
//        if(tf_passWord.getText().equals(pass) && tf_userName.getText().equals(userName)){
//            Scene HomeScene = new Scene(parent, 700, 400);
//            LoginFxml.mainStage.setScene(HomeScene);
//        }






   //
//
//
//        if(tf_passWord.getText().equals(pass) && tf_userName.getText().equals(userName)){
//            Parent parent = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
////        Scene scene2 = new Scene(parent);
////
////        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//            LoginFxml.mainStage.setScene(scene2);


