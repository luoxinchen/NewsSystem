package com.demo.news.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.editor.pojo.ImageDB;


@Service
@Transactional
public class newsServiceImpl implements newsService {

	@Autowired
	private news news;
	
	@Override
	public List<ImageDB> getNews() {
		// TODO Auto-generated method stub
		return this.news.getNews();
	}

}
