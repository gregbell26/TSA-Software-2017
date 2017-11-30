package GUI;

import Backend.GUIBackend;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.event.ActionEvent;


public class MainWindow extends Application {
//Starting the backend
    static GUIBackend guiBackend = new GUIBackend();
//DONE
    @FXML
    private TextField TextInputFeild;
    @FXML
    private TextField PasswordInputFeild;
    @FXML
    private TextField StatusBox;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){//this creates everything!! Special thanks to google!
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
            AnchorPane root = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            primaryStage.getIcons().add(new Image("GUI/Logo.png"));
            primaryStage.setTitle("Encryption");
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();

        }

    }

    @FXML
    private void HandleCaesarSelection(ActionEvent event) {
        StatusBox.clear();
        StatusBox.setText("Caesar");
        System.out.println("Caesar Cypher Selected");
    }

    @FXML
    private void Handle3DESSelection(ActionEvent event){
        StatusBox.clear();
        StatusBox.setText("3DES");
        System.out.println("3DES Selected");
    }

    @FXML
    private void encrypt(ActionEvent event)throws Exception{
        guiBackend.clearAll();
        String getText = TextInputFeild.getText();
        String getPassword=PasswordInputFeild.getText();
        String getMethod = StatusBox.getText();
        System.out.println("The user entered " + getText + " as their encrypt text and " + getPassword + " as their password.");

        guiBackend.setAll(getText, getPassword, getMethod);
        if(guiBackend.encrypt()){
            System.out.println("INFORMATION: Encryption was successful ");
            System.out.println("INFORMATION: The encrypted text is " + guiBackend.getEncryptedText());
            //PopUp.launch();
        }
        else {
            System.out.println("ERROR: Encryption Failed");
        }


    }

    @FXML
    private void decrypt(ActionEvent event) throws Exception{
        if(guiBackend.decrypt()){
            System.out.println("INFORMATION: Decryption was successful ");
            System.out.println("INFORMATION: The Decrypted text is " + guiBackend.getDecryptedText());
            //PopUp.launch();
        }
        else {
            System.out.println("ERROR: Decryption Failed");
        }
    }








}
