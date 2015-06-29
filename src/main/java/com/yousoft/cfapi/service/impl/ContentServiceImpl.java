package com.yousoft.cfapi.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yousoft.cfapi.dao.PubcontentMapper;
import com.yousoft.cfapi.entity.Pubcontent;
import com.yousoft.cfapi.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private PubcontentMapper contentMapper;

	@Override
	public int pubContent(String content, String photolist, String userid) {
		Pubcontent pubContent = new Pubcontent();
		pubContent.setText(content);
		pubContent.setPhoto(photolist);
		pubContent.setPubuid(userid);
		pubContent.setPlcount(BigDecimal.valueOf(0L));
		pubContent.setZancount(BigDecimal.valueOf(0L));
		contentMapper.insertSelective(pubContent);
		return 1;
	}

}
