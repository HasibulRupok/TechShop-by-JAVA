package sample;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HomeController {

    @FXML
    private Rectangle saleProduct;

    @FXML
    private Rectangle contractHead;

    @FXML
    private Rectangle message;

    @FXML
    private Button backBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button chatBtn;

    @FXML
    private Button exitBtn;

    public void exitPressed(){
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    public void chatPressed(){
        FXMLScene fxmlScene = FXMLScene.load("Chat.fxml");
        Parent root = fxmlScene.root;
        ChatController controller = (ChatController) fxmlScene.controller;
        Scene ChatScene = new Scene(root, 700, 400);
        Main.mainStage.setScene(ChatScene);

    }
    public void saleProductsPressed(){
        FXMLScene fxmlScene = FXMLScene.load("saleProducts.fxml");
        Parent root = fxmlScene.root;
        SaleProductsController controller = (SaleProductsController) fxmlScene.controller;
        Scene saleProductsScene = new Scene(root, 700, 400);
        Main.mainStage.setScene(saleProductsScene);
    }
    public void backPressed(){
        FXMLScene fxmlScene = FXMLScene.load("BranchOneLogin.fxml");
        Parent root = fxmlScene.root;
        BranchOneLoginController controller = (BranchOneLoginController) fxmlScene.controller;
        Scene loginScene = new Scene(root, 700, 400);
        Main.mainStage.setScene(loginScene);
    }
    public void helpPressed(){
        FXMLScene fxmlScene = FXMLScene.load("Help.fxml");
        Parent root = fxmlScene.root;
        helpController controller = (helpController) fxmlScene.controller;
        Scene helpScene = new Scene(root, 700, 400);
        Main.mainStage.setScene(helpScene);
    }

}
