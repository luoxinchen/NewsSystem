package com.demo.newseditor.mapper;

import com.demo.editor.pojo.NewsEditor;

public interface newseditor {

	//通过用户名查询，来判断新闻编辑是否密码错误
	NewsEditor getNewsEditorMsg(String name);
}
