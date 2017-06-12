package com.dursuncimen.clearsettleclient.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dursuncimen.clearsettleclient.model.Identification;
import com.dursuncimen.clearsettleclient.model.IdentificationResponse;
import com.dursuncimen.clearsettleclient.model.TransactionQuery;
import com.dursuncimen.clearsettleclient.model.TransactionQueryResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;
	
	@Autowired
	private ClientLoginService clientLoginService;
	
	@Autowired
	private TransactionService transactionService;
	
	private IdentificationResponse identificationResponse;
	
	@Before
	public void createIdendification() throws InterruptedException, ExecutionException{
		Identification identification = new Identification();
		identification.setEmail(email);
		identification.setPassword(password);	
		identificationResponse = clientLoginService.login(identification).get().get();		
	}
	
	
	@Test
	public void listTransactionTest() throws ParseException, InterruptedException, ExecutionException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		TransactionQuery transactionQuery = new TransactionQuery();
		transactionQuery.setFromDate(sdf.parse("2015-09-01"));
		transactionQuery.setToDate(sdf.parse("2015-09-01"));
		TransactionQueryResponse transactionQueryResponse= transactionService.listTransaction(identificationResponse.getToken(), transactionQuery).get().get();
		
		
	}
	
}
