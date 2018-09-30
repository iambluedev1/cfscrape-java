package fr.iambluedev.cfscrape.core.http;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import fr.iambluedev.cfscrape.api.request.IRawRequest;
import fr.iambluedev.cfscrape.core.model.ApiErrorResponse;
import fr.iambluedev.cfscrape.core.model.ApiResponse;
import fr.iambluedev.cfscrape.core.model.ApiTokenResponse;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class RawRequest implements IRawRequest {
  
  private Logger logger = Logger.getLogger("RawRequest");
  
  private ApiTokenResponse response;
  
  public RawRequest (ApiTokenResponse response) {
    this.response = response;
  }
  
  @SneakyThrows
  public ApiResponse raw () {
    
    HttpResponse<String> resp = Unirest.get(this.response.getRawUrl()).asString();
    
    String response = resp.getBody();
    
    try {
      return new Gson().fromJson(response, ApiResponse.class);
    } catch (JsonSyntaxException e) {
      ApiErrorResponse error = new Gson().fromJson(response, ApiErrorResponse.class);
      logger.severe("Error: " + error.getMessage());
    }
    return null;
  }
}
