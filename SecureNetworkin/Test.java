import java.net.Inet4Address;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

class Nio{
  public static void main(String[] args) {
    SocketChannel socket=SocketChannel.open();
    socket.configureBlocking(false);
    InetSocketAddress addr=new InetSocketAddress("localhost",5000);
    socket.connect(addr);

    ByteBuffer buffer=ByteBuffer.allocate(1024);
    int bytes=socket.read(buffer);
    if(bytes>0){
      buffer.flip();
      byte[] data=new byte[bytes];
      buffer.get(data);
      System.out.println(new String(data));
      buffer.clear()
    }

  }
}