package Backend;
//any user errors in this class will be in the range of 100 - 199

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.codec.binary.*;

//this class will encrypt anything in the usrInput array.
//It should also have multiple encryption methods.
// It has not been decided who will program this.
//some forms of encrytion that we should look into is AES - 128, 256 we should also look into DES or 3DES as they are very secure. RSA also might be good to look into as well.
//This will need a variable called encryer out.
public class Encryption  {

    public static int key = 0;
    public static String text = "";
    public static String encryptedText;
    static String encryptMethod;
    public Encryption(){//default constructor
        encryptedText = "";
        encryptMethod = "";
    }

//encryption methods
    private String encryptCaesar() {
        String text = Encryption.text;
        int n = text.length();
        String output = "";
        for (int i = 0; i < n; i++) {
            int a = (int) text.charAt(i);
            if ((a >= 65) && (a <= 90)) {
                a = Character.toLowerCase(a);
            }
            if ((a >= 97) && (a <= 122)) {
                a -= 96;
                a += key;
                char c = (char) ((a % 26) + 96);
                output += c;
            } else {
                output += (char)a;
            }
        }
        return output;
    }
    private String encrypt3DES() throws Exception {
        String keyin = Integer.valueOf(this.key).toString();
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

        return base64EncryptedString;
    }
//this is what will determine the cypher we use
   public String encrypt()throws Exception{
        if(encryptMethod.equals("caesar")){
            encryptedText = encryptCaesar();
        }
        else if (encryptMethod.equals("3DES")){
            encryptedText = encrypt3DES();
        }
        return encryptedText;
   }

   public void  viewEncrypted() {
       System.out.println(encryptedText);
   }

}


