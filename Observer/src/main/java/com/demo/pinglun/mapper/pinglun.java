package com.demo.pinglun.mapper;

import java.util.List;

import com.demo.editor.pojo.PingLun;

public interface pinglun {

	//根据时间来查询评论
	List<PingLun> getPinglun(String time);
	
	//插入评论信息
	int setPinglunMsg(PingLun pingLun);
}
