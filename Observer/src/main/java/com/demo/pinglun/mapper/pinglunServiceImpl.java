package com.demo.pinglun.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.editor.pojo.PingLun;

@Service
@Transactional
public class pinglunServiceImpl implements pinglunService {

	@Autowired
	private pinglun pinglun;
	
	@Override
	public List<PingLun> setPinglun(String time) {
		// TODO 自动生成的方法存根
		return this.pinglun.getPinglun(time);
	}

	@Override
	public int setPinglunMsg(PingLun pingLun) {
		// TODO 自动生成的方法存根
		return this.pinglun.setPinglunMsg(pingLun);
	}

}
