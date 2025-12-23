import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class SecureServer{
  public static void main(String[] args) {
    SSLServerSocketFactory factory=(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
    SSLServerSocket server=(SSLServerSocket) factory.createServerSocket(5000);
  }
}

 class SecureClient{
  public static void main(String[] args) {
    SSLSocketFactory factory=(SSLSocketFactory) SSLSocketFactory.getDefault();
    SSSLSocket client = (SSLSocket) factory.createSocket("localhost",5000);
  }
 }