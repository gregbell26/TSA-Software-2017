package Backend;
//any user errors in this class will be in the range of 100 - 199


public class CaesarCypher implements Encryption {
    //private int shift;
    private float key;
    private String text;
    private String encryptedText;
    private String encryptMethod;


    public CaesarCypher(){


    }

    @Override
    public void setAll(String key, String userIn1) {
        float keyIn= 0;
        try {
            keyIn = Float.parseFloat(key);
        }catch (Exception Mismatch){
            System.out.println();
        }
        if (keyIn <= 2) {
            print.ln("This cesar cypher is not secure. ");
        } else {
            //System.out.println("Hi there key");
            this.key = keyIn;
        }
        //System.out.println("Hi there text ");
        text = userIn1;
        this.encryptMethod = "caesar";
    }

    @Override
    public void encrypt() {
        String text = "";
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

    @Override
    public void viewEncrypted() {
        System.out.print(encryptedText);
    }

}
