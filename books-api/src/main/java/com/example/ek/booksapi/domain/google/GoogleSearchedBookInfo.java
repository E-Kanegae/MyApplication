package com.example.ek.booksapi.domain.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * books-api com.example.ek.booksapi.domain.GoogleSearchedBookInfo.java
 *
 * 書籍検索APIを使用した検索結果を格納するオブジェクト
 *
 * @author E-Kanegae
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class GoogleSearchedBookInfo {

	private String kind;

	private String id;

	private String etag;

	private VolumeInfo volumeInfo;

}
