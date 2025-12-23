import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class Consume{
  public static void main(String[] args) {
    HttpClient client=HttpClient.newHttpClient();
    HttpRequest request=HttpRequest.newBuilder(URI.create("hhtps://localhost:5000")).build();
    HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
    if(response.statusCode()==200){
      String responseBody=response.body();
      ObjectMapper objMapper=new ObjectMapper();
      User user=objMapper.readValue(responseBody,User.class);
    
  }
}