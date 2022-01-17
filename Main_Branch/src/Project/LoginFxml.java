package Project;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginFxml extends Application{
    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));
        primaryStage.setScene(new Scene(root,700,400));
        primaryStage.setTitle("JavaFX App");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("Project/images/logo2.PNG"));

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

