package com.demo.editor.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.editor.pojo.PingLun;
import com.demo.pinglun.mapper.pinglunServiceImpl;

@Controller
public class PingLunController {

	@Autowired
	private pinglunServiceImpl pinglunServiceimpl;
	
	@RequestMapping("/pinglun")
	public String pinglun(String pinglunzhe,String xinwendeshijian,String textarea){
			System.out.println(textarea);
			System.out.println(pinglunzhe);
			/**
			 * 此处是把信息存入数据库，前端代码和查询评论模块会自动查询出当前；
			 * 要获取到评论的文章的时间（代替ID），和当前评论的时间；
			 * 赞和踩就不写了
			 */
			
			//此处存在bug，等会修改
			PingLun pingLun = new PingLun();
			
			pingLun.setPinglun(textarea);
			pingLun.setPinglundewenzhang(xinwendeshijian);;
			pingLun.setPinglunzhe(pinglunzhe);
			
			LocalDateTime localDateTime = LocalDateTime.now();
		    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			pingLun.setTime(localDateTime.format(dtf));
			
			pingLun.setZan(0);
			pingLun.setCai(0);
			
			pinglunServiceimpl.setPinglunMsg(pingLun);
			
		
		return "index";
	}
}
