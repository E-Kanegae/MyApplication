package com.example.ek.booksapi.domain.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.ek.booksapi.domain.BookInfoBuilder;
import com.example.ek.booksapi.domain.BookSearchResult;
import com.example.ek.booksapi.web.BookInfo;

/**
 * books-api
 * com.example.ek.booksapi.domain.google.GoogleBookSearchApiResponseBuilder.java
 *
 * @author E-Kanegae
 *
 */
@Component
public class GoogleBookSearchInfoBuilder implements BookInfoBuilder {

	@Override
	public BookInfo buildEach(BookSearchResult result) {
		return build(result)[0];
	}
	
	@Override
	public BookInfo[] build(BookSearchResult result) {
		GoogleSearchedBookInfo[] searchResult = ((GoogleBookSearchApiResult) result).getItems();
		List<BookInfo> infos = new ArrayList<>();

		for (GoogleSearchedBookInfo searched : searchResult) {
			infos.add(map(searched));
		}

		return (BookInfo[]) infos.toArray(new BookInfo[infos.size()]);
	}

	

	private BookInfo map(GoogleSearchedBookInfo info) {
		VolumeInfo v = info.getVolumeInfo();
		IndustryIdentify[] iis = v.getIndustryIdentifiers();
		String isbn10 = null;
		String isbn13 = null;
		
		if(iis != null) {
			for (IndustryIdentify ii : iis) {
				String identify = ii.getIdentifier().toString();
				if (identify.length() == 10) {
					isbn10 = ii.getIdentifier().toString();
				} else if (identify.length() == 13) {
					isbn13 = ii.getIdentifier().toString();
				}
			}

		}
		
		return BookInfo.builder()
				.isbn10(isbn10)
				.isbn13(isbn13)
				.title(info.getVolumeInfo().getTitle())
				.authors(info.getVolumeInfo().getAuthors())
				.publisher(v.getPublisher())
				.publishedDate(v.getPublishedDate())
				.description(v.getDescription())
				.smallThumbnail(v.getImageLinks().getSmallThumbnail())
				.thumbnail(v.getImageLinks().getThumbnail())
				.categories(v.getCategories())
				.build();
	}


}
