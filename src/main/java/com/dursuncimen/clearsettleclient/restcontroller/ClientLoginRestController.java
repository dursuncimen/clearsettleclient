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
import org.springframework.web.bind.annotation.RestController;

import com.dursuncimen.clearsettleclient.model.Identification;
import com.dursuncimen.clearsettleclient.model.IdentificationResponse;
import com.dursuncimen.clearsettleclient.service.ClientLoginService;

@RestController
public class ClientLoginRestController {

	private static final Logger log = LoggerFactory.getLogger(ClientLoginRestController.class);

	@Autowired
	private ClientLoginService loginService;

	@PostMapping("/api/login")
	public Callable<ResponseEntity<?>> login(@Valid Identification identification, BindingResult bindingResult,	Locale locale) {
		log.info("Try login with e-mail: {} locale: {}", identification.getEmail(), locale);

		if (bindingResult.hasErrors()) {
			log.info("Failed login with e-mail: {} locale: {}", identification.getEmail(), locale);
			return () -> new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		return () -> {
			Future<Optional<IdentificationResponse>> identificationResponse = loginService.login(identification);
			if (identificationResponse.get().isPresent()) {
				log.info("Successful login with e-mail: {} locale: {} {}", identification.getEmail(), locale,identificationResponse.get().get().getToken());
				return new ResponseEntity<>(identificationResponse.get().get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		};
	}
}
