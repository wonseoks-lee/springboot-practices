package com.poscoict;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.poscoict.controller.BoardController;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BoardController.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BoardControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testHello() throws Exception{
		mockMvc.perform(get("/hello").param("name", "둘리")) // RequestBuilder 객체를 인자로 받음 -> MockMvcRequestBuilder의 정적메소드를 이용해서 생성
			.andExpect(status().isOk())
			.andExpect(content().string("Hello : 둘리"))
			.andDo(print());
	}
}
