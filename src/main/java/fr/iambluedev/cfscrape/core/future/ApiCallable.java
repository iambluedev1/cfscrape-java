package fr.iambluedev.cfscrape.core.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import fr.iambluedev.cfscrape.api.future.ICallable;
import fr.iambluedev.cfscrape.api.util.Callback;
import fr.iambluedev.cfscrape.core.http.RawRequest;
import fr.iambluedev.cfscrape.core.http.TokenRequest;
import fr.iambluedev.cfscrape.core.model.ApiResponse;
import fr.iambluedev.cfscrape.core.model.ApiTokenResponse;
import lombok.Getter;

@Getter
public class ApiCallable implements Callable<ApiResponse>, ICallable {

	private Logger logger = Logger.getLogger("ApiCallable");
	
	private Integer timeout;
	private String url;
	
	private ApiTokenResponse token;
	private ApiResponse response;
	
	private RawRequest rawRequest;
	
	public ApiCallable(String url) {
		this.token = new TokenRequest(url).getResponse();
		this.timeout = this.token.getEstimatedTime();
		this.rawRequest = new RawRequest(this.token);
	}
	
	public ApiResponse call() throws Exception {
		while(this.response == null){
			Thread.sleep(1);
			if(this.timeout == 0) {
				logger.info("Call timeout !");
				return null;
			}
			if(this.timeout < 200) {
				ApiResponse tmp = this.rawRequest.raw();
				if(tmp != null){
					if(tmp.getHtml() != null) {
						return tmp;
					}
				}
			}
			this.timeout--;
		}
		return this.response;
	}

	public void get(Callback<ApiResponse> callback) {
		ExecutorService threadpool = Executors.newFixedThreadPool(1);
		Future<ApiResponse> future = threadpool.submit(this);
		while (!future.isDone()) {}
		try {
			callback.call(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		threadpool.shutdown();
		future.cancel(true);
	}
	
	public void get(Callback<String> callback, boolean onlyHtml) {
		ExecutorService threadpool = Executors.newFixedThreadPool(1);
		Future<ApiResponse> future = threadpool.submit(this);
		while (!future.isDone()) {}
		try {
			callback.call(future.get().getHtml());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		threadpool.shutdown();
		future.cancel(true);
	}
}
