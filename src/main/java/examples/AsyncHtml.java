package examples;

import fr.iambluedev.cfscrape.api.util.Callback;
import fr.iambluedev.cfscrape.core.CfScrape;

public class AsyncHtml {

	public static void main(String[] args) {
		CfScrape cfScrape = CfScrape.get();
		cfScrape.setUrl("https://kfaction.net/banlist");
		cfScrape.getAsyncHtml(new Callback<String>() {
			public void call(String html) {
				System.out.println(html);
			}
		});
	}

}
