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

import com.dursuncimen.clearsettleclient.model.CustomerInfoWrapper;
import com.dursuncimen.clearsettleclient.model.TransactionPost;
import com.dursuncimen.clearsettleclient.service.ClientService;

@RestController
public class ClientRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ClientRestController.class);
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/api/customer/get")
	public Callable<ResponseEntity<?>> getClient(@RequestHeader(value="token", required = true) String token, @Valid TransactionPost transactionPost, BindingResult bindingResult,
			Locale locale) {
		
		log.info("Try get customer with query: {} locale: {}", transactionPost, locale);		
		Optional<String> identificationToken = Optional.of(token);		
		if(!identificationToken.isPresent()){			
			return () -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		if (bindingResult.hasErrors()) {			
			log.info("Failed get client with query: {} locale: {}", transactionPost, locale);
			return () -> new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		return () -> {
			Future<Optional<CustomerInfoWrapper>> customerInfoWrapper = clientService.getClient(identificationToken.get(), transactionPost);
			if (customerInfoWrapper.get().isPresent()) {
				log.info("Successful  get client locale: {}", locale);
				return new ResponseEntity<>(customerInfoWrapper.get().get(),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		};
		
	}
}
