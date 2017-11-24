package Backend;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

public class TripleDES implements Encryption, Decryption {
    //instance vars
    private String key;
    private String text;
    private static String encryptedText;
    //eof instance variable definition


    public TripleDES(){//default constructor
    }

    /**
     *
     * @param keyIn
     * @param textIn
     */

    public void setAll(String keyIn, String textIn){
        encryptedText = "DEFAULT";
        text = textIn;
        key = keyIn;
    }

    /**
     *
     * @throws Exception
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

    @Override
    public boolean passMatch(String keyIn){
        //key = "";//avoiding null pointers
        if(key.equals(keyIn)){
            return true;
        }
        else {
            return false;
        }

    }

    public void decrypt()throws Exception{
        String encryptedText = this.encryptedText;
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
