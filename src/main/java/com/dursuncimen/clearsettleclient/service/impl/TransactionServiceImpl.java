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

import com.dursuncimen.clearsettleclient.model.Report;
import com.dursuncimen.clearsettleclient.model.ReportResponse;
import com.dursuncimen.clearsettleclient.model.TransactionPost;
import com.dursuncimen.clearsettleclient.model.TransactionQuery;
import com.dursuncimen.clearsettleclient.model.TransactionQueryResponse;
import com.dursuncimen.clearsettleclient.model.TransactionResponse;
import com.dursuncimen.clearsettleclient.service.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Value("${transactionReportUrl}")
	private String transactionReportUrl;
	
	@Value("${transactionListUrl}")
	private String transactionListUrl;
	
	@Value("${getTransactionUrl}")
	private String getTransactionUrl;
	

	@Autowired
	private RestTemplate restTemplate;

	@Async
	@Override
	public Future<Optional<ReportResponse>> postReport(String token, Report report) {
		log.info("Post data: {} report: {} token: {}", report, transactionReportUrl, token);
		ReportResponse reportResponse = null;
		try {
			reportResponse = restTemplate.postForObject(transactionReportUrl, report, ReportResponse.class);
		} catch (HttpStatusCodeException e) {
			log.info("Post Error Http Code: {} Http Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
		}
		return new AsyncResult<>(Optional.ofNullable(reportResponse));
	}

	@Async
	@Override
	public Future<Optional<TransactionQueryResponse>> listTransaction(String token, TransactionQuery transactionQuery) {
		log.info("Post data: {} transactionQuery: {} token: {}", transactionQuery, transactionListUrl, token);
		TransactionQueryResponse transactionQueryResponse = null;
		try {
			transactionQueryResponse = restTemplate.postForObject(transactionListUrl, transactionQuery, TransactionQueryResponse.class);
		} catch (HttpStatusCodeException e) {
			log.info("Post Error Http Code: {} Http Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
		}
		return new AsyncResult<>(Optional.ofNullable(transactionQueryResponse));
	}

	@Async
	@Override
	public Future<Optional<TransactionResponse>> getTransaction(String token, TransactionPost transactionPost) {
		log.info("Post data: {} transactionPost: {} token: {}", transactionPost, getTransactionUrl, token);
		TransactionResponse transactionResponse = null;
		try {
			transactionResponse = restTemplate.postForObject(getTransactionUrl, transactionPost, TransactionResponse.class);
		} catch (HttpStatusCodeException e) {
			log.info("Post Error Http Code: {} Http Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
		}
		return new AsyncResult<>(Optional.ofNullable(transactionResponse));
	}

}
