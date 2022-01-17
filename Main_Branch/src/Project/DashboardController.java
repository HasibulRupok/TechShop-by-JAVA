package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class DashboardController {

    @FXML
    private Button logInB1;

    @FXML
    private Button backBtn1;

    @FXML
    private Button helpBtn;

    @FXML
    private Button homeBtn1;

    @FXML
    private Button about_us;

    @FXML
    void aboutUsClick(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("About Us.fxml");
        Parent parent = fxmlScene.root;
        AboutUsController controller = (AboutUsController) fxmlScene.controller;
        Scene scene = new Scene(parent);
        LoginFxml.mainStage.setScene(scene);

    }

    @FXML
    void backPress1() {
        FXMLScene fxmlScene = FXMLScene.load("Login.fxml");
        Parent parent = fxmlScene.root;
       LoginController controller = (LoginController) fxmlScene.controller;
        Scene scene = new Scene(parent);
        LoginFxml.mainStage.setScene(scene);

    }

    @FXML
    void changeScene2() {
        FXMLScene fxmlScene = FXMLScene.load("B2Login.fxml");
        Parent parent = fxmlScene.root;
        B2LoginController controller = (B2LoginController) fxmlScene.controller;
        Scene scene = new Scene(parent);
        LoginFxml.mainStage.setScene(scene);

    }

    @FXML
    void helpClick() {
        FXMLScene fxmlScene = FXMLScene.load("Help.fxml");
        Parent parent = fxmlScene.root;
       helpController controller = (helpController) fxmlScene.controller;
        Scene scene = new Scene(parent);
        LoginFxml.mainStage.setScene(scene);

    }

    @FXML
    void homePress1(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Home.fxml");
        Parent root = fxmlScene.root;
        HomeController controller = (HomeController) fxmlScene.controller;
        Scene HomeScene = new Scene(root);
        LoginFxml.mainStage.setScene(HomeScene);


    }

}





