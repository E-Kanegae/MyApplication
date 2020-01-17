package com.example.ek.booksapi.domain.google;

import com.example.ek.booksapi.domain.BookSearchResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * books-api
 * com.example.ek.booksapi.domain.google.GoogleBookSearchApiResult.java
 *
 * @author E-Kanegae
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class GoogleBookSearchApiResult extends BookSearchResult {

	private String kind;

	private Integer totalItems;

	private GoogleSearchedBookInfo[] items;

}
