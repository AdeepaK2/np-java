import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioEchoServer {

    public static void main(String[] args) throws IOException {

        /* =========================================================
           1. OPEN SERVER SOCKET CHANNEL (SERVER SIDE)
           ========================================================= */

        // Create a ServerSocketChannel (used only by servers)
        ServerSocketChannel serverChannel=ServerSocketChannel.open();

        // IMPORTANT: Set non-blocking mode (required for Selector)
        serverChannel.configureBlocking(false);

        // Bind server to port 5000
        serverChannel.bind(new InetSocketAddress(5000));

        System.out.println("Server started on port 5000");

        /* =========================================================
           2. OPEN SELECTOR
           ========================================================= */

        // Selector monitors multiple channels with one thread
        Selector selector = Selector.open();

        // Register server channel with selector for ACCEPT events
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        /* =========================================================
           3. MAIN SERVER LOOP
           ========================================================= */

        while (true) {

            // BLOCKS until at least one channel is ready
            selector.select();

            // Get the set of keys whose channels are ready
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();

            /* =====================================================
               4. PROCESS READY EVENTS
               ===================================================== */

            while (iterator.hasNext()) {

                SelectionKey key = iterator.next();

                /* -----------------------------------------------
                   A. ACCEPT NEW CLIENT CONNECTION
                   ----------------------------------------------- */
                if (key.isAcceptable()) {

                    // ServerSocketChannel that accepted the connection
                    ServerSocketChannel srvChannel =
                            (ServerSocketChannel) key.channel();

                    // Accept the client connection
                    SocketChannel clientChannel = srvChannel.accept();

                    // Set client channel to non-blocking
                    clientChannel.configureBlocking(false);

                    // Register client for READ events
                    clientChannel.register(selector, SelectionKey.OP_READ);

                    System.out.println("Client connected: "
                            + clientChannel.getRemoteAddress());
                }

                /* -----------------------------------------------
                   B. READ DATA FROM CLIENT & ECHO BACK
                   ----------------------------------------------- */
                else if (key.isReadable()) {

                    // Get the client channel
                    SocketChannel clientChannel =
                            (SocketChannel) key.channel();

                    // Allocate buffer for reading data
                    ByteBuffer buffer = ByteBuffer.allocate(256);

                    // Read data from client
                    int bytesRead = clientChannel.read(buffer);

                    /* ---- Case 1: Data received ---- */
                    if (bytesRead > 0) {

                        // Switch buffer from write mode to read mode
                        buffer.flip();

                        // Echo data back to client
                        clientChannel.write(buffer);

                        // Clear buffer for next read
                        buffer.clear();
                    }

                    /* ---- Case 2: Client closed connection ---- */
                    else if (bytesRead == -1) {

                        System.out.println("Client disconnected: "
                                + clientChannel.getRemoteAddress());

                        clientChannel.close();
                    }
                }

                // VERY IMPORTANT: remove key after processing
                iterator.remove();
            }
        }
    }
}
