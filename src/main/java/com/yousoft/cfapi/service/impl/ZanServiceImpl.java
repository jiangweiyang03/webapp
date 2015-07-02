package com.yousoft.cfapi.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yousoft.cfapi.dao.ZandetailMapper;
import com.yousoft.cfapi.entity.Zandetail;
import com.yousoft.cfapi.entity.ZandetailExample;
import com.yousoft.cfapi.entity.ZandetailExample.Criteria;
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
	public void addZan(String textid, String userid) {
		Zandetail zanDetail = new Zandetail();
		zanDetail.setTextid(BigDecimal.valueOf(Long.valueOf(textid)));
		zanDetail.setUserid(userid);
		zanDetailMapper.insertSelective(zanDetail);
	}
	
	@Override
	public void cancleZan(String textid, String userid) {
		ZandetailExample example = new ZandetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andTextidEqualTo(BigDecimal.valueOf(Long.valueOf(textid)));
		criteria.andUseridEqualTo(userid);
		zanDetailMapper.deleteByExample(example);
	}
}
