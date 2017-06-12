package com.dursuncimen.clearsettleclient.restcontroller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.dursuncimen.clearsettleclient.model.Identification;
import com.dursuncimen.clearsettleclient.model.IdentificationResponse;
import com.dursuncimen.clearsettleclient.service.ClientLoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MerchantRestControllerTest {

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
    public void getMerchantWithoutTokenReturn4xx() throws Exception {
		mockMvc.perform(post("/api/merchant/get"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
	
	@Test
    public void getMerchantWithInValidTokenReturn4xx() throws Exception {
		mockMvc.perform(post("/api/merchant/get").header("token", "invalidtoken"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
	
	@Test
    public void getMerchantWithValidTokenReturnOk() throws Exception {
		mockMvc.perform(post("/api/merchant/get").header("token", identificationResponse.getToken()))
                .andDo(print())
                .andExpect(status().isOk());
    }
	
	@Test
    public void getMerchantWithValidTokenAndValidTransactionIdReturnOk() throws Exception {
		mockMvc.perform(post("/api/merchant/get").header("token", identificationResponse.getToken())
				.param("transactionId", validTransactionId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("merchant" , hasSize(1)));
    }
	
	
}
