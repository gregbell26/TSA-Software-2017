package Backend;

/**
 * All encrypter errors will be 100 to 199
 * This will be used to check for errors in what the user entered
 * Possible errors might be password is too short, failed encrytion failure. Input exceeds maxuim allowed.
 */
public class ErrorChecker {

    public static String ErrorChecker(int errorCode){
        String errorText = "";

        if (errorCode == 100){
            errorText = "That is not a valid shift number please make sure that your number is greater than 2";
        }
        return errorText;
    }





}
