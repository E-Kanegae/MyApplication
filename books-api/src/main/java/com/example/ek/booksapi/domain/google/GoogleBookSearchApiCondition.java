package com.example.ek.booksapi.domain.google;

import com.example.ek.booksapi.domain.BookSearchCondition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * books-api
 * com.example.ek.booksapi.domain.google.GoogleBookSearchApiCondition.java
 *
 * Googleの書籍検索APIを呼び出すためのパラメータ郡を定義したオブジェクト
 *
 * @author E-Kanegea
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoogleBookSearchApiCondition extends BookSearchCondition {

	/**
	 * このキーワードに続くテキストがパブリッシャーで見つかった結果を返します。
	 */
	private String inpublisher;

	/**
	 * このキーワードに続くテキストがボリュームのカテゴリリストにリストされている結果を返します。
	 */
	private String subject;
	
	/**
	 * コレクション内の開始位置。最初のアイテムのインデックスは0です。
	 */
	private String startIndex;
	
	/**
	 * 返される結果の最大数。<br>
	 * このフィールドに何も設定しないでクエリを発行した場合はデフォルトは10で、最大許容値は40です。
	 */
	private String maxResults;

}
