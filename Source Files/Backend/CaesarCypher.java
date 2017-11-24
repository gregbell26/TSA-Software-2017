package Backend;
//any user errors in this class will be in the range of 100 - 199


public class CaesarCypher implements Encryption, Decryption {
    //private int shift;
    private float key;
    private String text;
    private static String encryptedText;
    private String encryptMethod;


    public CaesarCypher(){
    }

    @Override
    public void setAll(String key, String userIn1) {
        float keyIn= 0;
        try {
            //System.out.println("Try..");
            keyIn = Float.parseFloat(key);
        }catch (Exception InputMismatchException){
            System.out.println();
        }
        if (keyIn <= 2) {
            print.ln("This cesar cypher is not secure. ");
        } else {
            System.out.println("Hi there key");

            this.key = keyIn;
        }
        //System.out.println("Hi there text ");
        text = userIn1;
        this.encryptMethod = "caesar";
        encryptedText = "DEFAULT";

    }

    @Override
    public void encrypt() {
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

        encryptedText = output;
    }


    public static String getEncryptedText() {
        return encryptedText;
    }



    //------------------------------------------------------------------
    //-----------------------EOF-ENCRYPTION-----------------------------
    //------------------------------------------------------------------

    private static String decryptedText;

    @Override
    public boolean passMatch(String key) {
        float keyIn= 0;
        try {
            keyIn = Float.parseFloat(key);

        }catch (Exception InputMismatchException){
            System.out.println();
        }
        if (keyIn == this.key)

            return true;
        else
            return false;
    }

    @Override
    public void decrypt() throws Exception{
        String text = encryptedText;
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
        decryptedText = output;
    }

    public static String getDecryptedText() {
        return decryptedText;
    }

    public void clearAll(){
        key = 0;
        text = null;
        encryptedText = null;
        decryptedText = null;

    }



}
