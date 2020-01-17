package com.example.ek.recordapp.config.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

/**
 * record-app
 * com.example.ek.recordapp.config.thymeleaf.ThymeleafConfig.java
 *
 * Thymeleaf関連のJavaConfig
 *
 * @author E-Kanegae
 *
 */
@Configuration
public class ThymeleafConfig {
	
	/**
	 * DateTime API対応
	 * @return　Java8TimeDialect
	 */
	@Bean
	public Java8TimeDialect java8TimeDialect() {
	    return new Java8TimeDialect();
	}
}
