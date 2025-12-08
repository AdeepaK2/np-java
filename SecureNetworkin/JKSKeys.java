import java.io.FileInputStream;
import java.security.KeyStore;

public class JKSKeys {
  public static void main(String[] args) throws Exception {
    KeyStore keyStore = KeyStore.getInstance("JKS");
    try (FileInputStream fis = new FileInputStream("keystore.jks")) {
    keyStore.load(fis, "changeit".toCharArray());
}

  }
}
