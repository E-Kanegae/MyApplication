package com.example.ek.booksapi.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.ek.booksapi.domain.BooksApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * books-api com.example.ek.booksapi.web.BooksApiControllerTest.java に対するテストクラス
 *
 * @author E-Kanegae
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
// ↓Guideには記載がない(気がする。サンプルにも記載ない)が、Bean登録を明示的にしないとControllerが登録されていなかった。
// @SpringBootTestが勝手にやってくれるんだと思っていた。
@ComponentScan("com.example.ek.booksapi.web") 
class BooksApiControllerTest {
	
	Logger log = LoggerFactory.getLogger(BooksApiControllerTest.class);
	
	@MockBean
	BooksApiService booksApiService;
	
	@Autowired
    private MockMvc mockMvc;

	@Test
	void testGetBookInfoSuccess() throws Exception { 
		// Mockの振る舞いを定義
		when(booksApiService.findOne(any())).thenReturn(createBookInfoData());
		
		// 検証
		mockMvc.perform(
	    		get("/booksapi/getBookInfo")
	    		.param("isbn", "9784798149158")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(bookInfo2Json()))
				.andReturn();

	}

	private String bookInfo2Json() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(createBookInfoData());
	}
	
	private BookInfo createBookInfoData() {
		return BookInfo.builder()
		.isbn10("4798149152")
		.isbn13("9784798149158")
		.title("Spring徹底入門 Spring FrameworkによるJavaアプリケーション開発")
		.authors(new String[] {"株式会社NTTデータ"})
		.publisher("翔泳社")
		.publishedDate("2016-07-20")
		.description("Spring Frameworkの基礎から開発時の指針まで! 定番OSSフレームワークによるJavaシステム開発の入門書! Javaによるアプリケーション開発の定番フレームワークである、Spring Framework。本書は、DI/AOP、データアクセス(JDBC)、JPA(クエリ)といった基本から、MVC、セキュリティ、バッチ、周辺サブプロジェクトまで、Spring Frameworkの機能や使い方、開発時の指針など、Java開発で、このフレームワークを徹底活用するための知識とノウハウを解説します。 これからSpring FrameworkによるJava開発を始める方、機能をもっと使いこなしたい方など、業務システム開発に携わるJavaエンジニアにおすすめの一冊です。 ※本電子書籍は同名出版物を底本として作成しました。記載内容は印刷出版当時のものです。 ※印刷出版再現のため電子書籍としては不要な情報を含んでいる場合があります。 ※印刷出版とは異なる表記・表現の場合があります。予めご了承ください。 ※プレビューにてお手持ちの電子端末での表示状態をご確認の上、商品をお買い求めください。 (翔泳社)")
		.smallThumbnail("http://books.google.com/books/content?id=7TesDAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api")
		.thumbnail("http://books.google.com/books/content?id=7TesDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api")
		.categories(new String[] {"Computers"})
		.build();
	}
	
	

}
