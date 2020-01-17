package com.example.ek.recordapp.web.common;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * record-app
 * com.example.ek.recordapp.web.common.DefaultControllerAdvice.java
 *
 * TODO クラスファイルの説明を記載してください。
 *
 * @author E-Kanegae
 *
 */
@ControllerAdvice
public class DefaultControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(DefaultControllerAdvice.class);

	/**
	 * (1) 未入力項目（空文字）をNullに変更する.
	 * (2) TextをLocalDateにフォーマット変換する
	 * @param dataBinder
	 *
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		logger.debug("initBinder : {}", dataBinder);
		// WebDataBinderのメソッドを呼び出してカスタマイズする
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
		      @Override
		      public void setAsText(String text) throws IllegalArgumentException {
		    	  if(StringUtils.hasLength(text)) {
		    		  setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		    	  }
		      }
		    });
	}

	/**
	 * 
	 * @param trackingId
	 * @retrun String
	 *
	 */
	@ModelAttribute("trackingId")
	public String addOneObject(@RequestHeader("X-Tracking-Id") Optional<String> trackingId) {
		logger.debug("addOneObject : {}", trackingId);
		// Modelに追加するオブジェクトを返却する
		return trackingId.orElse(UUID.randomUUID().toString());
	}

}
