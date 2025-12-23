import java.net.MalformedURLException;
import java.net.URL;

class Example{
  public static void main(String[] args) {
    String urlString= "https://example.com/api/data";
    try{
      URL url=new URL(urlString);
      System.out.println("URL is valid: " + url.toString());
    }catch(MalformedURLException e){
      System.out.println("Invalid URL: " + urlString);
    }finally{
      System.out.println("URL validation completed.");
    }

  }
}


class Server{
  public static void main(String[] args) throws IOException {
    DatagramSocket serverScoekt=new DatagramSocket(9090);
    byte[] buffer =new byte[512];
    DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
    serverScoekt.receive(packet);
    String recivedMsg=new String(paclet.getData(,0,packe.getLength());
    String upperCaseMss=recivedMsg.toUpperCase();
    byte[] outData=new byte[512];
    outData=upperCaseMss.getBytes();

    DatagramPacket outPacket=new DatagramPacket(outData,out.length,packet.getAddress,packet.getPort);
    serverSocket.send(outPacket);
    serverScoekt.close();
  }
}