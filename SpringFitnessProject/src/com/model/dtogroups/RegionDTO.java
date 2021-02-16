package com.model.dtogroups;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

public class RegionDTO {
	private int id;
	private String location;
	private String loc_desc;
	private int total_n;

	private MultipartFile mf_img; // when admin upload club picture to db
	private Blob loc_img; // when you get image from db
	private byte[] byte_img;

	public int getTotal_n() {
		return total_n;
	}

	public void setTotal_n(int total_n) {
		this.total_n = total_n;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLoc_desc() {
		return loc_desc;
	}

	public void setLoc_desc(String loc_desc) {
		this.loc_desc = loc_desc;
	}

	public MultipartFile getMf_img() {
		return mf_img;
	}

	public void setMf_img(MultipartFile mf_img) {
		this.mf_img = mf_img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blob getLoc_img() {
		return loc_img;
	}

	public void setLoc_img(Blob loc_img) {
		this.loc_img = loc_img;
	}

	public byte[] getByte_img() {
		return byte_img;
	}

	public void setByte_img(byte[] byte_img) {
		this.byte_img = byte_img;
	}
}
