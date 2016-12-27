package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.PostDao;
import com.demo.model.MainPost;
import com.demo.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostDao postDao;
	
	@Override
	public List<MainPost> getAll(){
		
		return postDao.getAll();
		
	}

	@Override
	public void deleteById(int id) {
		postDao.deleteById(id);
		
	}

	@Override
	public void updateById(MainPost post) {
		postDao.updateById(post);
		
	}

	@Override
	public MainPost getById(int id) {
		
		return postDao.getById(id);
		
	}

	@Override
	public void add(MainPost post) {
		postDao.add(post);
		
	}
	
	public String sayHello(){
		return "hello";
	}
}
