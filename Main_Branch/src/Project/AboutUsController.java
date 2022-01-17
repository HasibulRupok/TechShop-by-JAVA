package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutUsController {

    @FXML
    private Button backBtn;

    @FXML
    private Button homeBtn;

    @FXML
    void backPressed5(ActionEvent event) throws IOException {
        Parent parent8 = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Scene scene8 = new Scene(parent8);

        Stage window6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        LoginFxml.mainStage.setScene(scene8);

    }

    @FXML
    void homePressed5(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Home.fxml");
        Parent root = fxmlScene.root;
        HomeController controller = (HomeController) fxmlScene.controller;
        Scene HomeScene = new Scene(root);
        LoginFxml.mainStage.setScene(HomeScene);

    }

}
