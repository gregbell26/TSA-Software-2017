package Backend;
//any user errors in this class will be in the range of 100 - 199

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.codec.binary.*;
public class Decryption  {

    private float key;
    private String text = "";
    private static String decryptedText;
    private static String decryptMethod;
    public Decryption(){//default constructor

    }

    public void setDecryptAll(float keyCheck){
        key = keyCheck;
        decryptedText = Encryption.encryptedText;
        decryptMethod = Encryption.encryptMethod;
    }

    //decryption methods
    private String decryptCaesar() {
        String text = decryptedText;
        int n = text.length();
        String output = "";
        for (int i = 0; i < n; i++) {
            int a = (int) text.charAt(i);

            if ((a >= 97) && (a <= 122)) {
                a = a - ((int)key % 26);
                char c = (char) ((a % 26) + 96);
                if (a < 'a') {
                    a = a + 26;
                }
            }
            output += (char) a;
        }
        return output;
    }

    private String decrypt3DES() throws Exception {
        String encryptedText = decryptedText;
        String keyin = Float.valueOf(this.key).toString();
        byte[] message = Base64.decodeBase64(encryptedText.getBytes("utf-8"));

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digestOfPassword = md.digest(keyin.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        SecretKey key = new SecretKeySpec(keyBytes, "DESede");

        Cipher decipher = Cipher.getInstance("DESede");
        decipher.init(Cipher.DECRYPT_MODE, key);

        byte[] plainText = decipher.doFinal(message);

        return new String(plainText, "UTF-8");
    }
//master decryption
    public String decrypt() throws  Exception{
        if(decryptMethod.equals("caesar")){//checks to see if the
            decryptedText = decryptCaesar();
        }
        else if(decryptMethod.equals("3DES")){
            decryptedText = decrypt3DES();
        }
        return decryptedText;
    }

    public void  viewDecrypted() {
        System.out.println(decryptedText);
    }

    public boolean passMatch(float key){//this will have to be revised for
        if (key == Encryption.key){
            return  true;
        }
        else {
            return false;
        }
    }

}
