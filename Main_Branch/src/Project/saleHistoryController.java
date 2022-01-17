package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class saleHistoryController {


    @FXML
    private TextArea showArea;

    @FXML
    private Button button;

    @FXML
    private Button backBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button deleteChatBtn;

    @FXML
    private Button exitBtn;

    @FXML
    void backPressed4(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Product(Branch-1).fxml");
        Parent root = fxmlScene.root;
        Branch2ProductController controller = (Branch2ProductController) fxmlScene.controller;
        Scene loginScene = new Scene(root);
        LoginFxml.mainStage.setScene(loginScene);

    }

    @FXML
    void homePressed4(ActionEvent event) {
        FXMLScene fxmlScene = FXMLScene.load("Home.fxml");
        Parent root = fxmlScene.root;
        HomeController controller = (HomeController) fxmlScene.controller;
        Scene HomeScene = new Scene(root);
        LoginFxml.mainStage.setScene(HomeScene);

    }
    public void exitPressed(ActionEvent event){
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
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
    void viewHistoryPressed(ActionEvent event) {
        try{
            FileReader fr = new FileReader("C:\\Users\\Rupok\\Desktop\\A_OOP\\TechShop\\src\\Files\\saleDetails");
            BufferedReader reader = new BufferedReader(fr);
            String line ;
            while ( (line = reader.readLine()) != null ){
                String parts[] = line.split("####");
                String product = parts[0];
                String customer = parts[1];
                String address = parts[2];
                String quantity = parts[3];
                String price = parts[4];
                String phone = parts[5];

                String data = "Product name: "+ product +", Quantity: "+ quantity+ ", Price: "+ price + ", Buyer's name: "+ customer+ ", Phone Number: "+ phone + ", Address: "+ address + "\n";
                showArea.appendText(data);
            }

        }
        catch (IOException e){
            System.out.println("Exception from ViewHistoryPressed");
            e.printStackTrace();
        }
    }


}
