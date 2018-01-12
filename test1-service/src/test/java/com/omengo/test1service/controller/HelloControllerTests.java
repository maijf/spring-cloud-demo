package com.omengo.test1service.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTests {

	private MockMvc mockMvc;

	@Autowired
	private HelloController helloController;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
	}

	@Test
	public void getPurStockList() throws Exception{
//		Gson gson = new Gson();
		MockHttpServletRequestBuilder httpServletRequest = MockMvcRequestBuilders.post("/hello2")
				.characterEncoding("UTF8")
				.contentType(MediaType.APPLICATION_JSON);
//				.content(gson.toJson(indata));
		mockMvc.perform(httpServletRequest).andDo(MockMvcResultHandlers.print());
	}
}
