package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ChatController {

    @FXML
    private Button backBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private TextField inputField;

    @FXML
    private Button button;

    @FXML
    private TextArea showArea;

    boolean isConnected = false;
    BufferedReader reader;
    BufferedWriter writer;

    public void sendPressed() {
        if (!isConnected) {
            // Client is not connected with the server, lets connect with server
            String inputName = inputField.getText();
            inputField.clear();

            if (inputName == null || inputName.length() == 0) {
                showArea.appendText("Enter a valid name!\n");
                return;
            }
            try {
                Socket sc = new Socket("localhost", 6601);

                OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
                writer = new BufferedWriter(o);

                writer.write(inputName + "\n");
                writer.flush();

                InputStreamReader isr = new InputStreamReader(sc.getInputStream());
                reader = new BufferedReader(isr);

                //Anonymous inner class
                Thread serverListener = new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                String data = reader.readLine() + "\n";
                                showArea.appendText(data);
                            } catch (SocketException e) {
                                showArea.appendText("Connection lost!\n");
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                serverListener.start();

                showArea.appendText("You can send your message now\n");
                button.setText("Send");
                inputField.setPromptText("Write your message.");
                isConnected = true;

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String msg = inputField.getText();
                inputField.clear();

                if (msg == null || msg.length() == 0) {
                    return;
                }

                writer.write(msg + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @FXML
    void backPressed3(ActionEvent event) throws IOException {
        Parent parent8 = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Scene scene8 = new Scene(parent8);

        Stage window6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        LoginFxml.mainStage.setScene(scene8);

    }

    public void exitPressed(ActionEvent event){
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }


    public void homePressed(ActionEvent event){
        FXMLScene fxmlScene = FXMLScene.load("Home.fxml");
        Parent root = fxmlScene.root;
        HomeController controller = (HomeController) fxmlScene.controller;
        Scene HomeScene = new Scene(root);
        LoginFxml.mainStage.setScene(HomeScene);

    }

    @FXML
    void deleteChatPressed(ActionEvent event) {
        try{
            FileWriter fw = new FileWriter("C:\\Users\\Rupok\\Desktop\\A_OOP\\TechShop\\src\\Files\\message.txt");
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("");
            showArea.setText("");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    @FXML
    void oldChatPressed(ActionEvent event) {
        try {
            FileReader fr = new FileReader("C:\\Users\\Rupok\\Desktop\\A_OOP\\TechShop\\src\\Files\\message.txt");
            BufferedReader reader = new BufferedReader(fr);

            String sms;
            showArea.setText("");
            while ((sms = reader.readLine()) != null) {
                showArea.appendText(sms + "\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
