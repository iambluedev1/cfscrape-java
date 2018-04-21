package fr.iambluedev.cfscrape.core.http;

import java.util.logging.Logger;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import fr.iambluedev.cfscrape.api.request.IRawRequest;
import fr.iambluedev.cfscrape.core.model.ApiErrorResponse;
import fr.iambluedev.cfscrape.core.model.ApiResponse;
import fr.iambluedev.cfscrape.core.model.ApiTokenResponse;
import lombok.Getter;

@Getter
public class RawRequest implements IRawRequest {

	private Logger logger = Logger.getLogger("RawRequest");
	
	private ApiTokenResponse response;
	
	public RawRequest(ApiTokenResponse response) {
		this.response = response;
	}
	
	public ApiResponse raw(){
		HttpRequest request = HttpRequest.get(this.response.getRawUrl());
		request.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
		request.followRedirects(true);
		request.trustAllCerts();
		request.trustAllHosts();
		request.acceptGzipEncoding().uncompress(true);
		
		String response = request.body();
		
		try {
			ApiResponse api = new Gson().fromJson(response, ApiResponse.class);
			return api;
		} catch(JsonSyntaxException e){
			ApiErrorResponse error = new Gson().fromJson(response, ApiErrorResponse.class);
			logger.severe("Error: " + error.getMessage());
		}
		return null;
	}
}
