package fr.iambluedev.cfscrape.core.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiTokenResponse {

	private String token;
	private Long startedAt;
	private Long refreshAt;
	private Integer estimatedTime;
	private String rawUrl;
	
}
