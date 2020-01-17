package com.example.ek.booksapi.domain;


import org.springframework.web.client.RestClientException;

import com.example.ek.booksapi.web.BookInfo;


/**
 * books-api com.example.ek.booksapi.domain.BooksApiService.java
 *
 * 書籍検索APIを呼び出し、処理するためのServiceインターフェース
 *
 * @author E-Kanegae
 *
 */
public interface BooksApiService {

	/**
	 * キーワードを検索条件にセットして、ヒット件数を返却する処理
	 * 
	 * @param condition 検索のキーワードとなる文字
	 * @return 検索結果件数
	 * @throws BooksSearchApiIllegalArgumentException
	 * @throws RestClientException
	 *
	 */
	Integer countSearchResult(BookSearchCondition condition)
			throws RestClientException, BooksSearchApiIllegalArgumentException;

	/**
	 * 書籍情報を全件返す。
	 * 
	 * @param condition 検索のキーワードとなる文字
	 * @return {@link com.example.ek.booksapi.web.BookInfo}
	 * @throws BooksSearchApiIllegalArgumentException
	 * @throws RestClientException
	 *
	 */
	BookInfo[] findAll(BookSearchCondition condition)
			throws RestClientException, BooksSearchApiIllegalArgumentException;
	
	/**
	 * 書籍情報を1件返す。
	 * @param condition 検索のキーワードとなる文字
	 * @return {@link com.example.ek.booksapi.web.BookInfo}
	 * @throws BooksSearchApiIllegalArgumentException 
	 * @throws RestClientException 
	 *
	 */
	BookInfo findOne(BookSearchCondition condition) throws RestClientException, BooksSearchApiIllegalArgumentException;

}
