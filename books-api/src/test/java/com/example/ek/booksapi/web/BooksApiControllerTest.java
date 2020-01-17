package com.example.ek.booksapi.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.ek.booksapi.domain.BooksApiService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * books-api com.example.ek.booksapi.web.BooksApiControllerTest.java に対するテストクラス
 *
 * @author E-Kanegae
 *
 */
//@SpringJUnitConfig
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
// ↓Guideには記載がない(気がする。サンプルにも記載ない)が、Bean登録を明示的にしないとControllerが登録されていなかった。
// @SpringBootTestが勝手にやってくれるんだと思っていた。
@ComponentScan("com.example.ek.booksapi.web") 
class BooksApiControllerTest {
	
	Logger log = LoggerFactory.getLogger(BooksApiControllerTest.class);
	
//	@Configuration
//	static class testConfig {
//		@Bean
//		public BooksApiService getBooksApiService() {
//			return mock(BooksApiService.class);
//		}
//	}
	
	@Autowired
    private MockMvc mockMvc;

	@Test
	void testGetBookInfoSuccess() throws Exception {
		
		MvcResult result =mockMvc.perform(
	    		get("/booksapi/getBookInfo")
	    		.param("isbn", "9784798149158")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	    String content = result.getResponse().getContentAsString();
	    System.out.println(content);
	    assertEquals("", content); 

	}
	
	@Test
	void exmapleTest() throws Exception {
		mockMvc.perform(
	    		get("/booksapi/example"))
		.andDo(print());
	}
	
	

}
