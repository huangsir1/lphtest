package com.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.model.MainPost;
@Repository
public interface PostDao {
	public List<MainPost> getAll();

	public void deleteById(int id);

	public void updateById(MainPost post);

	public MainPost getById(int id);

	public void add(MainPost post);
}
