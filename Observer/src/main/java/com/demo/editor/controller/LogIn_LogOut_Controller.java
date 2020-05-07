package com.demo.editor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.editor.pojo.Users;
import com.demo.login_logout.mapper.login_logoutServiceImpl;

@Controller
public class LogIn_LogOut_Controller {
	
	@RequestMapping("/Login")
	public String login(){
		return "Login";
	}
	
	
	
	//管理员登录
	@RequestMapping("/adminloginMsg")
	public String adminloginMsg(){
		return "Login";
	}
}
