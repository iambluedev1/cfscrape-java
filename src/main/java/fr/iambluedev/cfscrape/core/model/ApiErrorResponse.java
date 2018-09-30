package fr.iambluedev.cfscrape.core.model;

import lombok.Data;

@Data
public class ApiErrorResponse {
  
  private Integer error;
  private String message;
  
}
