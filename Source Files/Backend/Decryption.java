package Backend;
//any user errors in this class will be in the range of 100 - 199

public class Decryption  {

    private int key;
    public static String text = "";
    static String decryptedText;
    static String decryptMethod;
    public Decryption(){//default constructor

    }

    public void setDecryptAll(int keyCheck){
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
                a = a - (key % 26);
                char c = (char) ((a % 26) + 96);
                if (a < 'a') {
                    a = a + 26;
                }
            }
            output += (char) a;
        }
        return output;
    }
//master decryption
    public String decrypt(){
        if(decryptMethod.equals("caesar")){
            decryptedText = decryptCaesar();
        }
        return decryptedText;
    }

    public void  viewDecrypted() {
        System.out.println(decryptedText);
    }

    public boolean passMatch(int key){
        if (key == Encryption.key){
            return  true;
        }
        else {
            return false;
        }
    }

}
