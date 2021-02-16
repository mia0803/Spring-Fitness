package com.model.service;

import java.util.ArrayList;

import com.model.dtogroups.PostDTO;

public interface PostService {

	public int getCount() throws Exception;
	
	public int getCountOfSearch(String content) throws Exception;
	
	public ArrayList<Object> getAllPosts(PostDTO dto) throws Exception;
	
	public ArrayList<Object> getPostsOfSearch(PostDTO dto) throws Exception;
	
	public void upView(int id) throws Exception;
	
	public PostDTO getPost(int id) throws Exception;
	
	public void addPost(PostDTO dto) throws Exception;
	
	public void deletePost(int id) throws Exception;
	
	public void updatePost(PostDTO dto) throws Exception;
	
	
	
	
	
	
}
