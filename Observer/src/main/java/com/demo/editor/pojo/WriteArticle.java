package com.demo.editor.pojo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;
/**
 * 此类接收前端传进来的值
 * 
 */
public class WriteArticle {
	//文章简介
	private String writeId;
	//封面图片
	private MultipartFile image;
	//标题
	private String title;
	//文章
	private String article;
	//来源
	private String source;
	//编辑
	private String editor;
	
	public String getWriteId() {
		return writeId;
	}

	public void setWriteId(String writeId) {
		this.writeId = writeId;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
}
