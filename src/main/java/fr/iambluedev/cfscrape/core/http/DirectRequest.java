package fr.iambluedev.cfscrape.core.http;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import fr.iambluedev.cfscrape.api.request.IDirectRequest;
import fr.iambluedev.cfscrape.core.CfScrape;
import fr.iambluedev.cfscrape.core.model.ApiDirectResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@AllArgsConstructor
public class DirectRequest implements IDirectRequest {
  
  private String url;
  
  @SneakyThrows
  public ApiDirectResponse getResponse () {
    
    HttpResponse<String> resp = Unirest.post(CfScrape.get().getApiHost() + "/wait").field("url", CfScrape.get().getUrl()).asString();
    
    return new Gson().fromJson(resp.getBody(), ApiDirectResponse.class);
  }
}
