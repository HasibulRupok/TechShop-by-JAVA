package sample;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ChatController {

    @FXML
    private Button backBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button deleteChatBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField inputField;

    @FXML
    public TextArea showArea;

    @FXML
    private Button button;

    boolean isConnected = false;
    BufferedReader reader;
    BufferedWriter writer;


    public void exitPressed() {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }


    public void homePressed() {
        FXMLScene fxmlScene = FXMLScene.load("Home.fxml");
        Parent root = fxmlScene.root;
        HomeController controller = (HomeController) fxmlScene.controller;
        Scene HomeScene = new Scene(root, 700, 400);
        Main.mainStage.setScene(HomeScene);

    }

    public void deleteChatPressed() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("src/Files/message.txt");
            BufferedWriter writer = new BufferedWriter(fw);

            writer.write("");
            writer.close();
            showArea.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readOldSms() {
        try {
            FileReader fr = new FileReader("src/Files/message.txt");
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

    public void sendPressed() {
        if (!isConnected) {
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

    public void oldChatPressed(){
        showArea.setText("");
        readOldSms();
    }

}
