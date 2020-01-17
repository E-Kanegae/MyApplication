package com.example.ek.booksapi.domain;

/**
 * books-api com.example.ek.booksapi.domain.BookSearchConditionBuilder.java
 *
 * @author E-Kanegae
 *
 */
public class BookSearchConditionBuilder< T extends BookSearchCondition> {

	private T cond;

	public BookSearchConditionBuilder(T cond) {
		this.cond = cond;
	}

	public BookSearchConditionBuilder<T> isbn(String isbn) {
		this.cond.setIsbn(isbn);
		return this;
	}

	public BookSearchConditionBuilder<T> title(String title) {
		this.cond.setTitle(title);
		return this;
	}

	public BookSearchConditionBuilder<T> author(String author) {
		this.cond.setAuthor(author);
		return this;
	}

	public T build() {
		return this.cond;
	};

}
