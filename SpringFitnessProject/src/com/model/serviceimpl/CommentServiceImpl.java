package com.model.serviceimpl;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dtogroups.CommentDTO;
import com.model.service.CommentService;

@Service("commentDAO")
public class CommentServiceImpl implements CommentService{

	@Autowired
	SqlSessionTemplate sqlPrepared = null;

	@Override
	public int getCommentCount(int post_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("commentsSqlDAO.getCommentCount", post_id);
	}

	@Override
	public void addComment(CommentDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("commentsSqlDAO.addComment", dto);
	}

	@Override
	public void addReply(CommentDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("commentsSqlDAO.addReply", dto);
	}

	@Override
	public ArrayList<Object> getComment(int post_id) throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("commentsSqlDAO.getComment", post_id);
	}

	@Override
	public void delete(int comment_id) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("commentsSqlDAO.delete", comment_id);
	}
	
	
	
	
}
