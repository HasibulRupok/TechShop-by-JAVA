package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class BranchOneLoginController {
    String userName = "Rupok";
    String pass = "123";

    @FXML
    private PasswordField password_input;

    @FXML
    private Button login_btn;

    @FXML
    private TextField username_input;

    @FXML
    private Label invalidSMS;

    FXMLScene fxmlScene = FXMLScene.load("Home.fxml");
    Parent root = fxmlScene.root;
    HomeController controller = (HomeController) fxmlScene.controller;

    public void loginPreassed(){
        if(password_input.getText().equals(pass) && username_input.getText().equals(userName)){
            Scene HomeScene = new Scene(root, 700, 400);
            Main.mainStage.setScene(HomeScene);
        }
        else{
            invalidSMS.setVisible(true);
        }
    }

}
