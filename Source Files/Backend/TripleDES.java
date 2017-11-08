package Backend;

public class TripleDES extends Encryption{
    public TripleDES(float keyIn, String textIn){
        encryptMethod = "3DES";
        text = textIn;
        key = keyIn;

    }

}
