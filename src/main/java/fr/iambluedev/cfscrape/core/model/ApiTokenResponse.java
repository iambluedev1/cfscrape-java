package fr.iambluedev.cfscrape.core.model;

import lombok.Data;

@Data
public class ApiTokenResponse {
  
  private String token;
  private Long startedAt;
  private Long refreshAt;
  private Integer estimatedTime;
  private String rawUrl;
  
}
