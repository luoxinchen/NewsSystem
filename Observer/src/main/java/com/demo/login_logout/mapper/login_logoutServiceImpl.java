package com.demo.login_logout.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.editor.pojo.Users;

@Service
@Transactional
public class login_logoutServiceImpl implements login_logoutService {

	@Autowired
	private login_logout login_logout;

	//登录查询用户账号密码
	@Override
	public Users setUsersName(Users users) {
		// TODO Auto-generated method stub
		return this.login_logout.getUsersName(users);
	}
}
