package com.example.ek.recordapp.config.jsr310;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

/**
 * record-app
 * com.example.ek.recordapp.config.jsr310.Jsr310Configuration.java
 *
 * Date Time API対応用JacaConfig
 *
 * @author E-Kanegae
 *
 */
@Configuration
public class Jsr310Configuration {
	
	@Bean
    public FormattingConversionService conversionService() {
        DefaultFormattingConversionService conversionService =
          new DefaultFormattingConversionService(false);

        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setDateFormatter(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        registrar.registerFormatters(conversionService);

        return conversionService;
    }
	
	@Bean
    public Formatter<LocalDate> localDateFormatter() {
        return new Formatter<LocalDate>() {
            @Override
            public String print(LocalDate object, Locale locale) {
                return object.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            }
            @Override
            public LocalDate parse(String text, Locale locale) throws ParseException {
                return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            }
        };
    }
}
