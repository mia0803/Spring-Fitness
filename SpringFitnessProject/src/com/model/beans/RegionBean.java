package com.model.beans;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.dtogroups.RegionDTO;
import com.model.service.ClubService;
import com.model.service.RegionService;

@Controller
@RequestMapping("/region")
public class RegionBean {

	@Autowired
	RegionService regionDAO = null;

	@Autowired
	ClubService clubDAO = null;

	@RequestMapping("/region")
	public String cookie_region(HttpSession session, Model m) throws Exception {

		int totalCount = clubDAO.getAllClubCount();
		List allRegions = regionDAO.getAllRegions();
		List<Integer> totalNList = new ArrayList<Integer>();

		for (Object each : allRegions) {
			int count = clubDAO.getRegionClubCount(((RegionDTO) each).getLocation());
			totalNList.add(count);
		}

		List images = regionDAO.getAllRegionImages();
		List<String> imageList = new ArrayList<String>();
		for (Object each : images) {
			String img = null;
			if (each != null) {
				byte[] byteimage = (byte[]) each;
				img = Base64.getEncoder().encodeToString(byteimage);
			}
			imageList.add(img);
		}

		m.addAttribute("totalCount", totalCount);
		m.addAttribute("allRegions", allRegions);
		m.addAttribute("totalNList", totalNList);
		m.addAttribute("imageList", imageList);

		return "/region/region";
	}

	@RequestMapping("/addLocation")
	public String session_addLocation(HttpSession session, Model m) throws Exception {

		return "/region/addLocation";
	}

	@RequestMapping("/addLocationPro")
	public String session_addLocationPro(RegionDTO dto, Model m, HttpServletRequest request) throws Exception {

		RegionDTO rdto = regionDAO.getRegion(dto.getLocation());

		if (rdto == null) { // No same region exists
			if (dto.getMf_img().getSize() != 0) { // Image uploaded
				byte[] pic = dto.getMf_img().getBytes();
				dto.setByte_img(pic);
				regionDAO.addRegionWithImage(dto);

			} else { // Didn't upload image
				regionDAO.addRegionWithoutImage(dto);
			}
		}

		m.addAttribute("rdto", rdto);

		return "/region/addLocationPro";
	}

	@RequestMapping("/deleteLocationPro")
	public String session_deleteLocationPro(String location, Model m) throws Exception {

		int clubCount = clubDAO.getRegionClubCount(location);
		if (clubCount == 0) {
			regionDAO.deleteRegion(location);
		}

		m.addAttribute("clubCount", clubCount);

		return "/region/deleteLocationPro";
	}

	@RequestMapping("/editLocation")
	public String session_editLocation(String location, Model m) throws Exception {

		RegionDTO regionDTO = regionDAO.getRegion(location);

		byte[] byteimage = regionDAO.getImage(location);

		String img = null;
		if (byteimage != null) {
			img = Base64.getEncoder().encodeToString(byteimage);
		}

		m.addAttribute("regionDTO", regionDTO);
		m.addAttribute("img", img);

		return "/region/editLocation";
	}

	@RequestMapping("/editLocationPro")
	public String session_editLocationPro(RegionDTO dto, Model m) throws Exception {

		if (dto.getMf_img().getSize() != 0) { // Image uploaded
			byte[] pic = dto.getMf_img().getBytes();
			dto.setByte_img(pic);
			regionDAO.updateRegionWithImage(dto);
		} else { // Didn't upload image
			regionDAO.updateRegionWithoutImage(dto);
		}

		m.addAttribute("location", dto.getLocation());

		return "/region/editLocationPro";
	}

}
