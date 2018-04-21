package fr.iambluedev.cfscrape.core.http;

import java.util.HashMap;
import java.util.Map;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;

import fr.iambluedev.cfscrape.api.request.IDirectRequest;
import fr.iambluedev.cfscrape.core.CfScrape;
import fr.iambluedev.cfscrape.core.model.ApiDirectResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DirectRequest implements IDirectRequest {

	private String url;
	
	public ApiDirectResponse getResponse(){
		HttpRequest request = HttpRequest.post(CfScrape.get().getApiHost() + "/wait");
		request.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
		request.followRedirects(true);
		request.trustAllCerts();
		request.trustAllHosts();
		request.acceptGzipEncoding().uncompress(true);
		request.connectTimeout(6000);
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", this.url);
		request.form(data);
		
		String response = request.body();
		
		ApiDirectResponse tmp = new Gson().fromJson(response, ApiDirectResponse.class);
		return tmp;
	}
}
