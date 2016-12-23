package com.demo.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Controller
@RequestMapping("/freeMarker")
public class HelloController {
  
	@RequestMapping("/hello")
	// 跳转到ftl模板页面
	public String sayHello(ModelMap map) {
		System.out.println("say Hello ……");
		map.addAttribute("name", " skdfhsdkhgk   World!");
		return "/hello.ftl";
	}

	@RequestMapping("/hi")
	// 跳转到ftl模板页面
	public String sayHi(ModelMap map) {
		System.out.println("say hi ……");
		map.put("name", "jojo");
		return "/hi.ftl";
	}

	@RequestMapping("/temp")
	// 跳转到JSP页面
	public String jspRequest(ModelMap map) {
		System.out.println("jspRequest ……");
		map.put("name", " to temp jsp");
		return "/temp.jsp";
	}

	@RequestMapping("/tolist")
	// 根据指定的ftl文件生成word
	public String tolist(ModelMap map) {
		System.out.println("tolist ……");


		List list = new ArrayList();
		for (int i = 0; i < 10; i++) {
			User u1 = new User();
			u1.setName("张三");
			u1.setAge(12);
			u1.setSex("男");
			list.add(u1);
		}


		map.put("userList", list);
		
		
		return "/test.ftl";
	}

	@RequestMapping("/toword")
	// 根据指定的ftl文件生成word
	public String toword(ModelMap map) {
		System.out.println("toword ……");

		User u1 = new User();
		u1.setName("张三");
		u1.setAge(12);
		u1.setSex("男");
		User u2 = new User();
		u2.setName("张三222");
		u2.setAge(32);
		u2.setSex("女");
		List list = new ArrayList();
		list.add(u1);
		list.add(u2);

		map.put("userList", list);
		map.put("remark", "这是freemarker表格填充");
		
		//填充word数据
		createDoc(map,"test_user_word.ftl","D:/ftl/test.doc");

		return "/test2.ftl";
	}

	/**
	 * 创建word
	 * @param map
	 * @param tplName
	 * @param toUrl
	 */
	public void createDoc(Map map,String tplName,String toUrl){
		Configuration config = new Configuration();
		
		System.out.println("====config===="+config);
		
		config.setDefaultEncoding("utf-8");
		//这里我们的模板是放在com.havenliu.document.template包下面
		config.setClassForTemplateLoading(this.getClass(), "/com/template");
		Template t = null;  //获取模板
		try {
			 
			t = config.getTemplate(tplName);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出文档路径及名称
		File outFile = new File(toUrl);
		if(!outFile.exists()){
			try {
				outFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			t.process(map, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
