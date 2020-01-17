package com.example.ek.recordapp.domain.service.book;

import java.util.List;

import com.example.ek.recordapp.domain.bean.book.BookInfo;

/**
 * record-app
 * com.example.ek.recordapp.domain.service.book.BookInfoService.java
 *
 * TODO ここにクラスの説明を書いてください。
 *
 * @author E-Kanegae
 *
 */
public interface BookInfoService {

	List<BookInfo> listAll();

	void create(BookInfo bookInfo);

}
