package com.dursuncimen.clearsettleclient.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dursuncimen.clearsettleclient.model.Identification;
import com.dursuncimen.clearsettleclient.model.IdentificationResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {

	@Value("${email}")
	private String email;

	@Value("${password}")
	private String password;
	

	
	@Autowired
	private ClientLoginService clientLoginService;

	@Test()
	public void loginSuccess() throws InterruptedException, ExecutionException  {
		Identification identification = new Identification();
		identification.setEmail(email);
		identification.setPassword(password);		
		Future<Optional<IdentificationResponse>> futureOptionalIdentificationResponse = clientLoginService.login(identification);
		IdentificationResponse identificationResponse = futureOptionalIdentificationResponse.get().get();
		assertEquals("Status should be 'APPROVED'", "APPROVED", identificationResponse.getStatus());
		assertNotNull(identificationResponse.getToken());		
		
	}

}
