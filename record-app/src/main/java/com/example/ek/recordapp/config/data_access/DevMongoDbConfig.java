package com.example.ek.recordapp.config.data_access;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * <pre>
 * record-app
 * com.example.ek.recordapp.config.data_access.DevMongoDbConfig.java
 *
 * DBアクセス層の設定を行うJavaConfigクラス(開発環境用)
 *
 * </pre>
 * @author E-Kanegae
 *
 */
@Configuration
@Profile("dev")
public class DevMongoDbConfig extends MongoDbConfig {

	@Override
	@Bean
	public MongoClient mongoClient() {
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(new ConnectionString("mongodb://localhost"))
				.retryWrites(true)
				.build();
		return MongoClients.create(settings, null);
	}

	@Override
	protected String getDatabaseName() {
		return "devrecorddb";
	}
}
