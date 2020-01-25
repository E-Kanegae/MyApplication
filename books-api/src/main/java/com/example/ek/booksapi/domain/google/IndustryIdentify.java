package com.example.ek.booksapi.domain.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * books-api
 * com.example.ek.booksapi.domain.IndustryIdentify.java
 *
 * @author E-Kanegae
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class IndustryIdentify {
	
	private String type;
	
	private String identifier;

}
