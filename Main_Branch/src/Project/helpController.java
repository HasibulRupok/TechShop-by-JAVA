package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class helpController {

    @FXML
    private Button backBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button chatBtn;

    @FXML
    private Button exitBtn;

    @FXML
    void backPressed2(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Dashboard.fxml");
        Parent root = fxmlScene.root;
        DashboardController controller = (DashboardController) fxmlScene.controller;
        Scene loginScene = new Scene(root, 700, 400);
        LoginFxml.mainStage.setScene(loginScene);

    }

    @FXML
    void chatPressed3(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Chat.fxml");
        Parent root = fxmlScene.root;
        ChatController controller = (ChatController) fxmlScene.controller;
        Scene ChatScene = new Scene(root, 700, 400);
        LoginFxml.mainStage.setScene(ChatScene);

    }

    @FXML
    void existPressed3(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void homePressed3(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Home.fxml");
        Parent root = fxmlScene.root;
        HomeController controller = (HomeController) fxmlScene.controller;
        Scene HomeScene = new Scene(root, 700, 400);
        LoginFxml.mainStage.setScene(HomeScene);

    }

}
