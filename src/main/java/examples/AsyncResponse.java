package examples;

import fr.iambluedev.cfscrape.api.util.Callback;
import fr.iambluedev.cfscrape.core.CfScrape;
import fr.iambluedev.cfscrape.core.model.ApiResponse;

public class AsyncResponse {

	public static void main(String[] args) {
		CfScrape cfScrape = CfScrape.get();
		cfScrape.setUrl("https://kfaction.net/banlist");
		cfScrape.getAsyncResponse(new Callback<ApiResponse>() {
			@Override
			public void call(ApiResponse v) {
				String html = v.getHtml();
				String token = v.getToken();
				String url = v.getUrl();
				
				System.out.println(html);
				System.out.println(token);
				System.out.println(url);
			}
		});
	}

}
