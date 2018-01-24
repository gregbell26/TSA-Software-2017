package Backend;

import Backend.EncryptionMethods.*;

/**
 * This class connects the backend to the GUI.
 * Doing this is better than importing all of the backend.
 * This also makes the MainWindow file look a lot cleaner
 * @music Counting Crows && The Killers
 * @author Gregory Bell
 * @company TriHard Studios
 * @version  1.5.0
 *
 */
public class GUIBackend {

    //A constructor to avoid reprogramming this to use static.
    public GUIBackend(){
        //HAHA I WILL NOT USE STATIC MOTHER F*CKERS!!!!
    }

    //------------------CLASSES----------------------------
    /**
     * This creates a bunch of private instances of the methods.
     * The constructors have one purpose, to avoid programing with static.
     */
    private TripleDES tripleDES = new TripleDES();
    private CaesarCypher caesarCypher = new CaesarCypher();
    private Base64Encryption base64Encryption = new Base64Encryption();
    private AES AES256encryption = new AES();
    private BlowFish blowFish = new BlowFish();
    //-----------------EOF-CLASSES--------------------------

    //--------------------------------------------------------------------------
    //-----------------------ENCRYPTION-----------------------------------------
    //--------------------------------------------------------------------------

    //----------------PRIVATE-VARS--------------------------
    private String notEncryptedText;
    private String encryptionKey;
    private String encryptionMethod;
    private String encryptedText;
    //---------------EOF-PRIVATE-VARS-----------------------




    /**
     * Encrypts but checks if getEncryptedText is null if it is not it'll run that control flow.
     * @return returns true if encryption was successful false if not.
     * @throws Exception tripleDes.encrypt throws an exception
     */
    public boolean encrypt()throws Exception{
        if (tripleDES.getEncryptedText() != null) { //Is triple des null? if not run...
            tripleDES.encrypt();//calls triple des encryption thingy
            encryptedText = tripleDES.getEncryptedText(); //sets the triple des encrypted text to the private string encryptedText
            return true;//read the method description
        }
        else if (caesarCypher.getEncryptedText() != null) {//Is caesar null if not run...
            caesarCypher.encrypt();//...encrypt...
            encryptedText = caesarCypher.getEncryptedText();//...set...
            return true;//...return......
        }
        else if (base64Encryption.getEncryptedText() != null){//Is B64 null? If no run...
            base64Encryption.encrypt();//...encrypt...
            encryptedText = base64Encryption.getEncryptedText();//...set...
            return true;//..return...
        }
        else if (AES256encryption.getEncryptedText() != null){//Is AES null? If not run...
            AES256encryption.encrypt();//...encrypt...
            encryptedText = AES256encryption.getEncryptedText();//...set...
            return true;//...return...
        }
        else if (blowFish.getEncryptedText() != null){//Is blowfish null? If not run...
            blowFish.encrypt();//...encrypt...
            encryptedText = blowFish.getEncryptedText();//...set...
            return true;//...return...
        }
        else {
            return false;//if the encryption fails return false
        }
    }

    /**
     * A getter method to retrive the encrypted text
     * @return encryptedText
     */
    public String getEncryptedText() {
        return encryptedText;
    }

    //-------------------------------------------------------------------------
    //---------------------------EOF-ENCRYPTION--------------------------------
    //-------------------------------------------------------------------------


    //-------------------------------------------------------------------------
    //-----------------------------DECRYPTION----------------------------------
    //-------------------------------------------------------------------------

    //-----------------------PRIVATE-VARIABLES---------------------------
    private String decryptedText;
    //---------------------EOF-PRIVATE-VARIABLES-------------------------

    /**
     * This method is almost the exact same as the encryption method that only difference is that
     * it decrypts instead of encrypting
     * @return true if the decryption was successful false if not
     * @throws Exception so we can triple des it up!
     */
    public boolean decrypt() throws Exception{
        if (tripleDES.getEncryptedText() != null) {//checks if the encrypted string is null...
            tripleDES.decrypt();//...if not decrypt...
            decryptedText = tripleDES.getDecryptedText();//...set...
            return true;//...return
        }
        else if (caesarCypher.getEncryptedText() != null) {//checks if the encrypted string is null...
            caesarCypher.decrypt();//...if not decrypt...
            decryptedText= caesarCypher.getDecryptedText();//...set...
            return true;//...return
        }
        else if (base64Encryption.getEncryptedText() != null){
            base64Encryption.decrypt();
            decryptedText = base64Encryption.getDecryptedText();
            return true;
        }
        else if (AES256encryption.getEncryptedText() != null){
            AES256encryption.decrypt();
            decryptedText = AES256encryption.getDecryptedText();
            return true;
        }
        else if (blowFish.getEncryptedText() != null){
            blowFish.decrypt();
            decryptedText = blowFish.getDecryptedText();
            return true;
        }
        else {//if we had errors decrypting
            return false;//return false
        }
    }

    /**
     * Getter method for the decrypted string
     * @return decryptedText
     */
    public String getDecryptedText() {
        return decryptedText;
    }

    //------------------------------------------------------------------------
    //-------------------------EOF-DECRYPTION---------------------------------
    //------------------------------------------------------------------------


    //------------------------------------------------------------------------
    //-----------------------MISC-FUNCTIONS-----------------------------------
    //------------------------------------------------------------------------
    public void clearAll(){
        encryptedText = null;
        decryptedText = null;
        encryptionKey = null;
        base64Encryption.clearAll();
        caesarCypher.clearAll();
        tripleDES.clearAll();
        AES256encryption.clearAll();
        blowFish.clearAll();

    }

    /**
     * This method takes the text entered in the userInput fields and sets them to the required areas
     *
     * @param text the text that will get encrypted. Gets passed to the private String notEncryptedText
     * @param key the key that will be passed to the setAll sub class as defined by method
     * @param method decides what encryption algorithm to use. This var comes from the box in the main window
     */
    public void setAll(String text, String key, String method){
        if(method.equals("3DES")){
            tripleDES.setAll(key, text);

        }
        else if (method.equals("Caesar")){
            caesarCypher.setAll(key, text);
        }
        else if (method.equals("Base64")){
            base64Encryption.setAll(key, text);
        }
        else if (method.equals("AES 256")){
            AES256encryption.setAll(key, text);
        }
        else if (method.equals("Blow Fish")){
            blowFish.setAll(key, text);
        }
        else {
            System.err.println("ERROR: No method selected or invalid method selected");
        }
        notEncryptedText = text;
        encryptionKey = key;
        encryptionMethod =method;

    }
    //-------------------------------------------------------------------------
    //------------------------EOF-MISC-FUNCTIONS-------------------------------
    //-------------------------------------------------------------------------

}
