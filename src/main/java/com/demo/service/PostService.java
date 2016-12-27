package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.model.MainPost;


public interface PostService {

	List<MainPost> getAll();

	void deleteById(int id);

	void updateById(MainPost post);

	MainPost getById(int id);

	void add(MainPost post);

	
}
