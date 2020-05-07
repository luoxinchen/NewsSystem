package com.demo.toutiao.mapper;

import com.demo.editor.pojo.ImageDB;
import com.demo.editor.pojo.TopImage;

public interface ToutiaoService {

//  读取置顶图片中最大的id,也就是说每次查询返回最新的结果
	int showImageId();
	
//	根据上面读取到的id，来获得数据表中的图片
	TopImage showTopImage(int id);
	
//	根据id获取文章内容
	ImageDB setImageDB(int id);
	
}
