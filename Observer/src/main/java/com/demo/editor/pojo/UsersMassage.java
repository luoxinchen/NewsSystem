package com.demo.editor.pojo;

/**
 * 
 * 此实体类的作用：
 * 		封装用户的所有个人信息
 * @author Administrator
 *
 */

public class UsersMassage {
	// id
	private int id;
	// 头像
	private byte[] headimage;
	// 用户名
	private String name;
	// 性别
	private String sex;
	// 电子邮箱
	private String email;
	// 工作
	private String job;
	// 手机号码
	private int phonenumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getHeadimage() {
		return headimage;
	}
	public void setHeadimage(byte[] headimage) {
		this.headimage = headimage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
}
