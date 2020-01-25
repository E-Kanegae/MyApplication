package com.example.ek.recordapp.domain.service.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * record-app
 * com.example.ek.recordapp.domain.service.book.BookInfoSearchResult.java
 *
 * TODO クラスファイルの説明を記載してください。
 *
 * @author E-Kanegae
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BookInfoSearchResult {


	private String isbn10;
	
	private String isbn13;
	
	private String title;
	
	private String[] authors;
	
	private String publisher;
	
	private String publishedDate;
	
	private String description;
	
	private String smallThumbnail;

	private String thumbnail;

	private String[] categories;
}
