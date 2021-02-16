package com.model.serviceimpl;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dtogroups.PostDTO;
import com.model.service.PostService;

@Service("postDAO")
public class PostServiceImpl implements PostService {

	@Autowired
	SqlSessionTemplate sqlPrepared = null;

	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("postSqlDAO.getCount");
	}

	@Override
	public int getCountOfSearch(String content) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("postSqlDAO.getCountOfSearch", content);
	}

	@Override
	public ArrayList<Object> getAllPosts(PostDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("postSqlDAO.getAllPosts", dto);
	}

	@Override
	public ArrayList<Object> getPostsOfSearch(PostDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Object>) sqlPrepared.selectList("postSqlDAO.getPostsOfSearch", dto);
	}

	@Override
	public void upView(int id) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("postSqlDAO.upView", id);
	}

	@Override
	public PostDTO getPost(int id) throws Exception {
		// TODO Auto-generated method stub
		return sqlPrepared.selectOne("postSqlDAO.getPost", id);
	}

	@Override
	public void addPost(PostDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.insert("postSqlDAO.addPost", dto);
	}

	@Override
	public void deletePost(int id) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("postSqlDAO.deletePost", id);
	}

	@Override
	public void updatePost(PostDTO dto) throws Exception {
		// TODO Auto-generated method stub
		sqlPrepared.update("postSqlDAO.updatePost", dto);
	}
	
	
	
	
}
