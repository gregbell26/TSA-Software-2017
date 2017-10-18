package Backend;

import java.util.Scanner;

/**
 * Bugs:
 * None for now...
 *
 * Solutions:
 * Who Knows....
 *
 *
 * ToDo:
 * Everything
 * use error code system
 *
 * Notes:
 * Keep this file VERY clean it should only call the methods and print the output
 *
 */
class print {
    static void ln(Object ln){
        System.out.println(ln);
    }
}
public class MainFunction{
    public static void main(String[] args){
        Encryption encryption = new Encryption();

        Scanner sc = new Scanner(System.in);
        String sIn; int kIn;
        print.ln("Enter the text you would like to encrypt");
        sIn = sc.nextLine();
        print.ln("Enter the key that you would like to encrypt");
        kIn = sc.nextInt();

        CaesarCypher caesarCypher = new CaesarCypher(kIn, sIn);
        encryption.encrypt();
        encryption.viewEncrypted();






    }
}