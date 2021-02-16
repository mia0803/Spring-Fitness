package com.model.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dtogroups.RegionDTO;
import com.model.service.RegionService;

@Service("regionDAO")
public class RegionServiceImpl implements RegionService {

	@Autowired
	SqlSessionTemplate sqlPrepared = null;

	@Override
	public ArrayList<Object> getAllRegions() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("regionSqlDAO.getAllRegions");
	}

	@Override
	public List<Object> getAllRegionImages() throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectList("regionSqlDAO.getAllRegionImages");
	}

	@Override
	public RegionDTO getRegion(String location) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("regionSqlDAO.getRegion", location);
	}

	@Override
	public byte[] getImage(String location) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("regionSqlDAO.getImage", location);
	}

	@Override
	public void addRegionWithImage(RegionDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("regionSqlDAO.addRegionWithImage", dto);
	}

	@Override
	public void addRegionWithoutImage(RegionDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("regionSqlDAO.addRegionWithoutImage", dto);
	}

	@Override
	public void updateRegionWithImage(RegionDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("regionSqlDAO.updateRegionWithImage", dto);
	}

	@Override
	public void updateRegionWithoutImage(RegionDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("regionSqlDAO.updateRegionWithoutImage", dto);
	}

	@Override
	public void deleteRegion(String location) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.delete("regionSqlDAO.deleteRegion", location);
	}

}
