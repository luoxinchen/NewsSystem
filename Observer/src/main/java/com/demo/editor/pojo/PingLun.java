package com.demo.editor.pojo;
/**
 *评论的实体类 
 */

public class PingLun {
	//主键id
	private int id;
	//评论的语句
	private String pinglun;
	//评论的人
	private String pinglunzhe;
	//这里存的是被评论的文章的time属性
	private String pinglundewenzhang;
	//评论的时间
	private String time;
	//赞的数量
	private int zan;
	//踩的数量
	private int cai;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPinglun() {
		return pinglun;
	}
	public void setPinglun(String pinglun) {
		this.pinglun = pinglun;
	}
	public String getPinglunzhe() {
		return pinglunzhe;
	}
	public void setPinglunzhe(String pinglunzhe) {
		this.pinglunzhe = pinglunzhe;
	}
	public String getPinglundewenzhang() {
		return pinglundewenzhang;
	}
	public void setPinglundewenzhang(String pinglundewenzhang) {
		this.pinglundewenzhang = pinglundewenzhang;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getZan() {
		return zan;
	}
	public void setZan(int zan) {
		this.zan = zan;
	}
	public int getCai() {
		return cai;
	}
	public void setCai(int cai) {
		this.cai = cai;
	}

}
