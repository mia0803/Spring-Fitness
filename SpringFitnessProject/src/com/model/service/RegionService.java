package com.model.service;

import java.util.ArrayList;
import java.util.List;

import com.model.dtogroups.RegionDTO;

public interface RegionService {

	public ArrayList<Object> getAllRegions() throws Exception;

	public List<Object> getAllRegionImages() throws Exception;

	public RegionDTO getRegion(String location) throws Exception;

	public byte[] getImage(String location) throws Exception;

	public void addRegionWithImage(RegionDTO dto) throws Exception;

	public void addRegionWithoutImage(RegionDTO dto) throws Exception;

	public void updateRegionWithImage(RegionDTO dto) throws Exception;

	public void updateRegionWithoutImage(RegionDTO dto) throws Exception;

	public void deleteRegion(String location) throws Exception;

}
