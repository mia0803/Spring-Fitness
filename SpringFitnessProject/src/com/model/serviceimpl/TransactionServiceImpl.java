package com.model.serviceimpl;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dtogroups.TransactionDTO;
import com.model.service.TransactionService;

@Service("transactionDAO")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	SqlSessionTemplate sqlPrepared = null;

	@Override
	public TransactionDTO checkPayment(int member_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("transactionSqlDAO.checkPayment", member_id);
	}

	@Override
	public void addTransaction(TransactionDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("transactionSqlDAO.addTransaction", dto);
	}

	@Override
	public ArrayList<Object> getTransactions() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("transactionSqlDAO.getTransactions");
	}

	@Override
	public void refundTransaction(int id) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("transactionSqlDAO.refundTransaction", id);
	}

	@Override
	public TransactionDTO getTransactionInfo(int id) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("transactionSqlDAO.getTransactionInfo", id);
	}
	
	
	
	
}
