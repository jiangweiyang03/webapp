package com.yousoft.cfapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yousoft.cfapi.dao.ZandetailMapper;
import com.yousoft.cfapi.entity.Zandetail;
import com.yousoft.cfapi.service.ZanService;

@Service
public class ZanServiceImpl implements ZanService {
	
	@Autowired
	private ZandetailMapper zanDetailMapper;
	

	@Override
	public List<String> findUserIdListByTextId(String textid) {
		return zanDetailMapper.findZanListByTextId(Integer.valueOf(textid));
	}
	

	@Override
	public List<Zandetail> getZanDetailsByTextId(String textid) {
		return null;
	}

}
