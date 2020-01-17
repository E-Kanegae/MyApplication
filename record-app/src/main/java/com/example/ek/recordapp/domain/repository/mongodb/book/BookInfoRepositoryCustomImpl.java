package com.example.ek.recordapp.domain.repository.mongodb.book;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.example.ek.recordapp.domain.bean.book.BookInfo;

/**
 * record-app
 * com.example.ek.recordapp.domain.repository.mongodb.book.BookInfoCustomRepositoryImpl.java
 *
 * TODO ここにクラスの説明を書いてください。
 *
 * @author E-Kanegae
 *
 */
@Repository
public class BookInfoRepositoryCustomImpl implements BookInfoRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	/* (非 Javadoc)
	 * @see com.example.ek.recordapp.domain.repository.book.BookInfoRepositoryCustom#getMaxBookId(java.lang.String)
	 */
	@Override
	public BigInteger getMaxBookId() {
		Query q = new Query().with(Sort.by("id").descending());
		BookInfo result = mongoTemplate.findOne(q, BookInfo.class);
		return ObjectUtils.isEmpty(result) ? BigInteger.ZERO : result.getBookId();
	}

	/* (非 Javadoc)
	 * @see com.example.ek.recordapp.domain.repository.book.BookInfoCustomRepository#getMinActualPrice()
	 */
	@Override
	public Long getMinActualPrice() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}




}
