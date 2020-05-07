package com.demo.editor.pojo;

import java.util.Date;

/**
 *此类是把WriterArticle的值转存进此类，之后此类与sql进行处理
 * 
 *
 */

public class ImageDB {
	private int id;
	//文章简介
	private String writeId;
	//封面图片
	private byte[] image;
	//标题
	private String title;
	//文章存储的时间
	private String time;
	//文章
	private String article;
	//来源
	private String source;
	//编辑
	private String editor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriteId() {
		return writeId;
	}
	public void setWriteId(String writeId) {
		this.writeId = writeId;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
