package com.model.service;

import java.util.ArrayList;

import com.model.dtogroups.ClassCartDTO;

public interface ClassCartService {
	
	public ArrayList<Object> getClassInfoByDay(ClassCartDTO dto) throws Exception;
	
	public ClassCartDTO checkExistance(ClassCartDTO dto) throws Exception;
	
	public ClassCartDTO getClassInfo(int c_id) throws Exception;
	
	public void addClass(ClassCartDTO dto) throws Exception;
	
	
}
