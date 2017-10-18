package Backend;
//any user errors in this class will be in the range of 100 - 199

public class CaesarCypher extends Encryption {
    //private int shift;
    //private char theCypher;

    public CaesarCypher(int userIn, String userIn1){
        if (userIn <= 2) {
            ErrorChecker.ErrorChecker(100);

        } else {
            System.out.println("Hi there key");
            key = userIn;
        }
        System.out.println("Hi there text ");
        text = userIn1;
        this.encryptMethod = "caesar";
    }



}
