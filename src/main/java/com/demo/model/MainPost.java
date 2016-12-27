package com.demo.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class MainPost {
	private int id;
	private int post_author;

	private Date post_date;
	private String post_title;
	private String post_status;
	private String comment_status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPost_author() {
		return post_author;
	}
	public void setPost_author(int post_author) {
		this.post_author = post_author;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_status() {
		return post_status;
	}
	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}
	public String getComment_status() {
		return comment_status;
	}
	public void setComment_status(String comment_status) {
		this.comment_status = comment_status;
	}
	@Override
	public String toString() {
		return "MainPost [id=" + id + ", post_author=" + post_author
				+ ", post_date=" + post_date + ", post_title=" + post_title
				+ ", post_status=" + post_status + ", comment_status="
				+ comment_status + "]";
	}

}
