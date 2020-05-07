package com.demo.user.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.editor.pojo.UsersMassage;

@Service
@Transactional
public class usermsgserviceImpl implements usermsgservice{

	@Autowired
	private usermsg usermsg;
	
	@Override
	public UsersMassage setUsersMassage(String name) {
		// 	根据用户名查找相应用户的所有信息
		return this.usermsg.getUsersMassage(name);
	}
}
