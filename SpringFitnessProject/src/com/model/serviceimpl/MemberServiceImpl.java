package com.model.serviceimpl;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dtogroups.MemberDTO;
import com.model.service.MemberService;

@Service("memberDAO")
public class MemberServiceImpl implements MemberService {

	@Autowired
	SqlSessionTemplate sqlPrepared = null;

	@Override
	public void updatePw(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("memberSqlDAO.updatePw", dto);
	}

	@Override
	public String getPw(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("memberSqlDAO.getPw", dto);
	}

	@Override
	public String getEmail(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("memberSqlDAO.getEmail", dto);
	}

	@Override
	public void addMember(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("memberSqlDAO.addMember", dto);
	}

	@Override
	public int getId(String email) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("memberSqlDAO.getId", email);
	}

	@Override
	public MemberDTO checkLogin(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("memberSqlDAO.checkLogin", dto);
	}

	@Override
	public ArrayList<Object> getAllMembers() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("memberSqlDAO.getAllMembers");
	}

	@Override
	public MemberDTO getMember(String email) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("memberSqlDAO.getMember", email);
	}

	@Override
	public void deactivateMember(int id) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("memberSqlDAO.deactivateMember", id);
	}

	@Override
	public void activateMember(int id) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("memberSqlDAO.activateMember", id);
	}

	@Override
	public ArrayList<Object> getTeachers() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("memberSqlDAO.getTeachers");
	}

	@Override
	public void updateMember(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("memberSqlDAO.updateMember", dto);
	}

	@Override
	public void updateMemberMembership(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("memberSqlDAO.updateMemberMembership", dto);
	}

	@Override
	public MemberDTO phoneValidation(String phone) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("memberSqlDAO.phoneValidation", phone);
	}

	@Override
	public MemberDTO emailValidation(String email) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("memberSqlDAO.emailValidation", email);
	}

}
