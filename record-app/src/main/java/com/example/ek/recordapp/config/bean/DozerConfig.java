package com.example.ek.recordapp.config.bean;

import java.util.Collections;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * record-app
 * com.example.ek.recordapp.config.bean.DozerConfig.java
 *
 * TODO ここにクラスの説明を書いてください。
 *
 * @author E-Kanegae
 *
 */
@Configuration
public class DozerConfig {

	@Bean
	public DozerBeanMapper mapper() throws Exception {
		DozerBeanMapper mapper = new DozerBeanMapper();
		// dozer-jdk8-supportライブラリのマッピングファイル読み込み
		mapper.setMappingFiles(Collections.singletonList("dozerJdk8Converters.xml"));
		mapper.addMapping(objectMappingBuilder);
		return mapper;
	}

	BeanMappingBuilder objectMappingBuilder = new BeanMappingBuilder() {
		@Override
		protected void configure() { // カスタムの設定はここに規定する。
			//	        mapping(Bean1.class, Bean2.class)
			//	                .fields("id", "id").fields("name", "name");
		}
	};
}
