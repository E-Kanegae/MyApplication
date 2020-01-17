package com.example.ek.booksapi.domain.google;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.ek.booksapi.domain.BookInfoBuilder;
import com.example.ek.booksapi.domain.BookSearchCondition;
import com.example.ek.booksapi.domain.BooksApiService;
import com.example.ek.booksapi.domain.BooksSearchApiIllegalArgumentException;
import com.example.ek.booksapi.web.BookInfo;

/**
 * books-api
 * com.example.ek.booksapi.domain.google.GoogleBooksApiServiceImpl.java
 *
 * Google Books APIを呼び出して処理するServiceクラス
 *
 * @author E-Kanegae
 *
 */
@Service
public class GoogleBooksApiServiceImpl implements BooksApiService {

	private static final Logger log = LoggerFactory.getLogger(GoogleBooksApiServiceImpl.class);

	@Value("${booksapi.google.url}")
	private String GOOGLE_URL;

	private static final String ADD_PARAM = "+";
	private static final String ADD_PARAM_EQUAL = ":";
	private static final String DOUBLE_QUOTE = "\"";

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	BookInfoBuilder responseBuilder;

	@Override
	public Integer countSearchResult(BookSearchCondition condition)
			throws RestClientException, BooksSearchApiIllegalArgumentException {
		return restTemplate
				.getForObject(constructQuery((GoogleBookSearchApiCondition) condition), GoogleBookSearchApiResult.class)
				.getTotalItems();
	}

	@Override
	public BookInfo findOne(BookSearchCondition condition)
			throws RestClientException, BooksSearchApiIllegalArgumentException {
		if (isIllegalArgument(((GoogleBookSearchApiCondition) condition).getIsbn())) {
			log.error("isbn parameter must not be null.");
			throw new BooksSearchApiIllegalArgumentException("isbn parameter must not be null.");
		}
		return responseBuilder.buildEach((find((GoogleBookSearchApiCondition) condition)));
	}

	@Override
	public BookInfo[] findAll(BookSearchCondition condition)
			throws RestClientException, BooksSearchApiIllegalArgumentException {
		
		return responseBuilder.build(((GoogleBookSearchApiResult) find((GoogleBookSearchApiCondition) condition)));
	}

	private GoogleBookSearchApiResult find(GoogleBookSearchApiCondition condition)
			throws RestClientException, BooksSearchApiIllegalArgumentException {
		return restTemplate.getForObject(constructQuery(condition), GoogleBookSearchApiResult.class);
	}

	/**
	 * パラメータを渡してRestTemplateに渡すクエリを作成する。
	 * 
	 * @param cond
	 * @return クエリ文字列
	 * @throws BooksSearchApiIllegalArgumentException
	 *
	 */
	private String constructQuery(GoogleBookSearchApiCondition cond) throws BooksSearchApiIllegalArgumentException {
		GoogleBookSearchApiCondition gcond = (GoogleBookSearchApiCondition) cond;
		String intitle = gcond.getTitle();
		String inauthor = gcond.getAuthor();
		String isbn = gcond.getIsbn();
		String inpublisher = gcond.getInpublisher();
		if (isIllegalArgument(intitle, inauthor, isbn, inpublisher)) {
			log.error("all parameters must not be null.");
			throw new BooksSearchApiIllegalArgumentException("all parameters must not be null.");
		}

		StringBuilder builder = new StringBuilder();
		builder.append(GOOGLE_URL);

		if (StringUtils.hasLength(intitle)) {
			builder.append(ADD_PARAM + "intitle" + ADD_PARAM_EQUAL + DOUBLE_QUOTE + intitle + DOUBLE_QUOTE);
		}

		if (StringUtils.hasLength(inauthor)) {
			builder.append(ADD_PARAM + "inauthor" + ADD_PARAM_EQUAL + DOUBLE_QUOTE + inauthor + DOUBLE_QUOTE);
		}

		if (StringUtils.hasLength(isbn)) {
			builder.append(ADD_PARAM + "isbn" + ADD_PARAM_EQUAL + isbn);
		}

		if (StringUtils.hasLength(inpublisher)) {
			builder.append(ADD_PARAM + "inpublisher" + ADD_PARAM_EQUAL + DOUBLE_QUOTE + intitle + DOUBLE_QUOTE);
		}

		return builder.toString();

	}

	/**
	 * パラメータが全てNullの場合、true（引数規約違反）
	 * 
	 * @param args
	 * @return boolean
	 *
	 */
	private boolean isIllegalArgument(String... args) {
		for (String arg : args) {
			if (StringUtils.hasLength(arg)) { // 一度でもfalseの(パラメータに値がある)場合はfalseを返す
				return false;
			}
		}
		return true;
	}

}
