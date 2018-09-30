package fr.iambluedev.cfscrape.core.model;

import lombok.Data;

@Data
public class ApiResponse extends ApiDirectResponse {
  
  private String token;
  private boolean finished;
  
}
