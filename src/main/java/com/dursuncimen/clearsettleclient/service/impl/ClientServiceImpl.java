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

import com.dursuncimen.clearsettleclient.model.CustomerInfo;
import com.dursuncimen.clearsettleclient.model.TransactionPost;
import com.dursuncimen.clearsettleclient.service.ClientService;


@Service
public class ClientServiceImpl implements ClientService {

	private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Value("${getClient}")
	private String getClient;

	@Autowired
	private RestTemplate restTemplate;

	@Async
	@Override
	public Future<Optional<CustomerInfo>> getClient(String token, TransactionPost transactionPost) {
		log.info("Post data: {} transactionPost: {} token: {}", transactionPost, getClient, token);
		CustomerInfo customerInfo = null;
		try {
			customerInfo = restTemplate.postForObject(getClient, transactionPost, CustomerInfo.class);
		} catch (HttpStatusCodeException e) {
			log.info("Post Error Http Code: {} Http Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
		}
		return new AsyncResult<>(Optional.ofNullable(customerInfo));
	}

}
