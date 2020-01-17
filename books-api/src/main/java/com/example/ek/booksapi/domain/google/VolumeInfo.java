package com.example.ek.booksapi.domain.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * books-api
 * com.example.ek.booksapi.domain.VolumeInfo.java
 *
 * @author E-Kanegae
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class VolumeInfo {
	
	private String title;
	
	private String[] authors;
	
	private String publisher;

	private String publishedDate;

	private String description;

	private IndustryIdentify[] industryIdentifiers;	

	private Integer pageCount;

	private String[] categories;

	private ImageLinks imageLinks;

	private String lang;

	private String webReaderLink;

}
