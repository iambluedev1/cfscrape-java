package fr.iambluedev.cfscrape.core.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse extends ApiDirectResponse {

	private String token;
	private boolean finished;
	
}
