import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.io.PrintWriter; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client{
  public static void main(String[] args)  {
    try{
      Socket socket=new Socket("localhost",5000);
      socket.setSoTimeout(5000);
      PrintWriter out=new PrintWriter(socket.getOutputStream(), true);
      out.println("Client P here");

      BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String msg=in.readLine();
      System.out.println("Received from server: " + msg);
      
      socket.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
