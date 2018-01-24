package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class PopupWindow implements Initializable{

    public PopupWindow(){}
    @FXML
    private Button closeButton = new Button();

    @FXML
    private TextField encryptedOutputBox = new TextField();

    @FXML
    private TextField decryptedOutputBox = new TextField();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setEncryptionOutputBox();
        setDecryptionOutputBox();
    }

    //public PopupWindow(){}

    void displayPopup() {
        Stage secondaryStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FMXL/PopupWindow.fxml"));
            VBox vBox = loader.load();
            Scene scene = new Scene(vBox);
            //secondaryStage.initModality(Modality.APPLICATION_MODAL);

            secondaryStage.setScene(scene);

            secondaryStage.getIcons().add(new Image("GUI/Icons/Logo.png"));
            secondaryStage.setTitle("Output");
            //decryptedOutputBox.setText("DECRYPTION");

            secondaryStage.show();


        }catch (Exception e){
            System.out.println("ERROR: The popup window failed to draw.");
            System.out.println("The error returned is: " + e);

        }


    }


    public void setEncryptionOutputBox(){
        String encryptedText ="";
        encryptedText = MainWindowController.guiBackend.getEncryptedText();
        //System.out.println(encryptedText);
        encryptedOutputBox.setText("Testing ");
        if(encryptedText != null){
            encryptedOutputBox.clear();

            encryptedOutputBox.setText(encryptedText);
        }
        else {
            encryptedOutputBox.clear();
            System.out.println("ERROR: There is no encrypted text.");
            encryptedOutputBox.setText("Error: No encrypted text.");
        }

    }

    private void setDecryptionOutputBox(){
        String decryptedText = "";

        decryptedText= MainWindowController.guiBackend.getDecryptedText();

        if(decryptedText!=null) {
            decryptedOutputBox.clear();
            decryptedOutputBox.setText(decryptedText);
        }
        else{
            decryptedOutputBox.clear();
            System.out.println("ERROR: There is no decrypted text.");
            decryptedOutputBox.setText("Error: No decrypted text.");
        }
    }

    //-----------------------------------------
    //--------------FXML-FUNCTIONS-------------
    //-----------------------------------------

    @FXML
    private void onCloseButtonClick(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

    }

}
