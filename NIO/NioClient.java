import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {
  public static void main(String[] args) throws IOException {
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
      buffer.clear();
    }else if(bytes==-1){
      socket.close();
      System.out.println("Connection closed from server end");
    }
    //writing data to  channel

  }
}
