package com.model.service;

import java.util.ArrayList;

import com.model.dtogroups.MemberDTO;

public interface MemberService {

	public void updatePw(MemberDTO dto) throws Exception;

	public String getPw(MemberDTO dto) throws Exception;

	public String getEmail(MemberDTO dto) throws Exception;

	public void addMember(MemberDTO dto) throws Exception;

	public int getId(String email) throws Exception;

	public MemberDTO checkLogin(MemberDTO dto) throws Exception;

	public ArrayList<Object> getAllMembers() throws Exception;

	public MemberDTO getMember(String email) throws Exception;

	public void deactivateMember(int id) throws Exception;

	public void activateMember(int id) throws Exception;

	public ArrayList<Object> getTeachers() throws Exception;

	public void updateMember(MemberDTO dto) throws Exception;

	public void updateMemberMembership(MemberDTO dto) throws Exception;

	public MemberDTO phoneValidation(String phone) throws Exception;

	public MemberDTO emailValidation(String email) throws Exception;

}
