package examples;

import fr.iambluedev.cfscrape.core.CfScrape;

public class SyncHtml {

	public static void main(String[] args) {
		CfScrape cfScrape = CfScrape.get();
		cfScrape.setUrl("https://www.mc-market.org");
		String html = cfScrape.getSyncHtml();
		
		System.out.println(html);
	}
	
}
