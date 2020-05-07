package com.demo.editor.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.editor.pojo.NewsEditor;
import com.demo.newseditor.mapper.newseditorServiceImpl;

@Controller
@SessionAttributes(value = {"editorMsg"})

public class NewsEditorController {
	
	@Autowired
	private newseditorServiceImpl newseditorServiceimpl;
	
	@RequestMapping("/NewEditorLogin")
	public String NewEditorlogin(){
		//跳转到新闻编辑登录界面
		return "NewsEditor/NewEditorLogin";
	}
	
	@RequestMapping("/NewEditorloginMsg")
	public String NewEditorlogin(String name,String password,Model model){
		//测试是否能接收到前端的账号和密码
		System.out.println(name+":"+password);
		try {
			//此处开始获取新闻编辑的用户信息		
			NewsEditor editorMsg = newseditorServiceimpl.setNewsEditorMsg(name);
			
			System.out.println(editorMsg.getName());
			System.out.println(editorMsg.getPassword());

			if(editorMsg.getPassword().equals(password)){
				model.addAttribute("editorMsg", editorMsg);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("跳转...");
		return "NewsEditor/NewsEditorMassage";
	}
}
