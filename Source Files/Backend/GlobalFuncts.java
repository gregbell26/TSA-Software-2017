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
