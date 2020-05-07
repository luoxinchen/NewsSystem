package com.demo.user.mapper;

import com.demo.editor.pojo.UsersMassage;

public interface usermsgservice {

	// 	根据用户名查找相应用户的所有信息
	UsersMassage setUsersMassage(String name);
}
