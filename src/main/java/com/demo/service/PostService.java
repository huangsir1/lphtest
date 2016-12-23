package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.PostDao;
import com.demo.model.MainPost;

@Service
public class PostService {

	@Autowired
	PostDao postDao;
	
	public List<MainPost> getAll(){
		
		return postDao.getAll();
		
	}
}
