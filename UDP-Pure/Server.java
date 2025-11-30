import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class Server {
  public static void main(String[] args) throws IOException{
    DatagramSocket serverSocket=new DatagramSocket(8080);
    byte[] buffer=new byte[256];
    DatagramPacket  packet=new DatagramPacket(buffer,buffer.length);
    serverSocket.receive(packet);
    String recieved=new String(packet.getData(),0,packet.getLength());
    System.out.println("Client says: " + recieved);

    String response="Server says: Weather is good";
    byte[] responseData=response.getBytes();
    DatagramPacket responsePacket=new DatagramPacket(responseData,responseData.length,packet.getAddress(),packet.getPort());
    serverSocket.send(responsePacket);

  }

}
