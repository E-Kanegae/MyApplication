package com.example.ek.recordapp.domain.bean.book;

import java.math.BigInteger;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.example.ek.recordapp.domain.bean.MongoCollectionDefaultFields;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * record-app
 * com.example.ek.recordapp.domain.data.book.BookInfo.java
 *
 * Book_Infoコレクション用のBeanファイル
 *
 * @author E-Kanegae
 *
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "Book_Info")
public class BookInfo extends MongoCollectionDefaultFields {
	
	public BookInfo(){
		super();
	}
	
	/**
	 * 管理用ID
	 */
	@Id
	@NonNull
	private BigInteger bookId;
	
	/**
	 * ISBN番号
	 */
	@Field(value = "Isbn")
	private Long isbn;
	
	/**
	 * 書籍のジャンル
	 */
	@Field(value = "Category")
	@NonNull
	private String category;

	/**
	 * 正式名称
	 */
	@NonNull
	@Field(value = "Full_Name")
	private String fullName;

	/**
	 * 略
	 */
	@Field(value = "Abbribiation_Name")
	private String abbName;

	/**
	 * 著者名
	 */
	@Field(value = "Author")
	private String author;

	/**
	 * 発行元出版社名
	 */
	@Field(value = "Publisher")
	private String publisher;
	
	/**
	 * 評価ポイント
	 */
	@Field(value = "Points")
	private Double points;

	/**
	 * 書籍の要約
	 */
	@Field(value = "Brief")
	private String brief;
	
	/**
	 * 自分のコメント/感想
	 */
	@Field(value = "Comment")
	private String cmt;
	
	/**
	 * メモしておきたいキーワード
	 */
	@Field(value = "Keywords")
	private String keywords;

	/**
	 * 付箋を貼った（付箋代わり）のページ番号
	 */
	@Field(value = "Tags")
	private String tags;
	
	/**
	 * どこまで読んだか
	 */
	@Field(value = "Bookmark")
	private Integer bookmark;
	
	/**
	 * 読み始めた日
	 */
	@NonNull
	@Field(value = "Start_Date")
	private LocalDate startDate;
	
	/**
	 * 中断した日
	 */
	@Field(value = "Interrupt_Date")
	private LocalDate interruptDate;
	
	/**
	 * 再開した日
	 */	
	@Field(value = "Restart_Date")
	private LocalDate restartDate;
	
	/**
	 * 読み終わった日
	 */
	@Field(value = "End_Date")
	private LocalDate endDate;
	
	/**
	 * 所要日数
	 */
	@Field(value = "Required_Days")
	private Integer requiredDays;
	
	/**
	 * 購入日
	 */
	@Field(value = "Purchase_Date")
	private LocalDate purchaseDate;
	
	/**
	 * 表示金額
	 */
	@Field(value = "Price")
	private Long price;

	/**
	 * 購入額
	 */
	@Field(value = "Actual_Price")
	private Long actualPrice;

	/**
	 * 店舗名称
	 */
	@Field(value = "Shop_Name")
	private String shopName;
	
	/**
	 * 店舗URL
	 */
	@Field(value = "Shop_Url")
	private String shopUrl;

}
