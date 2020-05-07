package com.demo.toutiao.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.editor.pojo.ImageDB;
import com.demo.editor.pojo.TopImage;

@Service
@Transactional
public class ToutiaoServiceImpl implements ToutiaoService {

	@Autowired
	private Toutiao toutiao;
	
	
//  读取置顶图片中最大的id,也就是说每次查询返回最新的结果
	@Override
	public int showImageId() {
		// TODO Auto-generated method stub
		return toutiao.readImageId();
	}

//	根据上面读取到的id，来获得数据表中的图片
	@Override
	public TopImage showTopImage(int id) {
		// TODO Auto-generated method stub
		return toutiao.getTopImage(id);
	}
	
//	根据id获取文章内容
	@Override
	public ImageDB setImageDB(int id) {
		// TODO Auto-generated method stub
		return toutiao.getImageDB(id);
	}
	
}
