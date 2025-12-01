import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class Client {

  private static final String MCAST_GROUP_IP = "230.0.0.0";
  private static final int MCAST_PORT = 4446;
  public static void main(String[] args) throws SocketException,IOException {
    MulticastSocket clientSocket=new MulticastSocket(MCAST_PORT);
    clientSocket.joinGroup(InetAddress.getByName(MCAST_GROUP_IP));
    byte[]  buffData=new byte[1024];
    DatagramPacket packetIn=new DatagramPacket(buffData, buffData.length);

    clientSocket.receive(packetIn);
    String receivedData=new String(packetIn.getData(),0,packetIn.getLength());
    System.out.println("Received data: " + receivedData);

    clientSocket.leaveGroup(InetAddress.getByName(MCAST_GROUP_IP));
    clientSocket.close();
  }
}
