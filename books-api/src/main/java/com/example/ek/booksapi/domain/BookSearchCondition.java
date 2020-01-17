package com.example.ek.booksapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * books-api com.example.ek.booksapi.domain.BookSearchCondition.java
 *
 * 書籍検索APIの条件の基底クラス
 * 
 * @author E-Kanegae
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BookSearchCondition {

	private String isbn;
	private String title;
	private String author;

}
