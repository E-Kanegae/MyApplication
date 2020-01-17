package com.example.ek.recordapp.domain.service.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ek.recordapp.domain.bean.book.BookInfo;
import com.example.ek.recordapp.domain.repository.mongodb.book.BookInfoRepository;

/**
 * record-app
 * com.example.ek.recordapp.domain.service.book.BookInfoServiceImpl.java
 *
 * TODO ここにクラスの説明を書いてください。
 *
 * @author E-Kanegae
 *
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {

	@Autowired
	private BookInfoRepository repository;
	

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


}
