package com.model.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import com.model.dtogroups.ClubDTO;




public interface ClubService {
	
	public int getAllClubCount() throws Exception;
	
	public int getRegionClubCount(String location) throws Exception;
	
	public ArrayList<Object> getRegionClubs(String location) throws Exception;
	
	public  ArrayList<Object> getAllClubs() throws Exception;
	
	public ClubDTO getClub(String club_name) throws Exception;
	
	public void updateClub(ClubDTO dto) throws Exception;
	
	public ClubDTO checkClub(String club_name) throws Exception;
	
	public void addClub(ClubDTO dto) throws Exception;
	
	public void deleteClub(String club_name) throws Exception;
	
	
	
}
