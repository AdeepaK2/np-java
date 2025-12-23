import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class Client {

  private static final String MCAST_GROUP_IP = "230.0.0.0";
  private static final int MCAST_PORT = 4446;
  public static void main(String[] args) throws SocketException,IOException {
    MulticastSocket socket=new MulticastSocket(MCAST_PORT);
    socket.joinGroup(MCAST_GROUP_IP);
    

  }
}
