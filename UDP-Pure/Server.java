import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class Server {
  public static void main(String[] args) throws IOException{
    DatagramSocket serverSocket=new DatagramSocket(5000);

    byte[] buffer=new byte[256];
    DatagramPacket packet=new DatagramPacket(buffer, buffer.length);
    serverSocket.receive(packet);

    String msg=new String(packet.getData(),0,packet.getLength());
    System.out.println(msg);


    String reply="Hi from Server";
    byte[] replyData=reply.getBytes();
    DatagramPacket outPacket=new DatagramPacket(replyData,replyData.length,packet.getAddress(),packet.getPort());
    serverSocket.send(outPacket);

    serverSocket.close();
  }

}
