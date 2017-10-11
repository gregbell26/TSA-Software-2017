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
        int userInInt = 0;
        Scanner in = new Scanner(System.in);
        String userInString = "";

        print.ln("Enter the shift number you want to use");
        userInInt = in.nextInt();
        CaesarCypher.caesarShiftFinder(userInInt);
        print.ln("Now enter the text you want to encrypt.");
        userInString = in.nextLine();
        print.ln(CaesarCypher.encryptCaesar(userInString));


    }
}