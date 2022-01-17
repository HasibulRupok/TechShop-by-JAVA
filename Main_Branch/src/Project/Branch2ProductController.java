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

public class Branch2ProductController {

    @FXML
    private Button backbtn;

    @FXML
    private Button shistory;

    @FXML
    private Button pDetails;

    @FXML
    private Button mProduct;

    @FXML
    private Button chatBtn;  //changeScene5

    @FXML
    void backPressed2(ActionEvent event) throws IOException {
        Parent parent8 = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Scene scene8 = new Scene(parent8);

        Stage window6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        LoginFxml.mainStage.setScene(scene8);

    }

    @FXML
    void changeScene5(ActionEvent event) throws IOException {
        Parent parent5 = FXMLLoader.load(getClass().getResource("chat.fxml"));
        Scene scene5 = new Scene(parent5);

        Stage window3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        LoginFxml.mainStage.setScene(scene5);

    }


    @FXML
    void mProduct(ActionEvent event)throws IOException {
        Parent parent6 = FXMLLoader.load(getClass().getResource("MORE PRODUCT.fxml"));
        Scene scene6 = new Scene(parent6);

        Stage window4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        LoginFxml.mainStage.setScene(scene6);

    }

    @FXML
    void pDetails(ActionEvent event) throws IOException {
        Parent parent7 = FXMLLoader.load(getClass().getResource("PRODUCT DETAILS.fxml"));
        Scene scene7 = new Scene(parent7);

        Stage window5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        LoginFxml.mainStage.setScene(scene7);

    }

    @FXML
    void saleHistory(ActionEvent event) throws IOException {
        Parent parent8 = FXMLLoader.load(getClass().getResource("SaleHistory.fxml"));
        Scene scene8 = new Scene(parent8);

        Stage window6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        LoginFxml.mainStage.setScene(scene8);

    }

}




