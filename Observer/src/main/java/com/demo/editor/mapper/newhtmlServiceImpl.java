package com.demo.editor.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.editor.pojo.NewHtml;

@Service
@Transactional
public class newhtmlServiceImpl implements newhtmlService {

	@Autowired
	private newhtml newhtml;
	
	@Override
	public int inserthtmlservice(NewHtml newHtml) {
		// TODO Auto-generated method stub
		return this.newhtml.inserthtml(newHtml);
	}

}
