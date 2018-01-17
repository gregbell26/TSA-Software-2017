package Backend;

import org.apache.commons.codec.binary.Base64;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

public class AES implements Encryption, Decryption {
    private String key;
    private String text;
    private static String encryptedText;

    public AES(){

    }

    public void setAll(String keyIn, String textIn){
        encryptedText = "DEFAULT";
        text = textIn;
        key = keyIn;
    }


    public void encrypt() throws Exception {
        String keyin = key;
        String text = this.text;
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        byte[] digestOfPassword = md.digest(keyin.getBytes("utf-8"));

        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 16);

        //KeyGenerator keyGenerator = new KeyGenerator.getInstance("AES");
        //keyGenerator.init(256);
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] plainTextBytes = text.getBytes("utf-8");
        byte[] encryptedBytes = cipher.doFinal(plainTextBytes);
        byte [] base64Bytes = Base64.encodeBase64(encryptedBytes); //enable this to do B64
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



}
