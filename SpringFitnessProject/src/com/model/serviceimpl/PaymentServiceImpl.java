package com.model.serviceimpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dtogroups.PaymentDTO;
import com.model.service.PaymentService;

@Service("paymentDAO")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	SqlSessionTemplate sqlPrepared = null;

	@Override
	public void addInfo(PaymentDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("paymentSqlDAO.addInfo",dto);
	}

	@Override
	public int getId(int member_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("paymentSqlDAO.getId",member_id);
	}

	@Override
	public PaymentDTO getPaymentInfo(int member_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("paymentSqlDAO.getId",member_id);
	}

	@Override
	public void update(PaymentDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("paymentSqlDAO.getId",dto);
	}
	
	
	
	
}
