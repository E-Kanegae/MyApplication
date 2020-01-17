package com.example.ek.recordapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * record-app
 * com.example.ek.recordapp.RecordAppApplication.java
 *
 * MongDBを使うが、RDB接続のAutoConfigureが動いてしまうのでexcludeする。
 *
 * @author E-Kanegae
 *
 */
@ComponentScan("com.example.ek.recordapp")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RecordAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordAppApplication.class, args);
	}
}
