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

        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 32);

        //KeyGenerator keyGenerator = new KeyGenerator.getInstance("AES");
        //keyGenerator.init(256);
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] plainTextBytes = text.getBytes("utf-8");
        byte[] encryptedBytes = cipher.doFinal(plainTextBytes);
        //byte [] base64Bytes = Base64.encodeBase64(buf); enable this to do B64
        String encryptedText = new String(encryptedBytes);

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
