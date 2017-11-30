package Backend;

public class GUIBackend {

    public GUIBackend(){
        //HAHA I WILL NOT USE STATIC MOTHER FUCKERS!!!!
    }
    //------------------classes----------------------------
    static TripleDES tripleDES = new TripleDES();
    static CaesarCypher caesarCypher = new CaesarCypher();
    //-----------------eof-classes--------------------------
//-----------------Encryption--------------------------------------
    //----------------private-vars--------------------------
    private String notEncryptedText;
    private String encryptionKey;
    private String encryptionMethod;
    private String encryptedText;
    //---------------eof-private-vars-----------------------


    public void setAll(String text, String key, String method){
        if(method.equals("3DES")){
            tripleDES.setAll(key, text);

        }
        else if (method.equals("Caesar")){
            caesarCypher.setAll(key, text);
        }
        notEncryptedText = text;
        encryptionKey = key;
        encryptionMethod =method;

    }

    public boolean encrypt()throws Exception{
        //this is a very stupid desioion but this is the best way to do this I think
        if (tripleDES.getEncryptedText() != null) {
            //print.ln("3D encrypt");
            tripleDES.encrypt();
            encryptedText = tripleDES.getEncryptedText();
            return true;
        }
        else if (caesarCypher.getEncryptedText() != null) {
            //print.ln("Caeser encrypt");
            caesarCypher.encrypt();
            encryptedText = caesarCypher.getEncryptedText();
            return true;
        }
        else {
            return false;
        }
    }

    public String getEncryptedText() {
        return encryptedText;
    }
//------------------------eof-encryption------------------------------
    public void clearAll(){

        caesarCypher.clearAll();
        tripleDES.clearAll();
    }

//----------------------decryption--------------------------------------
    //---------------private-vars---------------------------
    private String decryptedText;
    //-------------------eof-private-vars------------------

    public boolean decrypt() throws Exception{
        if (tripleDES.getEncryptedText() != null) {
            tripleDES.decrypt();
            decryptedText = tripleDES.getDecryptedText();
            return true;
        }
        else if (caesarCypher.getEncryptedText() != null) {
            caesarCypher.decrypt();
            decryptedText= caesarCypher.getDecryptedText();
            return true;
        }
        else {
            return false;
        }
    }

    public String getDecryptedText() {
        return decryptedText;
    }
}
