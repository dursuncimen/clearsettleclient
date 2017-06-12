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

import com.dursuncimen.clearsettleclient.model.MerchantWrapper;
import com.dursuncimen.clearsettleclient.model.TransactionPost;
import com.dursuncimen.clearsettleclient.service.MerchantService;

@RestController
public class MerchantRestController {
	
	private static final Logger log = LoggerFactory.getLogger(MerchantRestController.class);
	
	@Autowired
	private MerchantService merchantService;
	
	
	@PostMapping("/api/merchant/get")
	public Callable<ResponseEntity<?>> getTransaction(@RequestHeader(value="token", required = true) String token, @Valid TransactionPost transactionPost, BindingResult bindingResult,
			Locale locale) {
		
		log.info("Try get merchant with query: {} locale: {}", transactionPost, locale);		
		Optional<String> identificationToken = Optional.of(token);		
		if(!identificationToken.isPresent()){			
			return () -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		if (bindingResult.hasErrors()) {			
			log.info("Failed get transaction with query: {} locale: {}", transactionPost, locale);
			return () -> new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		return () -> {
			Future<Optional<MerchantWrapper>> merchantWrapper = merchantService.getMerchant(identificationToken.get(), transactionPost);
			if (merchantWrapper.get().isPresent()) {
				log.info("Successful  get transaction locale: {}", locale);
				return new ResponseEntity<>(merchantWrapper.get().get(),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		};
		
	}
}
