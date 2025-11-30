import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioEacho {
  public static void main(String[] args) throws IOException {
    Selector selector=Selector.open();
    ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
    serverSocketChannel.bind(new InetSocketAddress(8080));
    serverSocketChannel.configureBlocking(false);

    serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
    while(true){
      selector.select();

      Set<SelectionKey> selectionKeys=selector.selectedKeys();
      Iterator<SelectionKey> iterator=selectionKeys.iterator();
      while(iterator.hasNext()){
        SelectionKey selectionKey=iterator.next();
        if(selectionKey.isAcceptable()){
          ServerSocketChannel serverChannel=(ServerSocketChannel)selectionKey.channel();
          SocketChannel socketChannel=serverChannel.accept();
          socketChannel.configureBlocking(false);
          socketChannel.register(selector,SelectionKey.OP_READ);
          System.out.println("New client connected: " + socketChannel.getRemoteAddress());
        }
        else if(selectionKey.isReadable()){
          SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
          ByteBuffer buffer=ByteBuffer.allocate(256);
          int bytesRead=socketChannel.read(buffer);
          if(bytesRead == -1){
            socketChannel.close();
            System.out.println("Client disconnected");
          } else {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
          }
        }
      }
    }
  }
}