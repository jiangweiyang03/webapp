package com.yousoft.cfapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.yousoft.cfapi.entity.model.NewsView;
import com.yousoft.cfapi.service.RedisService;
import com.yousoft.cfapi.util.RedisUtils;

@Service
public class RedisServiceImpl extends RedisUtils implements RedisService {
	/** 日志对象 **/
	private static Logger logger = LoggerFactory
			.getLogger(RedisServiceImpl.class);
	/** 缓存对象 **/
	private static Jedis jedis = null;

	static {
		try {
			jedis = RedisUtils.getJedis();
			if (jedis != null)
				logger.info("Redid对象他建对象");
		} catch (Exception ex) {
			logger.error(ExceptionUtils.getFullStackTrace(ex));
		}
	}

	@SuppressWarnings("unchecked")
	public void addListValue(String userid, String usersrcid, String content,
			String contenttype) {
		logger.info("cachevalue : " + userid + "," + usersrcid + "," + content
				+ "," + contenttype);
		if ("0".equals(contenttype)) {
			// 评论信息
			if (jedis.exists(userid + "_" + "pl")) {
				jedis.incr(userid + "_" + "pl");
			} else {
				jedis.set(userid + "_pl", "1");
			}
		} else if ("1".equals(contenttype)) {
			// 回复信息
			if (jedis.exists(userid + "_" + "zan")) {
				jedis.incr(userid + "_" + "zan");
			} else {
				jedis.set(userid + "_zan", "1");
			}
		} else {
			logger.info("error type:" + contenttype);
		}
		if ("0".equals(contenttype) || "1".equals(contenttype)) {
			List<NewsView> list = null;
			if(jedis.exists(userid)) {
				String returnJson = jedis.get(userid);
				list = (List<NewsView>)JSONObject.toBean(JSONObject.fromObject(returnJson), List.class);
			} else {
				list = new ArrayList<NewsView>();
			}
			NewsView newsView = new NewsView();
			newsView.setNewtime(String.valueOf(System.currentTimeMillis()));
			newsView.setContent(content);
			newsView.setNewtype(contenttype);
			newsView.setUsersrc(usersrcid);
			list.add(newsView);
			jedis.set(userid, JSONObject.fromObject(list).toString());
			logger.info("cachevalue finish");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<NewsView> findNewsViewList(String userid) {
		if(jedis.exists(userid)) {
			String returnJson = jedis.get(userid);
			List<NewsView> list = (List<NewsView>)JSONObject.toBean(JSONObject.fromObject(returnJson), List.class);
			return list;
		} else {
			return null;
		}
	}
	
}
