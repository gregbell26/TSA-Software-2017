package Backend;

import java.util.Scanner;
import java.io.*;

/**
 * Bugs:
 * RSA. Although its not here the stuff that we are using in a test area is not working. It is not decrpting nor encrypting correctly
 *
 * Solutions:
 * Well, I could just pray
 *
 *
 * ToDo:
 * RSA!!!!!!!!
 * Comments!!!!!!!!!!
 *
 * Notes:
 * Keep this file VERY clean it should only call the methods and print the output
 * When Gregory programed this he listened to a lot of All American Rejects.
 * This file was used to test the backend.. With the gui it is not nessary
 */

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
        //these are the encrytion and decrytion methods
        TripleDES tripleDES = new TripleDES();
        CaesarCypher caesarCypher = new CaesarCypher();
        Scanner sc = new Scanner(System.in); //a user in thing. Uses the name sc which stands for scanner
        //eof constructor definition

        //Local Vars
        String textIn, userIn; //textIn is the text that we'll be passing to an encryptors. userIn is the generic user input variable.
        String keyIn;//stores the password that the user enters. For encryption methods that need a string password type we are converting it in the function that needs it.
        //end of local variable definition

        //Intro this is displayed first. When we move to a GUI this will be stored in a about box.
        print.ln("Welcome to Monarch TSA's encryption program");
        print.ln("This project was programed by");
        print.credits();
        print.nln("Press enter to load program");
        //eof intro

        Pause();//waits for the user to press enter then it  runs..
        GlobalVars.active = true;

        while(GlobalVars.active) { //this is a loop that keeps the program running until we exit
            //userIn = "";//every time you see this it is us clearing the variable
            print.nln(">");//tells the user (s)he can enter something
            userIn = sc.nextLine();//user imput getter and strorer.

            //com handler I donn't know how to put this into its own function.
            //encrypt block
            if (userIn.equals("encrypt") || userIn.equals("en")) {//first equals is the full version and the next one is the abbration
                //userIn = "";
                //clearing all private variables.
                tripleDES.clearAll();//clears 3DES
                caesarCypher.clearAll();//clears caesar

                print.nln("Enter the text you would like to encrypt: ");
                textIn = sc.nextLine();//this is the only time we apply a variable to textIn

                print.nln("Enter the encryption key: ");
                keyIn = sc.nextLine();//takes the key in string form. Most of our methods use this so it more useful to convert it to a int when needed

                print.nln("Enter the method you would like to use: ");
                userIn = sc.nextLine();//gets the encryption method that the user wants to use
                if (userIn.equals("caesar")||userIn.equals("c")){//checks if we are using the caesar cypher
                    caesarCypher.setAll(keyIn, textIn);//sets the variables and passes them to the master encryption class
                    GlobalVars.encrypt = true;//says yes we can encrypt
                }
                else if (userIn.equals("3DES") || userIn.equals("3D")){//checks if we are using the 3DES method
                    tripleDES.setAll(keyIn, textIn);
                    //print.ln("SetAll");
                    //TripleDES tripleDES = new TripleDES(keyIn, textIn);//sets the variables and passes them to the master encryption class
                    GlobalVars.encrypt = true;//says yes we can encrypt
                }
                else {//error message
                    print.ln("That is an invalid method, or it has not been fully implemented into this program.");
                }

                if (GlobalVars.encrypt){//when encrpyt is set to true encryt any text in the textIn variable
                    //this is a very stupid desioion but this is the best way to do this I think
                    if (tripleDES.getEncryptedText() != null) {
                        //print.ln("3D encrypt");
                        tripleDES.encrypt();
                    }
                    else if (caesarCypher.getEncryptedText() != null) {
                        //print.ln("Caeser encrypt");
                        caesarCypher.encrypt();
                    }


                    print.ln("Done.");

                }
                else {//error message
                    print.ln("Encryption Failed.");
                }

                GlobalVars.encrypt = false;
            }

            //decryption drive
            else if (userIn.equals("decrypt") || userIn.equals("de")){
                print.nln("Verify your password: ");//has the user enter the password again
                keyIn = sc.nextLine();//gets the key for the final time

                if (tripleDES.passMatch(keyIn) || caesarCypher.passMatch(keyIn)){//if the key matches...
                    GlobalVars.decrypt = true;//..then yes we are allowed to decrypt.
                }
                else {///error message
                    print.ln("Your password did not match");
                    GlobalVars.decrypt = false;//its already false but you know lets just make sure
                }

                if (GlobalVars.decrypt == true){//checks if we are able to decrypt
                    if (tripleDES.getEncryptedText() != null) {
                        tripleDES.decrypt();
                    }
                    else if (caesarCypher.getEncryptedText() != null) {
                        caesarCypher.decrypt();
                    }
                    print.ln("Done.");
                }
                else {//error message
                    print.ln("Decryption Failed.");
                }

                GlobalVars.decrypt = false;
            }

            //view coldasack
            else if(userIn.equals("view")) {//does it exacly like it says. Prints the encrypted and decrypted strings
                print.nln("This is encrypted: ");
                GlobalFuncts.viewEncrypted();//prints what was encrypted.

                print.nln("Here is it decrypted: ");
                GlobalFuncts.viewDecrypted();//prints what was decrypted.
            }

            //Just Quit
            else if (userIn.equals("q")){
                GlobalVars.active = false;//this breaks the loop.. In Style!!
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