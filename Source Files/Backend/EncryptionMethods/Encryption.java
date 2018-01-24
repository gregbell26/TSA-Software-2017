package Backend.EncryptionMethods;
//todo comment
interface Encryption  {

    float key = 0;
    String text = "";
    String encryptedText = "";

   void setAll(String userIn, String userIn1);


   void encrypt()throws Exception;


}


