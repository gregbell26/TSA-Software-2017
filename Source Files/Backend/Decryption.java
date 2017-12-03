package Backend;
//any user errors in this class will be in the range of 100 - 199

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.codec.binary.*;
public interface Decryption  {


    void decrypt() throws  Exception;






}
