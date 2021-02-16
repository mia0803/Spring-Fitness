package com.model.serviceimpl;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dtogroups.RefundDTO;
import com.model.service.RefundService;

@Service("refundDAO")
public class RefundServiceImpl implements RefundService {

	@Autowired
	SqlSessionTemplate sqlPrepared = null;

	@Override
	public void addRecord(RefundDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("refundSqlDAO.addRecord", dto);
	}
	
	@Override
	public ArrayList<Object> getRefundHistory() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("refundSqlDAO.getRefundHistory");
	}

	
	
	
	
	
}
