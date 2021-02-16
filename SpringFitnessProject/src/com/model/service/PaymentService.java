package com.model.service;

import com.model.dtogroups.PaymentDTO;

public interface PaymentService {
	
	public void addInfo(PaymentDTO dto) throws Exception;
	
	public int getId(int member_id) throws Exception;
	
	public PaymentDTO getPaymentInfo(int member_id) throws Exception;
	
	public void update(PaymentDTO dto) throws Exception;
	
	
}
