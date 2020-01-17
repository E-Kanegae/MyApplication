package com.example.ek.recordapp.domain.repository.mongodb.book;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.ek.recordapp.domain.bean.book.BookInfo;

/**
 * record-app
 * com.example.ek.recordapp.domain.repository.mongodb.book.BookInfoRepository.java
 *
 * TODO ここにクラスの説明を書いてください。
 *
 * @author E-Kanegae
 *
 */
public interface BookInfoRepository extends MongoRepository<BookInfo, Long>, BookInfoRepositoryCustom {

}
