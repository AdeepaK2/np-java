import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;


public class Server {
    private static final String MCAST_GROUP_IP = "230.0.0.0";
    private static final int MCAST_PORT = 4446;
    
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket();
        byte[] buffData = new byte[1024];
        DatagramPacket packetOut = new DatagramPacket(buffData, buffData.length, InetAddress.getByName(MCAST_GROUP_IP), MCAST_PORT);
        
        // Send the packet in 1 second intervals with modified data
        while (true) {
            packetOut.setData(new Date().toString().getBytes());
            System.out.println("sending " + new String(packetOut.getData()));
            serverSocket.send(packetOut);
            Thread.sleep(1000); // 1 second delay
        }
    }
}