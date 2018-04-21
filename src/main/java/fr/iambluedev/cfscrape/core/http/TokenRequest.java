package fr.iambluedev.cfscrape.core.http;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

import fr.iambluedev.cfscrape.api.request.ITokenRequest;
import fr.iambluedev.cfscrape.core.CfScrape;
import fr.iambluedev.cfscrape.core.model.ApiTokenResponse;
import lombok.Getter;

@Getter
public class TokenRequest implements ITokenRequest {

	private Logger logger = Logger.getLogger("TokenRequest");
	
	private String url;
	
	public TokenRequest(String url) {
		this.url = url;
	}
	
	public ApiTokenResponse getResponse(){
		HttpRequest request = HttpRequest.post(CfScrape.get().getApiHost() + "/get");
		request.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
		request.followRedirects(true);
		request.trustAllCerts();
		request.trustAllHosts();
		request.acceptGzipEncoding().uncompress(true);
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", this.url);
		request.form(data);
		
		String response = request.body();
		
		logger.info(response);
		
		ApiTokenResponse tmp = new Gson().fromJson(response, ApiTokenResponse.class);
		return tmp;
	}
}
