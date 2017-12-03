package Backend;
/**
 * This file is used to encrypt and decrpt messages using Triple DES
 * This file is used in MainFunction and GUIBackend.
 * MainFunction was used to test the backend while GUIBackend is the file that ties the backend to the GUI
 * @music All American Rejects
 * @author Gregory Bell
 * @company TriHard Studios
 * @version 1.0
 */

//external libraries
import org.apache.commons.codec.binary.Base64;
//eof external libraries

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

public class TripleDES implements Encryption, Decryption {
    //Encryption Vars
    private String key;
    private String text;
    private static String encryptedText;
    //eof instance variable definition


    public TripleDES(){//default constructor
    }

    /**
     * This method takes the variables when 3DES is selected and sets them into their equivalent
     * private instace variable
     * @param keyIn The inputted key that get passed to the string key
     * @param textIn the inputted text that get passed to the string text
     */
    public void setAll(String keyIn, String textIn){
        encryptedText = "DEFAULT";
        text = textIn;
        key = keyIn;
    }

    /**
     * Encrypts the private variable text with the password
     * @throws Exception Catches the exception thrown by message digest, and
     */
    @Override
    public void encrypt() throws Exception {
        String keyin = key;
        String text = this.text;
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digestOfPassword = md.digest(keyin.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

        SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] plainTextBytes = text.getBytes("utf-8");
        byte[] buf = cipher.doFinal(plainTextBytes);
        byte [] base64Bytes = Base64.encodeBase64(buf);
        String base64EncryptedString = new String(base64Bytes);

        encryptedText = base64EncryptedString;

    }


    public static String getEncryptedText() {
        return encryptedText;
    }




    //------------------------------------------------------------------
    //-----------------------EOF-ENCRYPTION-----------------------------
    //------------------------------------------------------------------

    private static String decryptedText;

    public boolean passMatch(String keyIn){
        //key = "";//avoiding null pointers
        return key.equals(keyIn);

    }

    public void decrypt()throws Exception{
        String encryptedText = TripleDES.encryptedText;
        byte[] message = Base64.decodeBase64(encryptedText.getBytes("utf-8"));

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        SecretKey key = new SecretKeySpec(keyBytes, "DESede");

        Cipher decipher = Cipher.getInstance("DESede");
        decipher.init(Cipher.DECRYPT_MODE, key);

        byte[] plainText = decipher.doFinal(message);

        decryptedText = new String(plainText, "UTF-8");

    }
    public static String getDecryptedText() {
        return decryptedText;
    }

    //-----------------------------------------------------------
    //--------------------------EOF-DECRYPTION-------------------
    //-----------------------------------------------------------

    public void clearAll(){
        key = null;
        text = null;
        encryptedText = null;
        decryptedText = null;

    }


}
