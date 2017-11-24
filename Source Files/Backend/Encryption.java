package Backend;
//todo comment
public interface Encryption  {

    float key = 0;
    String text = "";
    String encryptedText = "";

   public void setAll(String userIn, String userIn1);


   public void encrypt()throws Exception;


}


