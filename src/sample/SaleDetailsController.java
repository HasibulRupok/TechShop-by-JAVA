package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaleDetailsController {
    @FXML
    private Button backBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button chatBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField quantity;

    @FXML
    private TextField price;

    @FXML
    private TextField phone;

    @FXML
    private Button confirm;

    @FXML
    private TextField product;

    @FXML
    private Label warning;

    @FXML
    void chatPressed(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Chat.fxml");
        Parent root = fxmlScene.root;
        ChatController controller = (ChatController) fxmlScene.controller;
        Scene ChatScene = new Scene(root, 700, 400);
        Main.mainStage.setScene(ChatScene);
    }

    @FXML
    void exitPressed(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void homePressed(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Home.fxml");
        Parent root = fxmlScene.root;
        HomeController controller = (HomeController) fxmlScene.controller;
        Scene HomeScene = new Scene(root, 700, 400);
        Main.mainStage.setScene(HomeScene);
    }

    @FXML
    void confirmPressed(ActionEvent event) {
        try {
            FileWriter fw = new FileWriter("src/Files/saleDetails", true);
            BufferedWriter writer = new BufferedWriter(fw);
            if (name.getText() != "" && address.getText()!= "" && quantity.getText() != "" && price.getText() != "" && phone.getText() != "" && product.getText() != ""){
                String data = product.getText() + "####"+ name.getText() + "####"+ address.getText() + "####" + quantity.getText() + "####" + price.getText() +"####" +phone.getText() + "\n";
                writer.write(data);
                writer.flush();

                product.setText(""); name.setText("");address.setText(""); quantity.setText(""); price.setText(""); phone.setText("");

                FXMLScene fxmlScene = FXMLScene.load("Home.fxml");
                Parent root = fxmlScene.root;
                HomeController controller = (HomeController) fxmlScene.controller;
                Scene HomeScene = new Scene(root, 700, 400);
                Main.mainStage.setScene(HomeScene);
            }
            else{
                warning.setVisible(true);
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


}
