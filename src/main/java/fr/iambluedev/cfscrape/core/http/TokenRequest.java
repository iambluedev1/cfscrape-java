package fr.iambluedev.cfscrape.core.http;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import fr.iambluedev.cfscrape.api.request.ITokenRequest;
import fr.iambluedev.cfscrape.core.CfScrape;
import fr.iambluedev.cfscrape.core.model.ApiTokenResponse;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class TokenRequest implements ITokenRequest {
  
  private Logger logger = Logger.getLogger("TokenRequest");
  
  private String url;
  
  public TokenRequest (String url) {
    this.url = url;
  }
  
  @SneakyThrows
  public ApiTokenResponse getResponse () {
    HttpResponse<String> resp = Unirest.post(CfScrape.get().getApiHost() + "/get").field("url", CfScrape.get().getUrl()).asString();
    
    return new Gson().fromJson(resp.getBody(), ApiTokenResponse.class);
  }
}
