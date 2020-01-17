package com.example.ek.recordapp.domain.service.book;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.ek.recordapp.domain.bean.book.BookInfo;

/**
 * {@link com.example.ek.recordapp.domain.service.book.BookInfoService}のUTクラス
 * @author E-Kanegae
 */
@SpringJUnitConfig
@SpringBootTest
@ActiveProfiles("dev")
public class BookInfoServiceTest {
	
	@Autowired
	private BookInfoService service;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@BeforeEach
	public void setUp() {
		
	}

	/**
	 * 全項目に値を入れてドキュメントをcreateするテストケース
	 */
	@Test
	public void testCreateSuccessAllColumnsHaveValue() {
		BookInfo param = setUpBookInfoAllColumnsHaveValue();
		service.create(param);
		
		// 結果確認
		List<BookInfo> list = mongoTemplate.find(new Query(), BookInfo.class, "Book_Info");

		assertEquals(1, list.size());
		assertTrue(new ReflectionEquals(param).matches(list.get(0)));
	}
	
	/**
	 * 必須項目にのみ値を入れてドキュメントをcreateするテストケース
	 */
	@Test
	public void testCreateSuccessOnlyMandatoryColumnsHaveValue() {
		BookInfo param = setUpBookInfoOnlyMandatoryColumns();
		service.create(param);
		
		// 結果確認
		List<BookInfo> list = mongoTemplate.find(new Query(), BookInfo.class, "Book_Info");

		assertEquals(1, list.size());
		assertTrue(new ReflectionEquals(param).matches(list.get(0)));
	}
	
	
	/**
	 * Book_Infoコレクションを空にする。
	 */
	@AfterEach
	public void removeInsertData() {
		mongoTemplate.findAllAndRemove(new Query(), BookInfo.class, "Book_Info");
	}
	
	
	private BookInfo setUpBookInfoAllColumnsHaveValue() {
		return BookInfo.builder()
				.bookId(BigInteger.ONE)
				.fullName("父が娘に語る 美しく、深く、壮大で、とんでもなくわかりやすい経済の話。")
				.abbName("父が娘に語る経済話")
				.isbn(9784478105511L)
				.category("経済")
				.author(("ヤニス・バルファキス, 関 美和"))
				.publisher("ダイヤモンド社")
				.points(Double.valueOf("5"))
				.brief("経済の話")
				.cmt("よかった")
				.keywords("余剰")
				.tags("12, 345")
				.bookmark(23)
				.startDate(LocalDate.of(2020, 1, 23))
				.interruptDate(LocalDate.of(2020, 2, 13))
				.restartDate(LocalDate.of(2020, 2, 17))
				.endDate(LocalDate.of(2020, 2, 24))
				.requiredDays(3)
				.purchaseDate(LocalDate.of(2019, 6, 17))
				.price(Long.valueOf("1500"))
				.actualPrice(Long.valueOf("900"))
				.shopName("Amazon")
				.shopUrl("https://www.amazon.co.jp/%E7%88%B6%E3%81%8C%E5%A8%98%E3%81%AB%E8%AA%9E%E3%82%8B-%E7%BE%8E%E3%81%97%E3%81%8F%E3%80%81%E6%B7%B1%E3%81%8F%E3%80%81%E5%A3%AE%E5%A4%A7%E3%81%A7%E3%80%81%E3%81%A8%E3%82%93%E3%81%A7%E3%82%82%E3%81%AA%E3%81%8F%E3%82%8F%E3%81%8B%E3%82%8A%E3%82%84%E3%81%99%E3%81%84%E7%B5%8C%E6%B8%88%E3%81%AE%E8%A9%B1%E3%80%82-%E3%83%A4%E3%83%8B%E3%82%B9%E3%83%BB%E3%83%90%E3%83%AB%E3%83%95%E3%82%A1%E3%82%AD%E3%82%B9/dp/4478105510")
				.build();
				
	}
	
	private BookInfo setUpBookInfoOnlyMandatoryColumns() {
		return BookInfo.builder()
				.bookId(BigInteger.ONE)
				.fullName("父が娘に語る 美しく、深く、壮大で、とんでもなくわかりやすい経済の話。")
				.build();				
	}

}
