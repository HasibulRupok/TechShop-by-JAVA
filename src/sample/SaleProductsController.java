package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;

public class SaleProductsController {


    @FXML
    private Label phnTitle;

    @FXML
    private Label phnPrice;

    @FXML
    private Text phnDiscription;

    @FXML
    private Button phnSale;

    @FXML
    private Button phnUpdated;

    @FXML
    private Button phnAdd;

    @FXML
    private TextField phnAddQuantity;

    @FXML
    private TextField phnSaleQuantity;

    @FXML
    private Button backBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button chatBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Label labTitle;

    @FXML
    private Label labPrice;

    @FXML
    private Text lapDiscription;

    @FXML
    private Button lapSale;

    @FXML
    private Button labUpdated;

    @FXML
    private Button lapAdd;

    @FXML
    private TextField lapAddQuantity;

    @FXML
    private TextField lapSaleQuantity;

    @FXML
    private TextField phnQuantity;

    @FXML
    private TextField lapQuantity;

    @FXML
    private Button phnQSee;

    @FXML
    private Button lapQSee;


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
    void phnAddPressed(ActionEvent event) {
        if (phnAddQuantity.getText().equals("")){
            return;
        }
        int q = 0;
        int OldQ;
        try {
            FileReader fr = new FileReader("src/Files/PhoneQuantity");
            BufferedReader reader = new BufferedReader(fr);
            OldQ = Integer.parseInt(reader.readLine());
            reader.close();

            try {
                q = Integer.parseInt(phnAddQuantity.getText());
            }
            catch (NumberFormatException e){
                return;
            }
            phnAddQuantity.setText("");
            int total = OldQ + q;

            FileWriter fw = new FileWriter("src/Files/PhoneQuantity");
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(total + "");
            writer.close();

            phnQSee.setText(total + "");
        }
        catch (IOException e){
           e.printStackTrace();
        }
//        phnQuantity.setText( OldQ + q + "");
    }

    @FXML
    void lapAddPressed(ActionEvent event) {
        if (lapAddQuantity.getText().equals("")){
            return;
        }
        int q = 0;
        int OldQ;
        try {
            FileReader fr = new FileReader("src/Files/LaptopQuantity");
            BufferedReader reader = new BufferedReader(fr);
            OldQ = Integer.parseInt(reader.readLine());
            reader.close();

            try {
                q = Integer.parseInt(lapAddQuantity.getText());
            }
            catch (NumberFormatException e){
                return;
            }
            lapAddQuantity.setText("");
            int total = OldQ + q;

            FileWriter fw = new FileWriter("src/Files/LaptopQuantity");
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(total + "");
            writer.close();

            lapQSee.setText(total + "");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void phnSalePressed(ActionEvent event) {
        if (phnSaleQuantity.getText().equals("")){
            return;
        }
        int q = 0;
        int OldQ = 0;
        try{
            FileReader fr = new FileReader("src/Files/PhoneQuantity");
            BufferedReader reader = new BufferedReader(fr);
            OldQ = Integer.parseInt(reader.readLine());
            reader.close();

            try {
                q = Integer.parseInt(phnSaleQuantity.getText());
                phnSaleQuantity.setText("");
            }
            catch (NumberFormatException e){
                return;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if (q <= OldQ){
            OldQ = OldQ - q;

            try{
                FileWriter fw = new FileWriter("src/Files/PhoneQuantity");
                BufferedWriter writer = new BufferedWriter(fw);
                writer.write(OldQ + "");
                writer.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }

            phnQSee.setText(OldQ + "");
            {
                FXMLScene fxmlScene = FXMLScene.load("SaleDetails.fxml");
                Parent root = fxmlScene.root;
                SaleDetailsController controller = (SaleDetailsController) fxmlScene.controller;
                Scene HomeScene = new Scene(root, 700, 400);
                Main.mainStage.setScene(HomeScene);
            }
        }
    }
    @FXML
    void lapSalePressed(ActionEvent event) {
        if (lapSaleQuantity.getText().equals("")){
            return;
        }
        int q = 0;
        int OldQ = 0;
        try{
            FileReader fr = new FileReader("src/Files/LaptopQuantity");
            BufferedReader reader = new BufferedReader(fr);
            OldQ = Integer.parseInt(reader.readLine());
            reader.close();

            try {
                q = Integer.parseInt(lapSaleQuantity.getText());
                lapSaleQuantity.setText("");
            }
            catch (NumberFormatException e){
                return;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if (q <= OldQ){
            OldQ = OldQ - q;

            try{
                FileWriter fw = new FileWriter("src/Files/LaptopQuantity");
                BufferedWriter writer = new BufferedWriter(fw);
                writer.write(OldQ + "");
                writer.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }

            lapQSee.setText(OldQ + "");
            {
                FXMLScene fxmlScene = FXMLScene.load("SaleDetails.fxml");
                Parent root = fxmlScene.root;
                SaleDetailsController controller = (SaleDetailsController) fxmlScene.controller;
                Scene HomeScene = new Scene(root, 700, 400);
                Main.mainStage.setScene(HomeScene);
            }
        }

    }

    @FXML
    void phnQSeePressed(ActionEvent event) {
        try {
            FileReader fr = new FileReader("src/Files/PhoneQuantity");
            BufferedReader reader = new BufferedReader(fr);
            int Quantity = Integer.parseInt(reader.readLine());
            phnQSee.setText(Quantity + "");

        }
        catch (IOException e) {
            e.printStackTrace();
            phnQSee.setText("See");
        }
    }


    @FXML
    void lapQSeePressed(ActionEvent event) {
        try {
            FileReader fr = new FileReader("src/Files/LaptopQuantity");
            BufferedReader reader = new BufferedReader(fr);
            int Quantity = Integer.parseInt(reader.readLine());
            lapQSee.setText(Quantity + "");

        }
        catch (IOException e) {
            e.printStackTrace();
            lapQSee.setText("See");
        }
    }



}
