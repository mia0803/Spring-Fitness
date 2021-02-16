package com.model.serviceimpl;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dtogroups.ClassDTO;
import com.model.service.ClassService;


@Service("classDAO")
public class ClassServiceImpl implements ClassService{

	
	@Autowired
	SqlSessionTemplate sqlPrepared = null;
	
	@Override
	public ClassDTO checkDelete(String club) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("classSqlDAO.checkDelete", club);
	}
	
	@Override
	public int getTotalCount(String club) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("classSqlDAO.getTotalCount", club);
	}

	@Override
	public ArrayList<Object> getClassByDay(ClassDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("classSqlDAO.checkCondition", dto);
	}

	@Override
	public ArrayList<Object> getAllClasses() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("classSqlDAO.getAllClasses");
	}

	@Override
	public ClassDTO getClass(int c_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("classSqlDAO.getClass", c_id);
	}

	@Override
	public ClassDTO checkCombination(ClassDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("classSqlDAO.checkCombination", dto);
	}

	@Override
	public void addClass(ClassDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("classSqlDAO.addClass", dto);
	}

	@Override
	public void updateClass(ClassDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("classSqlDAO.updateClass", dto);
	}

	@Override
	public void deleteClass(int c_id) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.delete("classSqlDAO.deleteClass", c_id);
	}

	

}
