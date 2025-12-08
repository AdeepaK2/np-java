package URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.HttpURLConnection;

public class Connection {

  public static void main(String[] args) throws IOException {
    // === READ DATA (GET Request) ===
    System.out.println("=== GET Request ===");
    URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.connect();

    System.out.println("Response Code: " + conn.getResponseCode());
    
    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
    reader.close();
    conn.disconnect();

    // === WRITE DATA (POST Request) ===
    System.out.println("\n=== POST Request ===");
    URL postUrl = new URL("https://jsonplaceholder.typicode.com/posts");
    HttpURLConnection postConn = (HttpURLConnection) postUrl.openConnection();
    postConn.setRequestMethod("POST");
    postConn.setRequestProperty("Content-Type", "application/json");
    postConn.setDoOutput(true);

    String jsonData = "{\"title\":\"Hello\",\"body\":\"Test post\",\"userId\":1}";
    OutputStream out = postConn.getOutputStream();
    out.write(jsonData.getBytes());
    out.flush();
    out.close();

    System.out.println("Response Code: " + postConn.getResponseCode());
    
    BufferedReader postReader = new BufferedReader(new InputStreamReader(postConn.getInputStream()));
    while ((line = postReader.readLine()) != null) {
      System.out.println(line);
    }
    postReader.close();
    postConn.disconnect();
  }
  
}
