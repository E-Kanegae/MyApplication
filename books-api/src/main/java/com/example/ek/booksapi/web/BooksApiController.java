package com.example.ek.booksapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.example.ek.booksapi.domain.BookSearchConditionBuilder;
import com.example.ek.booksapi.domain.BooksApiService;
import com.example.ek.booksapi.domain.BooksSearchApiIllegalArgumentException;
import com.example.ek.booksapi.domain.google.GoogleBookSearchApiCondition;

/**
 * books-api com.example.ek.booksapi.web.BooksApiController.java
 *
 * 書籍検索APIの取得結果を返却するだけのAPI
 *
 * @author E-Kanegae
 */
@RestController
@RequestMapping("booksapi")
public class BooksApiController {

	@Autowired
	BooksApiService booksApiService;

	@GetMapping(path = "getBookInfo", produces = "application/json", params = "isbn")
	public BookInfo getBookInfo(String isbn) throws RestClientException, BooksSearchApiIllegalArgumentException {
		return booksApiService.findOne(
				new BookSearchConditionBuilder<GoogleBookSearchApiCondition>(new GoogleBookSearchApiCondition())
						.isbn(isbn).build());
	}

	@GetMapping(path = "getBookInfoList", produces = "application/json")
	public BookInfo[] getBookInfoList(@RequestParam(required = true, value = "title") String title,
			@RequestParam(required = false, value = "author") String author,
			@RequestParam(required = false, value = "isbn") String isbn)
			throws RestClientException, BooksSearchApiIllegalArgumentException {

		return booksApiService.findAll(
				new BookSearchConditionBuilder<GoogleBookSearchApiCondition>(new GoogleBookSearchApiCondition())
						.title(title).author(author).isbn(isbn).build());
	}

}
