import java.net.ServerSocket; 
import java.net.Socket;
import java.io.PrintWriter; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Server {
  public static void main(String[] args)  {
    try{
      ServerSocket serverSocket= new ServerSocket(5000);
      System.out.println("Server is listening on port 5000");

      Socket clientSocket=serverSocket.accept();

      BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      String msg=in.readLine();
      System.out.println("Received from client: " + msg);

      PrintWriter out=new PrintWriter(clientSocket.getOutputStream(), true);
      out.println("Hello from Server!");

      clientSocket.close();
      serverSocket.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
}
