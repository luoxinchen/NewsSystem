package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Observer
 */
@SpringBootApplication
@MapperScan({"com.demo.pinglun.mapper","com.demo.newseditor.mapper","com.demo.editor.mapper","com.demo.login_logout.mapper","com.demo.toutiao.mapper","com.demo.news.mapper","com.demo.user.mapper"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}	