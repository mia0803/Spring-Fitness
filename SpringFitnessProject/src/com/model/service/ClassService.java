package com.model.service;

import java.util.ArrayList;

import com.model.dtogroups.ClassDTO;
import com.model.dtogroups.ClubDTO;



public interface ClassService {
	
	public ClassDTO checkDelete(String club) throws Exception;
	
	public int getTotalCount(String club) throws Exception;
	
	public ArrayList<Object> getClassByDay(ClassDTO dto) throws Exception;
	
	public ArrayList<Object> getAllClasses() throws Exception;
	
	public ClassDTO getClass(int c_id) throws Exception;
	
	public ClassDTO checkCombination(ClassDTO dto) throws Exception;
	
	public void addClass(ClassDTO dto) throws Exception;
	
	public void updateClass(ClassDTO dto) throws Exception;
	
	public void deleteClass(int c_id) throws Exception;
	
}
