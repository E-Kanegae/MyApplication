package com.example.ek.recordapp.web.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.ek.recordapp.domain.service.book.BookInfoSearchResult;

/**
 * record-app
 * com.example.ek.recordapp.web.book.BookInfoHelper.java
 *
 *
 * @author E-Kanegae
 *
 */
@Component
public class BookInfoHelper {

	private static final String DELIMETER = ",";
	
	public List<BookCandidate> searchResults2Candidates(List<BookInfoSearchResult> results){
		List<BookCandidate> mapped = new ArrayList<>(); 
		for(BookInfoSearchResult result : results ) {
			mapped.add(searchResult2Candidate(result));
		}
		return mapped;
	}
	
	public BookCandidate searchResult2Candidate(BookInfoSearchResult result) {
		BookCandidate candidate = new BookCandidate();
		// ISBN
		candidate.setIsbn(StringUtils.hasLength(result.getIsbn10()) ? result.getIsbn10() : result.getIsbn13());
		candidate.setAuthor(array2StringBydelimeter(result.getAuthors()));
		candidate.setTitle(result.getTitle());
		candidate.setPublisher(result.getPublisher());
		// Image Link
		candidate.setImageLink(StringUtils.hasLength(result.getSmallThumbnail()) ? toImgTag(result.getSmallThumbnail()) : toImgTag(result.getThumbnail()));
		return candidate;
	}
	
	private String array2StringBydelimeter(String[] array) {
		if(ObjectUtils.isEmpty(array) && array.length == 0) {
			return null;
		}
		return Arrays.asList(array).stream().collect(Collectors.joining(DELIMETER));
	}
	
	private String toImgTag(String imageLink) {
		
		if(!StringUtils.hasLength(imageLink)){
			return null;
		}
		
		StringBuilder builder = new StringBuilder("<img\n" + 
				"		src=\"");
		builder.append(imageLink);
		builder.append("\" />");
		return builder.toString();
	}

}
