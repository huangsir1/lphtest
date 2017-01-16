package com.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MainPost;
import com.demo.service.PostService;
@Controller
public class PostController {
	@Resource
	PostService postService;
	
	@RequestMapping("getAllPost")
	@ResponseBody
	public  List<MainPo> getAllPost(){
		
		System.out.println(postService.getAll().get(0).toString());
		return postService.getAll();
		
	}	
//	@RequestMapping("getAllPost1")
//	public  String getAllPost1(ModelMap map){
//		
//		System.out.println(postService.getAll().get(0).toString());
//		map.put("postList", postService.getAll());
//		return "/postlist.ftl";
//		
//	}

	@RequestMapping("getAllPost1")
	public  ModelAndView getAllPost2(){
		
		ModelAndView mv=new ModelAndView();
		List<MainPost> posts=postService.getAll();
		mv.addObject("postList", posts);
		mv.setViewName("/postlist.ftl");
		
		return mv;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public void add(MainPost post){
		
		System.out.println("add....");
		postService.add(post);
	}
	
	@RequestMapping("deleteById")
	@ResponseBody
	public void deleteById(@RequestParam(value="id") int id){
		System.out.println("deleteById");
		postService.deleteById(id);
	}
	
	@RequestMapping("updateById")
	@ResponseBody
	public void updateById(MainPost post){
		postService.updateById(post);
	}
	
	@RequestMapping("getById")
	@ResponseBody
	public String getById(@RequestParam int id){
		MainPost post=postService.getById(id);
		System.out.print(post.toString());
		return post.toString();
		
	}
}
