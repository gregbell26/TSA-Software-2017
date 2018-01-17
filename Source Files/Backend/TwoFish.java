package Backend;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

public class TwoFish implements Encryption, Decryption{
    private String key;
    private String text;
    private static String encryptedText;

    public TwoFish(){

    }

    public void setAll(String keyIn, String textIn){
        encryptedText = "DEFAULT";
        text = textIn;
        key = keyIn;
    }


    public void encrypt() throws Exception {
        SecureRandom passSeed = new SecureRandom(key.getBytes());
        KeyGenerator generator = KeyGenerator.getInstance("twofish");
        generator.init(passSeed);
        SecretKey secretKey = generator.generateKey();

        Cipher cipher = Cipher.getInstance("twofish");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        byte[] base64Encoded = Base64.encodeBase64Chunked(encryptedBytes);
        encryptedText = base64Encoded.toString();

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
        byte[] base64Decode = Base64.decodeBase64(encryptedText.getBytes());
        SecureRandom passSeed = new SecureRandom(key.getBytes());
        KeyGenerator generator = KeyGenerator.getInstance("twofish");
        generator.init(passSeed);
        SecretKey secretKey = generator.generateKey();
        Cipher cipher = Cipher.getInstance("twofish");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedBytes = cipher.doFinal(base64Decode);

        decryptedText = decryptedBytes.toString();

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
