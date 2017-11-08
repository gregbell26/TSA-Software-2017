package Backend;

import java.util.Scanner;
import java.io.*;
import java.math.BigInteger;

/**
 * Bugs:
 * RSA. Although its not here the stuff that we are using in a test area is not working. It is not decrpting nor encrypting correctly
 *
 * Solutions:
 * Well, I could just pray
 *
 *
 * ToDo:
 * RSA
 * Comments!!!!!!!!!!
 *
 * Notes:
 * Keep this file VERY clean it should only call the methods and print the output
 * When Gregory programed this he listened to a lot of All American Rejects.
 */
class print {
    static void ln(Object ln){ System.out.println(ln); }//equivalent of System.out.println(); to use use print.ln();
    static void nln(Object nln) { System.out.print(nln);}//equivalent of System.out.print(); to use use print.nln(""); (note the coloms)
    static void credits(){/*TODO THE CREDITS*/}//credit where credit is due
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
            pause = System.in.read();//waits for enter
        } catch (IOException e){

        }
    }
    static void Clear() {

    }
    public static void main(String[] args)throws Exception{
        //pre run stuff all of this stuff needs to be defined before we run

        //constructors
        Encryption encryption = new Encryption();//creating a encryptor object
        Decryption decryption = new Decryption();//same as above just with a decrptor
        Scanner sc = new Scanner(System.in); //a user in thing. Uses the name sc which stands for scanner
        //eof constructor definition

        //Local Vars
        String textIn, userIn; //textIn is the text that we'll be passing to an encryptors. userIn is the generic user input variable.
        float keyIn;//stores the password that the user enters. For encryption methods that need a string password type we are converting it in the function that needs it.
        //end of local variable definition

        //Intro this is displayed first. When we move to a GUI this will be stored in a about box.
        print.ln("Welcome to Monarch TSA's encryption program");
        print.ln("This project was programed by");
        print.credits();
        print.nln("Press enter to load program");
        //eof intro

        Pause();//waits for the user to press enter then it  runs..
        global.active = true;

        while(global.active) { //this is a loop that keeps the program running until we exit
            //userIn = "";//every time you see this it is us clearing the variable
            print.nln(">");//tells the user (s)he can enter something
            userIn = sc.nextLine();//user imput getter and strorer.

            //com handler I donn't know how to put this into its own function.
            //encrypt block
            if (userIn.equals("encrypt") || userIn.equals("en")) {//first equals is the full version and the next one is the abbration
                //userIn = "";

                print.nln("Enter the text you would like to encrypt: ");
                textIn = sc.nextLine();//this is the only time we apply a variable to textIn

                print.nln("Enter the encryption key: ");
                try {
                    keyIn = sc.nextFloat();//sets the key then passes it to the encryption method.
                }catch (Exception InputMismatchException){
                    keyIn = 0;
                    print.ln("Please make sure that your password it an interger and under 32 digits");
                    keyIn = sc.nextFloat();
                }

                print.nln("Enter the method you would like to use: ");
                userIn = sc.nextLine();//for some reason we have to put this twice to accept input
                userIn = sc.nextLine();//gets the encryption method that the user wants to use
                if (userIn.equals("caesar")||userIn.equals("c")){//checks if we are using the caesar cypher
                    CaesarCypher caesarCypher = new CaesarCypher(keyIn, textIn);//sets the variables and passes them to the master encryption class
                    global.encrypt = true;//says yes we can encrypt
                }
                else if (userIn.equals("3DES") || userIn.equals("3D")){//checks if we are using the 3DES method
                    TripleDES tripleDES = new TripleDES(keyIn, textIn);//sets the variables and passes them to the master encryption class
                    global.encrypt = true;//says yes we can encrypt
                }
                else {//error message
                    print.ln("That is an invalid method, or it has not been fully implemented into this program.");
                }

                if (global.encrypt){//when encrpyt is set to true encryt any text in the textIn variable
                    encryption.encrypt();
                    print.ln("Done.");
                }
                else {//error message
                    print.ln("Encryption Failed.");
                }

                global.encrypt = false;
            }

            //decryption drive
            else if (userIn.equals("decrypt") || userIn.equals("de")){
                print.nln("Verify your password: ");//has the user enter the password again
                keyIn = sc.nextFloat();//gets the key for the final time

                if (decryption.passMatch(keyIn)){//if the key matches...
                    decryption.setDecryptAll(keyIn);//..set all the variables in the decrption class and pass the key..
                    global.decrypt = true;//..then yes we are allowed to decrypt.
                }
                else {///error message
                    print.ln("Your password did not match");
                    global.decrypt = false;//its already false but you know lets just make sure
                }

                if (global.decrypt == true){//checks if we are able to decrypt
                    decryption.decrypt();
                    print.ln("Done.");
                }
                else {//error message
                    print.ln("Decryption Failed.");
                }

                global.decrypt = false;
            }

            //view coldasack
            else if(userIn.equals("view")) {//does it exacly like it says. Prints the encrypted and decrypted strings
                print.nln("This is encrypted: ");
                encryption.viewEncrypted();//prints what was encrypted.

                print.nln("Here is it decrypted: ");
                decryption.viewDecrypted();//prints what was decrypted.
            }

            //Just Quit
            else if (userIn.equals("q")){
                global.active = false;//this breaks the loop.. In Style!!
                System.exit(0);//Exits
            }

            //The sad street help and errors.. Are found here!!
            else if (userIn.equals("help") || userIn.equals("h")){//the help
                print.ln("Available Commands:");
                print.ln("encrypt ----------------------------------- Encrypts a string");
                print.ln("decrypt ----------------------------------- Decrypts the encrypted string");
                print.ln("view -------------------------------------- Prints both the encrypted and decrypted string");
                print.ln("help -------------------------------------- Prints this help");

            }

            else {//the sadness and the error
                print.ln("Command not found.");
            }



        }


    }
}