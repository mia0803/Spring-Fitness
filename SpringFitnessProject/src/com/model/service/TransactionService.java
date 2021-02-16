package com.model.service;

import java.util.ArrayList;

import com.model.dtogroups.TransactionDTO;

public interface TransactionService {

	public TransactionDTO checkPayment(int member_id) throws Exception;
	
	public void addTransaction(TransactionDTO dto) throws Exception;
	
	public ArrayList<Object> getTransactions() throws Exception;
	
	public void refundTransaction(int id) throws Exception;
	
	public TransactionDTO getTransactionInfo(int id) throws Exception;
	
	
	
	
}
