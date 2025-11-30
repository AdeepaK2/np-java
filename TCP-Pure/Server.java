import java.net.ServerSocket; 
import java.net.Socket;
import java.nio.Buffer;
import java.io.PrintWriter; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Server {
  public static void main(String[] args) throws IOException {
    // Create a server socket listening on port 8080
    ServerSocket serverSocket=new ServerSocket(8080);

    // Wait for and accept a client connection (blocking call)
    Socket clienSocket=serverSocket.accept();
    System.out.println(
      "Client connected: " + clienSocket.getInetAddress().getHostAddress()
    );

    // Create BufferedReader to read data from client
    // InputStreamReader converts byte stream to character stream
    BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
    System.out.println("Client says: " + in.readLine());
    
    // Create PrintWriter to send data to client (true enables auto-flushing)
    PrintWriter out=new PrintWriter(clienSocket.getOutputStream(),true);
    out.println("Weather is good");
    
    
    clienSocket.close();
    serverSocket.close();
  }
  
}
