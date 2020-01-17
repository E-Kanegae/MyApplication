package com.example.ek.recordapp.domain.repository.mongodb.book;

import java.math.BigInteger;

/**
 * <pre>
 * record-app
 * com.example.ek.recordapp.domain.repository.mongodb.book.BookInfoCustomRepository.java
 *
 * {@link org.springframework.data.mongodb.repository.MongoRepository<BookInfo, Long>}では
 * サポートしていないメソッドを定義するカスタムリポジトリ
 * </pre>
 * @author E-Kanegae
 *
 */
public interface BookInfoRepositoryCustom {

	/**
	 * <pre>
	 * 登録してある書籍情報のmaxIdを返却する。
	 * </pre>
	 * @return Long BookIndo.Id
	 */
	public BigInteger getMaxBookId();

	public Long getMinActualPrice();

}
