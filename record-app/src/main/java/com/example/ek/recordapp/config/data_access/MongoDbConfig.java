package com.example.ek.recordapp.config.data_access;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * <pre>
 * record-app
 * com.example.ek.recordapp.config.data_access.MongoDbConfig.java
 *
 * DBアクセス層の設定を行うJavaConfigクラス
 *
 * </pre>
 * @author E-Kanegae
 *
 */
@EnableMongoRepositories(basePackages="com.example.ek.recordapp.domain.repository.mongodb")
@Configuration
@Profile("default")
public class MongoDbConfig extends AbstractMongoClientConfiguration{

	@Override
	@Bean
	public MongoClient mongoClient() {
//		return MongoClients.create(); // localhostへの接続はこれでOK. 他のホストへ接続したい場合は以下の様にする。
		MongoClientSettings settings = MongoClientSettings.builder()
			    .applyConnectionString(new ConnectionString("mongodb://localhost"))
			    .retryWrites(true)
			    .build();
		return MongoClients.create(settings, null);
	}

	@Override
	protected String getDatabaseName() {
		return "recorddb";
	}
	
	@Override
	protected Collection<String> getMappingBasePackages() {
		return Collections.singleton("com.example.ek.recordapp.domain.bean");	
	}
}
