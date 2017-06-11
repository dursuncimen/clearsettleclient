package com.dursuncimen.clearsettleclient.service;

import java.util.Optional;
import java.util.concurrent.Future;

import com.dursuncimen.clearsettleclient.model.Report;
import com.dursuncimen.clearsettleclient.model.ReportResponse;
import com.dursuncimen.clearsettleclient.model.TransactionPost;
import com.dursuncimen.clearsettleclient.model.TransactionQuery;
import com.dursuncimen.clearsettleclient.model.TransactionQueryResponse;
import com.dursuncimen.clearsettleclient.model.TransactionResponse;


public interface TransactionService {
	
	public Future<Optional<ReportResponse>> postReport(String token, Report report);
	
	public Future<Optional<TransactionQueryResponse>> listTransaction(String token, TransactionQuery transactionQuery);
	
	public Future<Optional<TransactionResponse>> getTransaction(String token, TransactionPost transactionPost);
	
}
