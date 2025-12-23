import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;


public class Server {
    private static final String MCAST_GROUP_IP = "230.0.0.0";
    private static final int MCAST_PORT = 4446;
    
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket=new DatagramSocket();

        byte[] buffer=new byte[1024];
        DatagramPacket packet=new DatagramPacket(buffer,buffer.length, InetAddress.getByName(MCAST_GROUP_IP),MCAST_PORT);

        while(true){
            packet.setData(new Date().toString().getBytes());
            serverSocket.send(packet);
            Thread.sleep(1000);
        }
    }
}