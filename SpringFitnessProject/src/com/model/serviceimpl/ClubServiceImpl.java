package com.model.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dtogroups.ClubDTO;
import com.model.service.ClubService;

@Service("clubDAO")
public class ClubServiceImpl implements ClubService{

	@Autowired
	SqlSessionTemplate sqlPrepared = null;

	@Override
	public int getAllClubCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("clubSqlDAO.getAllClubCount");
	}
	
	@Override
	public int getRegionClubCount(String location) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("clubSqlDAO.getRegionClubCount", location);
	}
	
	@Override
	public ArrayList<Object> getRegionClubs(String location) throws Exception {

		ArrayList<Object> clubList = (ArrayList<Object>) sqlPrepared.selectList("clubSqlDAO.getRegionClubs", location);
		
		for(int i=0; i<clubList.size();i++) {
			byte[] blob = (byte[])((Map<String, Object>)clubList.get(i)).get("club_img");

			try {
				((Map<String, Object>) clubList.get(i)).put("club_img",new String(blob,"utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return clubList;
	}

	@Override
	public ArrayList<Object> getAllClubs() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("clubSqlDAO.getAllClubs");
	}

	@Override
	public ClubDTO getClub(String club_name) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("clubSqlDAO.getClub", club_name);
	}
	
	@Override
	public void updateClub(ClubDTO dto) throws Exception {

		Map<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("club_img", dto.getImg_mf().getBytes());
        dto.setImg_hmap(hmap);
        
        sqlPrepared.update("clubSqlDAO.updateClub", dto); 
		
	}
	
	@Override
	public ClubDTO checkClub(String club_name) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("clubSqlDAO.checkClub", club_name);
	}

	@Override
	public void addClub(ClubDTO dto) throws Exception {
		
		Map<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("club_img", dto.getImg_mf().getBytes());
        dto.setImg_hmap(hmap);
        
        sqlPrepared.insert("clubSqlDAO.addClub", dto);  
	}
	
	@Override
	public void deleteClub(String club_name) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.delete("clubSqlDAO.deleteClub", club_name);
	}

	
	
	
	
	
	
	
	
}
