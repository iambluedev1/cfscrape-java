package examples;

import fr.iambluedev.cfscrape.core.CfScrape;

public class AsyncResponse {
  
  public static void main (String[] args) {
    CfScrape cfScrape = CfScrape.get();
    cfScrape.setUrl("https://www.mc-market.org");
    cfScrape.getAsyncResponse(v -> {
      String html = v.getHtml();
      String token = v.getToken();
      String url = v.getUrl();
      
      System.out.println(html);
      System.out.println(token);
      System.out.println(url);
    });
  }
  
}
