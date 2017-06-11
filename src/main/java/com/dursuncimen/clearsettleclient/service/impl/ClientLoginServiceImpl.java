package com.dursuncimen.clearsettleclient.service.impl;

import java.util.Optional;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.dursuncimen.clearsettleclient.model.Identification;
import com.dursuncimen.clearsettleclient.model.IdentificationResponse;
import com.dursuncimen.clearsettleclient.service.ClientLoginService;

@Service
public class ClientLoginServiceImpl implements ClientLoginService {

	private static final Logger log = LoggerFactory.getLogger(ClientLoginServiceImpl.class);

	@Value("${clientLoginUrl}")
	private String clientLoginURL;

	@Autowired
	private RestTemplate restTemplate;

	@Async
	@Override
	public Future<Optional<IdentificationResponse>> login(Identification identification) {
		log.info("Post data: {} url: {}", identification, clientLoginURL);
		IdentificationResponse identificationResponse = null;
		try {
			identificationResponse = restTemplate.postForObject(clientLoginURL, identification, IdentificationResponse.class);
		} catch (HttpStatusCodeException e) {
			log.info("Post Error Http Code: {} Http Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
		}
		return new AsyncResult<>(Optional.ofNullable(identificationResponse));
	}

}
