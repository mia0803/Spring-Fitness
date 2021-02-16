package com.model.serviceimpl;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dtogroups.ClassCartDTO;
import com.model.service.ClassCartService;

@Service("classCartDAO")
public class ClassCartServiceImpl implements ClassCartService {

	@Autowired
	SqlSessionTemplate sqlPrepared = null;
	
	@Override
	public ArrayList<Object> getClassInfoByDay(ClassCartDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("classCartSqlDAO.getClassInfoByDay", dto);
	}

	@Override
	public ClassCartDTO checkExistance(ClassCartDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("classCartSqlDAO.checkExistance", dto);
	}

	@Override
	public ClassCartDTO getClassInfo(int c_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("classCartSqlDAO.getClassInfo", c_id);
	}

	@Override
	public void addClass(ClassCartDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("classCartSqlDAO.addClass", dto);
	}

}
