import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.concurrent.ExecutorService;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;

public class Server {
  static int COUNT = 0;

  public static void main(String[] args) throws IOException {
    // Create a server socket listening on port 8080
    ServerSocket serverSocket = new ServerSocket(8080);
    ExecutorService excutor=Executors.newFixedThreadPool(10);

    while(true){
      Socket  clientScoket=serverSocket.accept();
      System.out.println("new clint connected");

      excutor.submit(new ClientHandler(clientScoket));
    }
  }

}

class ClientHandler implements Runnable {
  private Socket clienSocket;

  public ClientHandler(Socket socket) {
    this.clienSocket = socket;
  }

  public void run(){
    try{
      // Increment COUNT in a thread-safe manner
      synchronized(Server.class) {
        Server.COUNT++;
        System.out.println("Total clients connected: " + Server.COUNT);
      }

      BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
      System.out.println("Client says: " + in.readLine());
      PrintWriter out=new PrintWriter(clienSocket.getOutputStream(),true);
      out.println("Weather is good");
      clienSocket.close();
    }catch( IOException e){
      e.printStackTrace();
    }
  }
}