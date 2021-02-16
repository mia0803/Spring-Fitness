package com.model.dtogroups;

import java.sql.Blob;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class ClubDTO {
	private int club_id;
	private String club_name;
	private String address;
	private String phone;
	private String location;
	private String club_desc;
	private MultipartFile img_mf; // when admin upload club picture to db
	private Map<String, Object> img_hmap; // use this field to add to db
	private Blob club_img; // when you get image from db
	private String base64Image; // transform blob image to base64 string to display
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getClub_id() {
		return club_id;
	}
	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}
	public String getClub_desc() {
		return club_desc;
	}
	public void setClub_desc(String club_desc) {
		this.club_desc = club_desc;
	}
	public Map<String, Object> getImg_hmap() {
		return img_hmap;
	}
	public void setImg_hmap(Map<String, Object> img_hmap) {
		this.img_hmap = img_hmap;
	}
	public MultipartFile getImg_mf() {
		return img_mf;
	}
	public void setImg_mf(MultipartFile img_mf) {
		this.img_mf = img_mf;
	}
	public Blob getClub_img() {
		return club_img;
	}
	public void setClub_img(Blob club_img) {
		this.club_img = club_img;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
}
