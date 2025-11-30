import java.net.Socket; 
import java.io.PrintWriter; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client{
  public static void main(String[] args) throws IOException {
    // Create a socket connection to the server at localhost on port 
    Socket socket = new Socket("localhost", 8080);
    
    // Create PrintWriter for sending data to server (true enables auto-flushing)
    PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
    out.println("Weather was bad");
    
    // Create BufferedReader to read server's response
    // InputStreamReader converts byte stream to character stream
    BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
    // Read the server's response
    String response =in.readLine();
    System.out.println("Server says: " + response);
    
    // Close the socket connection
    socket.close();
  }
}
