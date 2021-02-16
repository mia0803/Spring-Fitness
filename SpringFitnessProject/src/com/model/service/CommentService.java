package com.model.service;

import java.util.ArrayList;

import com.model.dtogroups.CommentDTO;


public interface CommentService {

	public int getCommentCount(int post_id) throws Exception;
	
	public void addComment(CommentDTO dto) throws Exception;
	
	public void addReply(CommentDTO dto) throws Exception;
	
	public ArrayList<Object> getComment(int post_id) throws Exception;
	
	public void delete(int comment_id) throws Exception;
	
	
	
}
