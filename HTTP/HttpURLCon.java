package HTTP;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLCon {
  public static void main(String[] args) throws Exception {
    URL url=new URL("https://jsonplaceholder.typicode.com/posts");
    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    int responseCode=conn.getResponseCode();
    System.out.println("Response Code: " + responseCode);
  }
  
}
