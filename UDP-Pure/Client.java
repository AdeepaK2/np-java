import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.io.IOException;

public class Client {
  public static void main(String[] args) throws IOException {
    DatagramSocket clientSocket=new DatagramSocket();
    String message="Client says: Weather was bad";
    byte[] data=message.getBytes();
    DatagramPacket packet=new DatagramPacket(data,data.length,InetAddress.getByName("localhost"),8080);
    clientSocket.send(packet);

    clientSocket.setSoTimeout(5000);

    byte[] recive=new byte[256];
    DatagramPacket recievedPacket=new DatagramPacket(recive, recive.length);
    clientSocket.receive(recievedPacket);
    String response=new String(recievedPacket.getData(),0,recievedPacket.getLength());
    System.out.println(response);
    clientSocket.close();

  }
}
