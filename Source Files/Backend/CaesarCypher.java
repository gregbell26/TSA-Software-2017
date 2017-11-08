package Backend;
//any user errors in this class will be in the range of 100 - 199


public class CaesarCypher extends Encryption {
    //private int shift;
    //private char theCypher;

    public CaesarCypher(float userIn, String userIn1){

        if (userIn <= 2) {
            print.ln("This cesar cypher is not secure. ");
        } else {
            //System.out.println("Hi there key");
            key = userIn;
        }
        //System.out.println("Hi there text ");
        text = userIn1;
        this.encryptMethod = "caesar";
    }



}
