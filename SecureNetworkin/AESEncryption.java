import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;

public class  AESEncryption{
  public static void main(String[] args) throws Exception  {
    Cipher cipher=Cipher.getInstance("AES");
    SecretKey key=new SecretKeySpec("MySecurityKey123".getBytes(),"AES"); // exactly 16 bytes

    cipher.init(Cipher.ENCRYPT_MODE, key);
    byte[] encryptedData = cipher.doFinal("Sensitive Data".getBytes());

    cipher.init(Cipher.DECRYPT_MODE, key);
    byte[] decryptedData = cipher.doFinal(encryptedData);
    System.out.println(new String(decryptedData));



  }
}