package com.example.ek.recordapp.config.data_access;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * <pre>
 * {@link com.example.ek.recordapp.config.data_access.MongoDbConfig}
 * の設定を確認するためのテストケース
 * </pre>
 * 
 * @author E-Kanegae
 *
 */
@SpringBootTest
@SpringJUnitConfig
class MongDbConfigTest {

	@Test
	public void bootstrapMongDbConfig() {
		ApplicationContext atx = new AnnotationConfigApplicationContext(MongoDbConfig.class);
		assertThat(atx, is(notNullValue()));
	}

}
