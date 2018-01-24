package Backend.EncryptionMethods;
/**
 * This will 'encrypt' text useing Base64 hashing
 * encrypt is in quotes because it is not really encypting but rather hashing it
 * In this file we are using the Apache Common Codec Libray which is Licensed under Apache Open Source License
 * @music Journey
 * @author Gregory Bell
 * @company TriHard Studios
 * @version 1.0.0
 */
import org.apache.commons.codec.binary.Base64;

public final class Base64Encryption implements Encryption, Decryption{

    private String text;
    private static String encryptedText;

    public Base64Encryption(){}

    @Override
    public void setAll(String keyIn, String textIn) {
        encryptedText = "DEFAULT";
        text = textIn;
        keyIn = null;
    }

    /**
     * Encodes the text with Base 64
     *
     */

    @Override
    public void encrypt(){
        String text = this.text;
        byte[] bytesEncoded = Base64.encodeBase64(text.getBytes());
        String base64EncryptedString = new String(bytesEncoded);
        encryptedText = base64EncryptedString;

    }

    public static String getEncryptedText() {
        return encryptedText;
    }


    private static String decryptedText;

    @Override
    public void decrypt() {
        byte[] bytesDecoded= Base64.decodeBase64(encryptedText );
        String base64DecryptedString = new String(bytesDecoded);
        decryptedText = base64DecryptedString;

    }

    public static String getDecryptedText() {
        return decryptedText;
    }

    public void clearAll(){
        text = null;
        encryptedText = null;
        decryptedText = null;

    }
}
