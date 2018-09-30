package fr.iambluedev.cfscrape.api.future;

import fr.iambluedev.cfscrape.api.util.Callback;
import fr.iambluedev.cfscrape.core.model.ApiResponse;

public interface ICallable {
  
  void get (Callback<ApiResponse> callback);
  
  void get (Callback<String> callback, boolean onlyHtml);
  
}
