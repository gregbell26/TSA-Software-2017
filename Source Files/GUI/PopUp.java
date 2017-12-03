package GUI;

import Backend.GUIBackend;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.*;
public class PopUp extends Application {

      @FXML
      private TextArea encryptedTextArea;

      @FXML
      private TextArea decryptedTextArea;
    public static void main(String args[]){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        try{
            Popup popup = new Popup();
            AnchorPane controller = new AnchorPane();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/popUp.fxml"));
            loader.setController(controller);
            popup.getContent().add(loader.load());
            primaryStage.getIcons().add(new Image("/GUI/Logo.png"));
            primaryStage.setTitle("Output");
        try {
            encryptedTextArea.setText(MainWindow.guiBackend.getEncryptedText());
            decryptedTextArea.setText(MainWindow.guiBackend.getDecryptedText());
        }catch (Exception NullPointerException){
            encryptedTextArea.setText("No Encrypted Text");
            decryptedTextArea.setText("No Decrypted Text");
        }
        primaryStage.show();

    }catch (Exception e){
        e.printStackTrace();

    }
    }


}
