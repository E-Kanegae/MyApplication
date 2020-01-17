package com.example.ek.recordapp.web.book;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;


/**
 * record-app
 * com.example.ek.recordapp.web.book.BookInfoForm.java
 *
 * 書籍情報を登録するためのFormクラス
 *
 * @author E-Kanegae
 *
 */
@Getter
@Setter
public class BookInfoForm implements Serializable {

	private Long bookId;
	
	private Long isbn;
	
	@NotNull
	private String category;
	
	@NotNull
	private String fullName;

	@Size(min=1, max = 20)
	private String abbName;

	private String author;
	
	private String publisher;

	private Double points;

	private String brief;
	
	private String cmt;
	
	private String keywords;
	
	private String tags;
	
	private Integer bookmark;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate interruptDate;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate restartDate;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate endDate;
	

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate purchaseDate;
	
	private Integer requiredDays;

	private Long price;

	private Long actualPrice;

	private String shopName;
	
	private String shopUrl;

}
