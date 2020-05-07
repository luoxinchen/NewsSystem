package com.demo.newseditor.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.editor.pojo.NewsEditor;

@Service
@Transactional
public class newseditorServiceImpl implements newseditorService {

	@Autowired
	private newseditor newseditor;

	@Override
	public NewsEditor setNewsEditorMsg(String name) {
		// TODO Auto-generated method stub
		return this.newseditor.getNewsEditorMsg(name);
	}
}
