package fr.iambluedev.cfscrape.api;

import fr.iambluedev.cfscrape.api.util.Callback;
import fr.iambluedev.cfscrape.core.model.ApiDirectResponse;
import fr.iambluedev.cfscrape.core.model.ApiResponse;

public interface IScrape {
  
  void setApiHost (String host);
  
  void getAsyncHtml (Callback<String> callback);
  
  void getAsyncResponse (Callback<ApiResponse> callback);
  
  String getSyncHtml ();
  
  ApiDirectResponse getSyncResponse ();
}
