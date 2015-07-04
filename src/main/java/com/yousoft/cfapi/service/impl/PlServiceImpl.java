package com.yousoft.cfapi.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yousoft.cfapi.dao.ReplydetailMapper;
import com.yousoft.cfapi.entity.Replydetail;
import com.yousoft.cfapi.entity.model.PlView;
import com.yousoft.cfapi.service.PlService;

@Service
public class PlServiceImpl implements PlService {

	@Autowired
	private ReplydetailMapper replyDetailMapper;

	@Override
	public int addReply(String textid, String usersrc, String userdest,
			String content) {
		Replydetail detail = new Replydetail();
		detail.setReply(content);
		detail.setReplytime(new Date());
		detail.setReplytype(BigDecimal.valueOf(1L));
		detail.setTextid(BigDecimal.valueOf(Long.valueOf(textid)));
		detail.setUserfrom(usersrc);
		detail.setUserto(userdest);
		replyDetailMapper.insertSelective(detail);
		return 1;
	}

	@Override
	public int addPl(String textid, String usersrc, String content) {
		Replydetail detail = new Replydetail();
		detail.setReply(content);
		detail.setReplytime(new Date());
		detail.setReplytype(BigDecimal.valueOf(0L));
		detail.setTextid(BigDecimal.valueOf(Long.valueOf(textid)));
		detail.setUserfrom(usersrc);
		replyDetailMapper.insertSelective(detail);
		return 1;
	}

	@Override
	public List<PlView> findPlViewListByTextId(Integer textid, String userid) {
		return replyDetailMapper.findPlViewListByTextId(textid, userid);
	}

}
