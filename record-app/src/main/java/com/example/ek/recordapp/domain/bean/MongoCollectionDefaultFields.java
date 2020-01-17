package com.example.ek.recordapp.domain.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;


/**
 * record-app
 * com.example.ek.recordapp.domain.data.common.CommonField.java
 *
 * MongoDBで定義されているコレクションの共通項目を定義したBeanファイル
 *
 * @author E-Kanegae
 *
 */
@Getter
@Setter
public class MongoCollectionDefaultFields implements Serializable {

	protected MongoCollectionDefaultFields() {
		this.updatedDateTime = LocalDateTime.now();
		this.updatedBy = "E-Kanegae";
	}
	
	/**
	 * レコード作成日時
	 */
	@Field(value = "Created_Datetime")
	private LocalDateTime createdDateTime;

	/**
	 * レコード更新日時
	 */	
	@Field(value = "Updated_Datetime")
	private LocalDateTime updatedDateTime;

	/**
	 * レコード作成者
	 */
	@Field(value = "Created_By")
	private String createdBy;

	/**
	 * レコード更新者
	 */
	@Field(value = "Update_By")
	private String updatedBy;

}
