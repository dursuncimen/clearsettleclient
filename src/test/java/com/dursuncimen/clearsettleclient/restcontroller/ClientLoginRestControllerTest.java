package com.dursuncimen.clearsettleclient.restcontroller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientLoginRestControllerTest {
	
	@Value("${email}")
	private String email;

	@Value("${password}")
	private String password;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void loginNoBodyReturnHttp4xx() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(request().asyncStarted())
				.andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))
				.andReturn();

		this.mockMvc.perform(asyncDispatch(mvcResult))
				.andDo(print())
				.andExpect(status().is4xxClientError());

	}
	
	
	@Test
	public void loginWithOnlyMailReturnHttp4xx() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(post("/api/login")
				.param("email","invalid@invalid.com"))
				.andExpect(request().asyncStarted())
				.andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))				
				.andReturn();

		this.mockMvc.perform(asyncDispatch(mvcResult))
				.andDo(print())
				.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void loginWithOnlyPasswordReturnHttp4xx() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(post("/api/login")
				.param("password","invalid"))
				.andExpect(request().asyncStarted())
				.andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))				
				.andReturn();

		this.mockMvc.perform(asyncDispatch(mvcResult))
				.andDo(print())
				.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void loginWithInvalidParamsReturnHttp4xx() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(post("/api/login")
				.param("password","invalid")
				.param("email","invalid&invalid.com"))
				.andExpect(request().asyncStarted())
				.andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))				
				.andReturn();

		this.mockMvc.perform(asyncDispatch(mvcResult))
				.andDo(print())
				.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void loginWithValidParamsReturnHttp2xx() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(post("/api/login")
				.param("password",password)
				.param("email", email))
				.andExpect(request().asyncStarted())
				.andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))				
				.andReturn();

		this.mockMvc.perform(asyncDispatch(mvcResult))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("token").isNotEmpty())
				.andExpect(jsonPath("status").isNotEmpty());
	}	
}
