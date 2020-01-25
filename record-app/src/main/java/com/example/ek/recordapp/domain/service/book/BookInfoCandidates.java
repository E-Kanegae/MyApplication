package com.example.ek.recordapp.domain.service.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * record-app
 * com.example.ek.recordapp.domain.service.book.BookInfoCandidates.java
 *
 * TODO クラスファイルの説明を記載してください。
 *
 * @author E-Kanegae
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BookInfoCandidates {
	
	BookInfoSearchResult[] bookInfoList;

}
