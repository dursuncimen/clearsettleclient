package com.dursuncimen.clearsettleclient.restcontroller;

import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.dursuncimen.clearsettleclient.model.TransactionPost;
import com.dursuncimen.clearsettleclient.model.TransactionQuery;
import com.dursuncimen.clearsettleclient.model.TransactionQueryResponse;
import com.dursuncimen.clearsettleclient.model.TransactionResponse;
import com.dursuncimen.clearsettleclient.service.TransactionService;


@RestController
public class TransactionRestController {

	private static final Logger log = LoggerFactory.getLogger(TransactionRestController.class);

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/api/transaction/list")
	public Callable<ResponseEntity<?>> listTransactions(@RequestHeader(value="token", required = true) String token, @Valid TransactionQuery transactionQuery, BindingResult bindingResult,
			Locale locale) {
		
		log.info("Try list transactions with query: {} locale: {}", transactionQuery, locale);		
		Optional<String> identificationToken = Optional.of(token);		
		if(!identificationToken.isPresent()){			
			return () -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		if (bindingResult.hasErrors()) {			
			log.info("Failed list transactions with query: {} locale: {}", transactionQuery, locale);
			return () -> new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		return () -> {
			Future<Optional<TransactionQueryResponse>> transactionQueryResponse = transactionService.listTransaction(identificationToken.get(), transactionQuery);
			if (transactionQueryResponse.get().isPresent()) {
				log.info("Successful  list transactions locale: {}", locale);
				return new ResponseEntity<>(transactionQueryResponse.get().get(),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		};
		
	}
	
	@PostMapping("/api/transaction/get")
	public Callable<ResponseEntity<?>> getTransaction(@RequestHeader(value="token", required = true) String token, @Valid TransactionPost transactionPost, BindingResult bindingResult,
			Locale locale) {
		
		log.info("Try get transaction with query: {} locale: {}", transactionPost, locale);		
		Optional<String> identificationToken = Optional.of(token);		
		if(!identificationToken.isPresent()){			
			return () -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		if (bindingResult.hasErrors()) {			
			log.info("Failed get transaction with query: {} locale: {}", transactionPost, locale);
			return () -> new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		return () -> {
			Future<Optional<TransactionResponse>> transactionResponse = transactionService.getTransaction(identificationToken.get(), transactionPost);
			if (transactionResponse.get().isPresent()) {
				log.info("Successful  get transaction locale: {}", locale);
				return new ResponseEntity<>(transactionResponse.get().get(),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		};
		
	}
}
