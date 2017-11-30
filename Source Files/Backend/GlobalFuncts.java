package Backend;

public class GlobalFuncts {
    public static void viewEncrypted(){
        if (TripleDES.getEncryptedText() != null) {
            System.out.println(TripleDES.getEncryptedText());
        }
        else if (CaesarCypher.getEncryptedText() != null) {
            System.out.println(CaesarCypher.getEncryptedText());
        }
        else {
            System.out.println("Nothing has been encrypted. Type 'encrypt' to view encrypted text.");
        }
    }

    public static void viewDecrypted() {
        if (TripleDES.getDecryptedText() != null) {
            System.out.println(TripleDES.getDecryptedText());
        }
        else if (CaesarCypher.getDecryptedText() != null) {
            System.out.println(CaesarCypher.getDecryptedText());
        }
        else {
            System.out.println("Nothing has been decrypted. Type 'decrypt' to view decrypted text.");
        }
    }
}
class print {
    static void ln(Object ln){ System.out.println(ln); }//equivalent of System.out.println(); to use use print.ln();
    static void nln(Object nln) { System.out.print(nln);}//equivalent of System.out.print(); to use use print.nln(""); (note the coloms)
    static void credits(){/*TODO THE CREDITS*/}//credit where credit is due
}

class GlobalVars {
    //AHH GlobalVars variables
    static boolean encrypt =false;//tells us we can encrypt
    static boolean decrypt = false;//tells us we can decrypt
    static boolean active = false;//if we can exit or not

}
