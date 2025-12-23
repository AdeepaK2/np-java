package HTTP;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ClientCon {
  public static void main(String[] args) throws Exception {
    HttpClient client=  HttpClient.newHttpClient();
    HttpRequest request=HttpRequest.newBuilder().uri(URI.create("Http")).build();
    HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
  }
}
