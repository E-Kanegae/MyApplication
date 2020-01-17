package com.example.ek.booksapi.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * books-api
 * com.example.ek.booksapi.web.BookInfo.java

 *
 * @author E-Kanegae
 *
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BookInfo {

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
