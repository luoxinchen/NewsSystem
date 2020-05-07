package com.demo.user.mapper;

import com.demo.editor.pojo.UsersMassage;

public interface usermsg {
	
	// 	根据用户名查找相应用户的所有信息
	UsersMassage getUsersMassage(String name);
}
