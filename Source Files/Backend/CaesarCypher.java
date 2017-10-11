package Backend;
import java.util.*;
//any user errors in this class will be in the range of 100 - 199

public class CaesarCypher extends Encrypter {
    static private int shift;
    //private char theCypher;

    public static void caesarShiftFinder(int userIn) {

        if (userIn >= 2) {
            ErrorChecker.ErrorChecker(100);

        } else {
            shift = userIn;
        }


    }

    public static String encryptCaesar(String original) {
        int n = original.length();
        String output = "";
        for (int i = 0; i < n; i++) {
            int a = (int) original.charAt(i);
            if ((a >= 65) && (a <= 90)) {
                a = Character.toLowerCase(a);
            }
            if ((a >= 97) && (a <= 122)) {
                a -= 96;
                a += shift;
                char c = (char) ((a % 26) + 96);
                output += c;
            } else {
                output += (char)a;
            }
        }
        return output;
    }
}
