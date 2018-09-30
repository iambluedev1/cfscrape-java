package examples;

import fr.iambluedev.cfscrape.core.CfScrape;
import fr.iambluedev.cfscrape.core.model.ApiDirectResponse;

public class SyncResponse {
  
  public static void main (String[] args) {
    CfScrape cfScrape = CfScrape.get();
    cfScrape.setUrl("https://www.mc-market.org");
    ApiDirectResponse response = cfScrape.getSyncResponse();
    String html = response.getHtml();
    String url = response.getUrl();
    
    System.out.println(html);
    System.out.println(url);
  }
  
}
