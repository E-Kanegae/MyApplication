/**
 * 
 */
package com.example.ek.booksapi.domain;


/**
 * books-api
 * com.example.ek.booksapi.domain.google.BooksSearchApiIllegalArgumentException.java
 *
 * TODO クラスファイルの説明を記載してください。
 *
 * @author etsukanegae
 *
 */
public class BooksSearchApiIllegalArgumentException extends Exception {

	private static final long serialVersionUID = -9047183261612222949L;
	
	public BooksSearchApiIllegalArgumentException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BooksSearchApiIllegalArgumentException(final String message) {
        super(message);
    }
	
	

}
