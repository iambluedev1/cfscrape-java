package fr.iambluedev.cfscrape.core;

import com.mashape.unirest.http.Unirest;
import fr.iambluedev.cfscrape.api.IScrape;
import fr.iambluedev.cfscrape.api.util.Callback;
import fr.iambluedev.cfscrape.core.future.ApiCallable;
import fr.iambluedev.cfscrape.core.http.DirectRequest;
import fr.iambluedev.cfscrape.core.model.ApiDirectResponse;
import fr.iambluedev.cfscrape.core.model.ApiResponse;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CfScrape implements IScrape {
  
  private static CfScrape instance;
  private Logger logger = Logger.getLogger("CfScrape");
  private String apiHost;
  private String url;
  
  {
    Unirest.setDefaultHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
    System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF:%1$tT] [%2$s] %4$s %5$s%6$s%n");
  }
  
  public CfScrape () {}
  
  public CfScrape (String url) {
    logger.info("Url setted to " + url);
    this.url = url;
  }
  
  public static CfScrape get () {
    if (instance == null) {
      instance = new CfScrape();
      instance.setApiHost("http://127.0.0.1:8888");
    }
    
    return instance;
  }
  
  public void setUrl (String url) {
    logger.info("Url setted to " + url);
    this.url = url;
  }
  
  public void getAsyncHtml (Callback<String> callback) {
    logger.info("Start asynchrone task");
    new ApiCallable(url).get(callback, true);
  }
  
  public void getAsyncResponse (Callback<ApiResponse> callback) {
    logger.info("Start asynchrone task");
    new ApiCallable(url).get(callback);
  }
  
  @Override
  public String getSyncHtml () {
    logger.info("Start synchrone task");
    return new DirectRequest(getUrl()).getResponse().getHtml();
  }
  
  @Override
  public ApiDirectResponse getSyncResponse () {
    logger.info("Start synchrone task");
    return new DirectRequest(getUrl()).getResponse();
  }
}
