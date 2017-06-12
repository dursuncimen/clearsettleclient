package com.dursuncimen.clearsettleclient.restcontroller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Before;
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

import com.dursuncimen.clearsettleclient.model.Identification;
import com.dursuncimen.clearsettleclient.model.IdentificationResponse;
import com.dursuncimen.clearsettleclient.service.ClientLoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionRestControllerTest {
	@Value("${email}")
	private String email;

	@Value("${password}")
	private String password;
	
	@Value("${validTransactionId}")
	private String validTransactionId;
		
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ClientLoginService clientLoginService;
	
	private IdentificationResponse identificationResponse ;
	
	@Before
	public void createIdendifaciton() throws InterruptedException, ExecutionException{
		Identification identification = new Identification();
		identification.setEmail(email);
		identification.setPassword(password);		
		Future<Optional<IdentificationResponse>> futureOptionalIdentificationResponse = clientLoginService.login(identification);
		identificationResponse = futureOptionalIdentificationResponse.get().get();		
	}
	
	
	@Test
	public void listTransactionsWithInvalidTokenReturnHttp5xx() throws Exception{
		MvcResult mvcResult = this.mockMvc.perform(post("/api/transaction/list").contentType(MediaType.APPLICATION_JSON_UTF8)
				.header("token", "invalidtoken"))
				.andExpect(request().asyncStarted())
				.andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))
				.andReturn();
		this.mockMvc.perform(asyncDispatch(mvcResult))
				.andDo(print())
				.andExpect(status().is5xxServerError());		
	}
	
	@Test
	public void listTransactionsWithValidTokenReturnOk() throws Exception{
		MvcResult mvcResult = this.mockMvc.perform(post("/api/transaction/list").contentType(MediaType.APPLICATION_JSON_UTF8)
				.header("token", identificationResponse.getToken()))
				.andExpect(request().asyncStarted())
				.andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))
				.andReturn();
		this.mockMvc.perform(asyncDispatch(mvcResult))
				.andDo(print())
				.andExpect(status().isOk());		
	}
	
	@Test
	public void listTransactionsValidTokenAndValidQueryReturnOk() throws Exception{
		MvcResult mvcResult = this.mockMvc.perform(post("/api/transaction/list").contentType(MediaType.APPLICATION_JSON_UTF8)
				.header("token", identificationResponse.getToken())
				.param("fromDate", "2015-09-01")
				.param("toDate", "2015-09-25"))
				.andExpect(request().asyncStarted())
				.andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))
				.andReturn();
		this.mockMvc.perform(asyncDispatch(mvcResult))
				.andDo(print())
				.andExpect(jsonPath("data").isArray())
				.andExpect(status().isOk());		
	}
	

	
	
	@Test
	public void getTransactionWithTokenReturn2xx() throws Exception{
		MvcResult mvcResult = this.mockMvc.perform(post("/api/transaction/get").contentType(MediaType.APPLICATION_JSON_UTF8)
				.header("token", identificationResponse.getToken() )
				.param("transactionId", validTransactionId))
				.andExpect(request().asyncStarted())
				.andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))
				.andReturn();
		this.mockMvc.perform(asyncDispatch(mvcResult))
				.andDo(print())
				.andExpect(status().isOk());		
	}
	
	
	
	
	
}
