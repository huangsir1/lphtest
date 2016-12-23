package com.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.model.MainPost;
@Repository
public interface PostDao {
	public List<MainPost> getAll();
}
