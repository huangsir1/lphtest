package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.service.PostService;
@Controller
public class PostController {
	@Autowired
	PostService postService;
	
	@RequestMapping("getAllPost")
	public  String getAllPost(ModelMap map){
		
		System.out.println(postService.getAll().get(0).toString());
		map.put("postList", postService.getAll());
		return "/postlist.ftl";
		
	}
}
