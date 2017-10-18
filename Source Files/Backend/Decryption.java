package Backend;
//any user errors in this class will be in the range of 100 - 199

public class Decryption  {

    public static int key = 0;
    public static String text = "";
    String decryptedText;
    static String decryptMethod;
    public Decryption(){//default constructor
        decryptedText = "";
        decryptMethod = "";
    }

    //encryption methods
    private String decryptCaesar() {
        String text = decryptedText;
        int n = text.length();
        String output = "";
        for (int i = 0; i < n; i++) {
            int a = (int) text.charAt(i);
            if ((a >= 65) && (a <= 90)) {
                a = Character.toLowerCase(a);
            }
            if ((a >= 97) && (a <= 122)) {
                a -= 96;
                a -= key;
                char c = (char) ((a % 26) + 96);
                output += c;
            } else {
                output += (char)a;
            }
        }
        return output;
    }

    public String encrypt(){
        //System.out.println("Hi there encryper ");
        if(decryptMethod.equals("caesar")){
            System.out.println("Hi there");
            decryptedText = decryptCaesar();
        }
        return decryptedText;
    }

    public void  viewDecrypted() {
        System.out.println(decryptedText);
    }

}
