package fr.iambluedev.cfscrape.core.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorResponse {

	private Integer error;
	private String message;
	
}
