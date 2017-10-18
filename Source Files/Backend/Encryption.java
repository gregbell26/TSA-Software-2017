package Backend;
//any user errors in this class will be in the range of 100 - 199

//this class will encrypt anything in the usrInput array.
//It should also have multiple encryption methods.
// It has not been decided who will program this.
//some forms of encrytion that we should look into is AES - 128, 256 we should also look into DES or 3DES as they are very secure. RSA also might be good to look into as well.
//This will need a variable called encryer out.
public class Encryption  {

    public static int key = 0;
    public static String text = "";
    public static String encryptedText;
    static String encryptMethod;
    public Encryption(){//default constructor
        encryptedText = "";
        encryptMethod = "";
    }

//encryption methods
    private String encryptCaesar() {
        String text = Encryption.text;
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
        return output;
    }

   public String encrypt(){
        //System.out.println("Hi there encryper ");
        if(encryptMethod.equals("caesar")){
            //System.out.println("Hi there");
            encryptedText = encryptCaesar();
        }
        return encryptedText;
   }

   public void  viewEncrypted() {
       System.out.println(encryptedText);
   }

}


