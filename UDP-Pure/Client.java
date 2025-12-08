import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.io.IOException;

public class Client {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket=new DatagramSocket();
    String msg="Hello Server from Client";
    socket.setSoTimeout(1000);

    byte[] outBuffer=msg.getBytes();
    DatagramPacket outPacket=new DatagramPacket(outBuffer, outBuffer.length,InetAddress.getByName("localhost") , 5000);
    socket.send(outPacket);

    byte[] inBuffer=new byte[256];
    DatagramPacket inPacket=new DatagramPacket(inBuffer,inBuffer.length );
    socket.receive(inPacket);

    String rmsg=new String(inPacket.getData(),0,inPacket.getLength());
    System.out.println(rmsg);
    
    socket.close();
  }
}
