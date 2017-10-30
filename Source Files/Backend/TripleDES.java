package Backend;

public class TripleDES extends Encryption{
    public TripleDES(int keyIn, String textIn){
        encryptMethod = "3DES";
        text = textIn;
        key = keyIn;

    }

}
