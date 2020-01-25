package com.example.ek.recordapp.domain.service.book;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.ek.recordapp.domain.bean.book.BookInfo;
import com.example.ek.recordapp.domain.repository.mongodb.book.BookInfoRepository;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * record-app
 * com.example.ek.recordapp.domain.service.book.BookInfoServiceImpl.java
 * 
 * @author E-Kanegae
 *
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {

	@Autowired
	private BookInfoRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${booksapi.host}")
	private String booksapiHost;
	@Value("${booksapi.port}")
	private String booksapiPort;
	@Value("${booksapi.scheme}")
	private String booksapiScheme;

	/* (非 Javadoc)
	 * @see com.example.ek.recordapp.domain.service.book.BookInfoService#listAll()
	 */
	@Override
	public List<BookInfo> listAll() {
		return repository.findAll();
	}

	/* (非 Javadoc)
	 * @see com.example.ek.recordapp.domain.service.book.BookInfoService#create(com.example.ek.recordapp.domain.bean.book.BookInfo)
	 */
	@Override
	public void create(BookInfo bookInfo) {
		bookInfo.setBookId(repository.getMaxBookId());
		bookInfo.setCreatedDateTime(bookInfo.getUpdatedDateTime());
		bookInfo.setCreatedBy(bookInfo.getUpdatedBy());
		repository.insert(bookInfo);
	}

	@Override
	public void update(BookInfo bookInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(BigInteger id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BookInfoSearchResult> searchBookInfoCandidate(String isbn, String title, String author) {
		String uri = UriComponentsBuilder.newInstance().scheme(booksapiScheme).host(booksapiHost).port(booksapiPort)
				.path("/booksapi/getBookInfoList/")
				.queryParam("title", title)
				.queryParam("isbn", isbn)
				.queryParam("author", author)
				.toUriString();
		ResponseEntity<BookInfoSearchResult[]> result = restTemplate.getForEntity(uri,BookInfoSearchResult[].class);
//		BookInfoCandidates result = restTemplate.getForObject(uri, );
		return Arrays.asList(result.getBody());
	}

}
