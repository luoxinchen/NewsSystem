package com.demo.editor.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.editor.pojo.ImageDB;
import com.demo.editor.pojo.TopImage;


@Service
@Transactional
public class uploadServiceImpl implements uploadService {
	
//引入绑定sql语句的接口
	@Autowired
	private upload upload01;
	
//————————————————————————————————————————————————————————————
	//	置顶文章插入数据库
	@Override
	public void uploadService(ImageDB imageDB) {
		this.upload01.insertPhoto(imageDB);
	}
//————————————————————————————————————————————————————————————
	//	头条文章插入数据库
	@Override
	public void insertToutiao(ImageDB imageDB) {
		// TODO Auto-generated method stub
		this.upload01.insertToutiao(imageDB);
	}

//————————————————————————————————————————————————————————————
	//	普通文章插入数据库
	@Override
	public void insertNews(ImageDB imageDB) {
		// TODO Auto-generated method stub
		this.upload01.insertNews(imageDB);
	}

//————————————————————————————————————————————————————————————
	
	
	
	
	
	
	
//  读取置顶图片中最大的id,也就是说每次查询返回最新的结果
//————————————————————————————————————————————————————————————
	@Override
	public int showImageId() {
	    return this.upload01.readImageId();
	}

//	根据上面读取到的id，来获得数据表中的图片
	@Override
	public TopImage showTopImage(int id) {
		return this.upload01.getTopImage(id);
	}

//	根据id获取文章内容
	@Override
	public ImageDB setImageDB(int id) {
		// TODO Auto-generated method stub
		return this.upload01.getImageDB(id);
	}


	
}
