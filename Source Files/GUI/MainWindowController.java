package GUI;
/**
 * This is the controller for the MainWindow. It contains all the action events and FXML variables for the MainWindow.
 *
 *
 * @music My Chemical Romance
 * @author Gregory Bell
 * @company TriHard Studios
 * @version  1.3.1
 */

import Backend.GUIBackend;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class MainWindowController extends MainWindow{

    //----------------------BACKEND----------------------
    static GUIBackend guiBackend = new GUIBackend();//Links the backend. Not private becuase we need one instance for both the popup and the main window
    private PopupWindow popupWindow = new PopupWindow();//Links the popup windows.
    //---------------------------------------------------

    //-------------------FXML-VARIABLES------------------
    @FXML
    private TextField TextInputField;//Is the TextField in the Main Window
    @FXML
    private TextField PasswordInputField;//Is the PasswordField in the Main Window
    @FXML
    private TextField StatusBox;//Is the box with the Method that we are using
    //-----------------FXML-VARIABLES--------------------


    //-------------------------------------------------
    //---------------FXML-FUNCTIONS--------------------
    //-------------------------------------------------

    /**
     * All of the FXML HandleMethodSelection are the same,
     * They will be called when the user selects the encryption method
     * @param event the User selecting the it. Is printed in debug mode.
     */
    @FXML
    private void HandleCaesarSelection(ActionEvent event) {
        StatusBox.clear();
        StatusBox.setText("Caesar");
        System.out.println("INFORMATION: Caesar Cypher Selected");
        System.out.println("INFORMATION: ActionEvent " + event);
    }

    @FXML
    private void Handle3DESSelection(ActionEvent event){
        StatusBox.clear();
        StatusBox.setText("3DES");
        System.out.println("INFORMATION: 3DES Selected");
        System.out.println("INFORMATION: ActionEvent " + event);

    }

    @FXML
    private void HandleB64Selection(ActionEvent event){
        StatusBox.clear();
        StatusBox.setText("Base64");
        System.out.println("INFORMATION: Base64 Selected");
        System.out.println("INFORMATION: ActionEvent " + event);

    }

    @FXML
    private void HandleAES256Selection(ActionEvent event){
        StatusBox.clear();
        StatusBox.setText("AES 256");
        System.out.println("INFORMATION: AES 256 Selected");
        System.out.println("INFORMATION: ActionEvent " + event);

    }

    @FXML
    private void HandleBlowFishSelection(ActionEvent event){
        StatusBox.clear();
        StatusBox.setText("Blow Fish");
        System.out.println("INFORMATION: Blow Fish Selected");
        System.out.println("INFORMATION: ActionEvent " + event);

    }

    /**
     * Is called when the user selects 'encrypt' in the main window
     * It gets the data in all the boxes, then it calls set all in the backend. Then it encrypts
     * @param event is the user selecting the encrypt box
     * @throws Exception the backend encrypt throws exceptions sometimes.
     */

    @FXML
    public void encrypt(ActionEvent event)throws Exception{
        guiBackend.clearAll();//clears all data in the backend to avoid data conflicts
        String getText = TextInputField.getText();//Gets text from the Text field
        String getPassword= PasswordInputField.getText();//Gets text from the password field
        String getMethod = StatusBox.getText();//Gets the method that the user selected
        //Debug lines
        System.out.println("INFORMATION: User input: " + getText);
        System.out.println("INFORMATION: Password: " + getPassword);
        System.out.println("INFORMATION: ActionEvent " + event);


        //The backend setter
        guiBackend.setAll(getText, getPassword, getMethod);
        //Calls the encrypt in the form of an boolean. Prints error message if encryption failed
        if(guiBackend.encrypt()){
            //Debug messages
            System.out.println("INFORMATION: Encryption was successful ");
            System.out.println("INFORMATION: The encrypted text is " + guiBackend.getEncryptedText());

            popupWindow.displayPopup();//Shows the popup
        }
        else {
            System.err.println("ERROR: Encryption Failed");//Error if the encryption failed
        }


    }

    /**
     * Is called when the user selects 'decrypt' in the main window.
     *
     * @param event the user selecting the button. Is printed in debug mode
     * @throws Exception the decrption throws this. So we need to as well
     */
    @FXML
    private void decrypt(ActionEvent event) throws Exception{

        System.out.println("INFORMATION: ActionEvent " + event);//Debug message
        //Calls the decrypt method, in the form of an if statement.
        if(guiBackend.decrypt()){
            //debug messages
            System.out.println("INFORMATION: Decryption was successful ");
            System.out.println("INFORMATION: The Decrypted text is " + guiBackend.getDecryptedText());
            popupWindow.displayPopup();//shows the popup window
        }
        else {
            System.err.println("ERROR: Decryption Failed");//Error if the decrypt method returns false
        }
    }



    //-------------------------------------------------------------
    //---------------EOF-FXML-FUNCTIONS----------------------------
    //-------------------------------------------------------------



}
