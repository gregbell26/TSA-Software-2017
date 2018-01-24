package GUI;
/**
 *
 *
 *
 * @music My Chemical Romance
 * @author Gregory Bell
 * @company TriHard Studios
 * @version  1.0.0
 */

import Backend.GUIBackend;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController extends MainWindow{

    //----------------------BACKEND----------------------
    static GUIBackend guiBackend = new GUIBackend();
    PopupWindow popupWindow = new PopupWindow();
    //---------------------------------------------------

    //-------------------FXML-VARIABLES------------------
    @FXML
    private TextField TextInputFeild;
    @FXML
    private TextField PasswordInputFeild;
    @FXML
    private TextField StatusBox;
    //-----------------FXML-VARIABLES--------------------


    //-------------------------------------------------
    //---------------FXML-FUNCTIONS--------------------
    //-------------------------------------------------
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
        System.out.println("INFORMATION: 3DES Selected");
    }

    @FXML
    private void HandleB64Selection(ActionEvent event){
        StatusBox.clear();
        StatusBox.setText("Base64");
        System.out.println("INFORMATION: Base64 Selected");
    }

    @FXML
    private void HandleAES256Selection(ActionEvent event){
        StatusBox.clear();
        StatusBox.setText("AES 256");
        System.out.println("INFORMATION: AES 256 Selected");
    }

    @FXML
    private void HandleBlowFishSelection(ActionEvent event){
        StatusBox.clear();
        StatusBox.setText("Blow Fish");
        System.out.println("INFORMATION: Blow Fish Selected");
    }

    @FXML
    public void encrypt(ActionEvent event)throws Exception{
        guiBackend.clearAll();
        String getText = TextInputFeild.getText();
        String getPassword=PasswordInputFeild.getText();
        String getMethod = StatusBox.getText();
        System.out.println("INFORMATION: User input: " + getText);
        System.out.println("INFORMATION: Password: " + getPassword);

        guiBackend.setAll(getText, getPassword, getMethod);
        if(guiBackend.encrypt()){
            System.out.println("INFORMATION: Encryption was successful ");
            System.out.println("INFORMATION: The encrypted text is " + guiBackend.getEncryptedText());
            popupWindow.displayPopup();
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
            popupWindow.displayPopup();
        }
        else {
            System.out.println("ERROR: Decryption Failed");
        }
    }



    //-------------------------------------------------------------
    //---------------EOF-FXML-FUNCTIONS----------------------------
    //-------------------------------------------------------------



}
