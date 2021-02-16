package com.model.service;

import java.util.ArrayList;

import com.model.dtogroups.RefundDTO;


public interface RefundService {
	
	public void addRecord(RefundDTO dto) throws Exception;
	
	public ArrayList<Object> getRefundHistory() throws Exception;
	
	
	
}
