import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class HttpPost{
  HttpClient client=HttpClient.newHttpClient();
  String jsonPayload="{\user:\}"
  HttpRequest request=HttpRequest.newBuilder()
    .uri(URI.create("http://localhost:300.com"))
    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
    .header("Content-Type","application/json")
    .build();

  HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());

  if(resposne.getSatusCode()==201){
    //created
  }else{
    //error
  }
}