package Backend.EncryptionMethods;
/**
 *  This is the AES 256 encryption class.
 *  This uses the java crypto library and the Apache common codecs which is licensed under the Apache Open Source License.
 * @music None :'(
 * @author Gregory Bell
 * @company TriHard Studios
 * @ver 1.0.0
 */

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

public final class AES implements Encryption, Decryption {

    //----------------------------------------------------------------------------------------
    //----------------------------ENCRYPTION--------------------------------------------------
    //----------------------------------------------------------------------------------------

    //------------------------PRIVATE-VARS---------------
    private String key;//the string where the key is stored.
    private String text;//the string where the plain text is stored.
    private static String encryptedText;//the string where the encrypted text is stored.
    //--------------------EOF-PRIVATE-VARS---------------

    public AES(){//constructor to avoid static reprogramming

    }


    /**
     * This is the encrypt method that is called from the GUIBackend.
     * It encodes the password with SHA-1 then encrypts, then it encodes the encrypted text with B64
     * @throws Exception MessageDigest, Secret Key, Cipher all throw an exception if they can't find the method we speifed.
     */

    public void encrypt() throws Exception {
        String keyin = key;
        String text = this.text;
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        byte[] digestOfPassword = md.digest(keyin.getBytes("utf-8"));

        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 16);

        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] plainTextBytes = text.getBytes("utf-8");
        byte[] encryptedBytes = cipher.doFinal(plainTextBytes);
        byte [] base64Bytes = Base64.encodeBase64(encryptedBytes);
        String encryptedText = new String(base64Bytes);

        this.encryptedText = encryptedText;
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
        String encryptedText = AES.encryptedText;
        byte[] base64Decoded = Base64.decodeBase64(encryptedText);
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 16);
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        //byte[] plainTextBytes = text.getBytes("utf-8");
        byte[] decryptedBytes = cipher.doFinal(base64Decoded);
        String decryptedText = new String(decryptedBytes);

        this.decryptedText = decryptedText;




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



}
