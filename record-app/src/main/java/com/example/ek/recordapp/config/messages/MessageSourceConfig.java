package com.example.ek.recordapp.config.messages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.StringUtils;

/**
 * record-app
 * com.example.ek.recordapp.config.messages.MessageSourceConfig.java
 *
 * MessageSource(メッセージ解決)にてYAMLファイルが扱えるようにするための設定ファイル
 *
 * @author E-Kanegae
 *
 */
@Configuration
@Profile({"default", "dev"})
public class MessageSourceConfig {

	@Bean("messageSource")
	public MessageSource messageSource(
			@Value("${spring.messages.basename}") String basename,
			@Value("${spring.messages.encoding}") String encoding) {
		YamlMessageSource ms = new YamlMessageSource();
		ms.setBasenames(StringUtils
				.commaDelimitedListToStringArray(StringUtils.trimAllWhitespace(basename)));
		ms.setDefaultEncoding(encoding);
		ms.setAlwaysUseMessageFormat(true);
		ms.setUseCodeAsDefaultMessage(true);
		ms.setFallbackToSystemLocale(true);
		return ms;
	}

}
