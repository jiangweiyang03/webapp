package com.yousoft.cfapi.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yousoft.cfapi.dao.PubcontentMapper;
import com.yousoft.cfapi.entity.Pubcontent;
import com.yousoft.cfapi.entity.model.ContentView;
import com.yousoft.cfapi.entity.model.FContentView;
import com.yousoft.cfapi.entity.model.FriendPageView;
import com.yousoft.cfapi.service.ContentService;
import com.yousoft.cfapi.service.PlService;
import com.yousoft.cfapi.service.ZanService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private PubcontentMapper contentMapper;
	@Autowired
	private ZanService zanService;
	@Autowired
	private PlService plService;

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
	
	@Override
	public int pubSharedUrl(String title, String url, String userid) {
		Pubcontent pubContent = new Pubcontent();
		pubContent.setText(title);
		pubContent.setUrl(url);
		pubContent.setPubuid(userid);
		pubContent.setPlcount(BigDecimal.valueOf(0L));
		pubContent.setZancount(BigDecimal.valueOf(0L));
		contentMapper.insertSelective(pubContent);
		return 1;
	}



	@Override
	public List<ContentView> findUserList(String userid, int pagenum,
			int pagesize) {
		// 根据朋友关系查询到当前满足条件的分享列表
		Integer pageStart = (pagenum - 1) * pagesize;
		Integer pageEnd = pagenum * pagesize;
		// 获取所有的有内容集合
		List<Pubcontent> contentList = contentMapper.findContentByPage(userid,
				pageStart, pageEnd);
		if (contentList == null || contentList.size() < 1) {
			return null;
		} else {
			// 关联赞信息和评论信息
			List<ContentView> viewList = new ArrayList<ContentView>();
			ContentView view = null;
			for (Pubcontent content : contentList) {
				view = new ContentView(content);
				view.setZanlist(zanService.findUserIdListByTextId(content.getCtid().toString(),userid));
				view.setPldetails(plService.findPlViewListByTextId(content.getCtid().intValue(),userid));
				viewList.add(view);
			}
			return viewList;
		}
	}

	@Override
	public FriendPageView findFriendPage(String userid, int pagenum,
			int pagesize) {
		Integer pageStart = (pagenum - 1) * pagesize;
		Integer pageEnd = pagenum * pagesize;
		List<Pubcontent> contentList = contentMapper.findContentByUserId(
				userid, pageStart, pageEnd);
		if (contentList == null || contentList.size() < 1) {
			return null;
		} else {
			FriendPageView pageView = new FriendPageView();
			pageView.setUserid(userid);
			List<FContentView> fViewList = new ArrayList<FContentView>();
			FContentView view = null;
			for (Pubcontent content : contentList) {
				view = new FContentView(content);
				fViewList.add(view);
			}
			pageView.setContentlist(fViewList);
			return pageView;
		}
	}

	@Override
	public ContentView findContentDetails(String textid) {
		Pubcontent content = contentMapper.findContentByTextId(Integer
				.valueOf(textid));
		if (content != null) {
			ContentView view = new ContentView(content);
			return view;
		}
		return null;
	}

	@Override
	public int countNews(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
