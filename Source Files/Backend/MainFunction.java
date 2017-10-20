package Backend;

import java.util.Scanner;
import java.io.*;

/**
 * Bugs:
 *
 *
 * Solutions:
 *
 *
 *
 * ToDo:
 * RSA
 * use error code system
 *
 * Notes:
 * Keep this file VERY clean it should only call the methods and print the output
 *
 */
class print {
    static void ln(Object ln){ System.out.println(ln); }
    static void nln(Object nln) { System.out.print(nln);}
    static void credits(){}//credit where credit is due
}

class global {
    //AHH global variables
    static boolean encrypt =false;//tells us we can encrypt
    static boolean decrypt = false;//tells us we can decrypt
    static boolean active = false;//if we can exit or not

}
public class MainFunction{
    static void Pause(){//this pauses until the user presses a key
        int pause;
        try {
            pause = System.in.read();
        } catch (IOException e){

        }
    }

    public static void main(String[] args){
        //pre run stuff all of this stuff needs to be defined before we run 
        Encryption encryption = new Encryption();
        Scanner sc = new Scanner(System.in);
        String textIn, userIn; int keyIn;
        //end of local variable definition 
        //Intro
        print.ln("Welcome to Monarch TSA's encryption program");
        print.ln("This project was programed by");
        print.credits();
        print.nln("Press enter to load program");
        Pause();//waits for the user to
        global.active = true;
        while(global.active == true) {
            userIn = "";
            print.nln(">");
            userIn = sc.nextLine();
            if (userIn.equals("encrypt") || userIn.equals("en")) {
                userIn = "";
                print.nln("Enter the text you would like to encrypt: ");
                textIn = sc.nextLine();
                print.nln("Enter the encryption key: ");
                keyIn = sc.nextInt();
                print.ln("Enter the method you would like to use");
                print.nln(">");
                userIn = sc.nextLine();
                userIn = sc.nextLine();
                if (userIn.equals("caesar")||userIn.equals("c")){
                    CaesarCypher caesarCypher = new CaesarCypher(keyIn, textIn);
                    global.encrypt = true;
                }
                else {

                }
                if (global.encrypt == true){encryption.encrypt();}
                print.nln("Done.");
                global.encrypt = false;
            }
            else if(userIn.equals("view")) {
                print.nln("This is encrypted: ");
                encryption.viewEncrypted();
            }
            else if (userIn.equals("q")){
                global.active = false;
                System.exit(0);
            }
            Decryption decryption = new Decryption();
            print.nln("Here is it decrypted: ");
            decryption.decrypt();
            decryption.viewDecrypted();


        }


    }
}