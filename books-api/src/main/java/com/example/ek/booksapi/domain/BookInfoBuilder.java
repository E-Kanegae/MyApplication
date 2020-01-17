package com.example.ek.booksapi.domain;

import com.example.ek.booksapi.web.BookInfo;


/**
 * books-api
 * com.example.ek.booksapi.domain.BookInfoBuilder.java
 *
 * 書籍検索APIは各社が提供しているレスポンスの定義が異なる。
 * そこで各社レスポンス定義に従ったデータを共通的なレスポンス用オブジェクト{@link com.example.ek.booksapi.web.BookInfo}に
 * マッピングさせるためのクラスを本インターフェースを実装することで作成する。
 *
 * @author E-Kanegae
 *
 */
public interface BookInfoBuilder {
	
	BookInfo[] build(BookSearchResult searchResult);
	
	BookInfo buildEach(BookSearchResult searchResult);

}
