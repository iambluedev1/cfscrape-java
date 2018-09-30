package examples;

import fr.iambluedev.cfscrape.core.CfScrape;

public class AsyncHtml {
  
  public static void main (String[] args) {
    CfScrape cfScrape = CfScrape.get();
    cfScrape.setUrl("https://www.mc-market.org");
    cfScrape.getAsyncHtml(System.out::println);
  }
  
}
