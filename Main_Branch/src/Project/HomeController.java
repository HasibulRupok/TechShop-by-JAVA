package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button helpBtn;

    @FXML
    private Button chatBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button backBtn1;

    @FXML
    private Rectangle saleProduct;

    @FXML
    private Rectangle contractHead;

    @FXML
    private Rectangle message;

    @FXML
    void backPressed(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Dashboard.fxml");
        Parent root = fxmlScene.root;
        DashboardController controller = (DashboardController) fxmlScene.controller;
        Scene loginScene = new Scene(root);
        LoginFxml.mainStage.setScene(loginScene);

    }

    @FXML
    void chatPressed(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Chat.fxml");
        Parent root = fxmlScene.root;
        ChatController controller = (ChatController) fxmlScene.controller;
        Scene ChatScene = new Scene(root);
        LoginFxml.mainStage.setScene(ChatScene);

    }

    @FXML
    void exitPressed(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();


    }

    @FXML
    void helpPressed(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Help.fxml");
        Parent root = fxmlScene.root;
        helpController controller = (helpController) fxmlScene.controller;
        Scene helpScene = new Scene(root);
        LoginFxml.mainStage.setScene(helpScene);

    }

    @FXML
    void saleHistoryPressed(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("SaleHistory.fxml");
        Parent root = fxmlScene.root;
        saleHistoryController controller = (saleHistoryController) fxmlScene.controller;
        Scene SaleHistoryScene = new Scene(root);
        LoginFxml.mainStage.setScene(SaleHistoryScene);
    }

}
//
//    public void exitPressed(ActionEvent event){
//        Stage stage = (Stage) exitBtn.getScene().getWindow();
//        stage.close();
//    }
//
//    public void chatPressed(ActionEvent event){
//        FXMLScene fxmlScene = FXMLScene.load("Chat.fxml");
//        Parent root = fxmlScene.root;
//        ChatController controller = (ChatController) fxmlScene.controller;
//        Scene ChatScene = new Scene(root, 700, 400);
//        LoginFxml.mainStage.setScene(ChatScene);
//
//    }
//
//
//    public void backPressed(ActionEvent event){
//        FXMLScene fxmlScene = FXMLScene.load("Dashboard.fxml");
//        Parent root = fxmlScene.root;
//        DashboardController controller = (DashboardController) fxmlScene.controller;
//        Scene loginScene = new Scene(root, 700, 400);
//        LoginFxml.mainStage.setScene(loginScene);
//    }
//    public void helpPressed(ActionEvent event){
//        FXMLScene fxmlScene = FXMLScene.load("Help.fxml");
//        Parent root = fxmlScene.root;
//        helpController controller = (helpController) fxmlScene.controller;
//        Scene helpScene = new Scene(root, 700, 400);
//        LoginFxml.mainStage.setScene(helpScene);
//    }
//
//}
