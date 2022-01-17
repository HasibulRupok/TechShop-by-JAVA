package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
    public static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("BranchOneLogin.fxml"));
        primaryStage.setTitle("TechShop");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("img/logo2.PNG"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
