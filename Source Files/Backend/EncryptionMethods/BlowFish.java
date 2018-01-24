package Backend.EncryptionMethods;
/**
 * This method was originally going to be TwoFish, Blowfish's successor. But I could not write code that would work consistently
 * to decrypt. Encrypt worked great, just not decryption.
 * This uses the Java crypto libaray and the Apache Common Codecs Libaray which is licensed under the Apache Open Source license.
 * @music Matchbox 20
 * @author Gregory Bell
 * @company TriHard Studios
 * @version 1.0.0
 */

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

public final class BlowFish implements Encryption, Decryption{
    private String key;
    private String text;
    private static String encryptedText;

    public BlowFish(){

    }



    /**
     * This is the encrypt method that is called from the GUIBackend.
     * It encodes the password with SHA-1 then encrypts, then it encodes the encrypted text with B64
     * @throws Exception MessageDigest, Secret Key, Cipher all throw an exception if they can't find the method we speifed.
     */
    public void encrypt() throws Exception {
        //SecureRandom passSeed = new SecureRandom(key.getBytes());
        //KeyGenerator generator = KeyGenerator.getInstance("Blowfish");
        //generator.init(passSeed);
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digestOfPassword = md.digest(key.getBytes("UTF-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 16);



        SecretKey secretKey = new SecretKeySpec(keyBytes, "Blowfish");

        Cipher cipher = Cipher.getInstance("Blowfish");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        byte[] base64Encoded = Base64.encodeBase64Chunked(encryptedBytes);
        encryptedText = new String(base64Encoded);

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
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digestOfPassword = md.digest(key.getBytes("UTF-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 16);
        SecretKey secretKey = new SecretKeySpec(keyBytes, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedBytes = cipher.doFinal(base64Decode);

        decryptedText = new String(decryptedBytes);

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
    public void setAll(String keyIn, String textIn){
        encryptedText = "DEFAULT";
        text = textIn;
        key = keyIn;
    }



}
