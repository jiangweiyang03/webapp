package com.yousoft.cfapi.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
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
			String contenttype, String value) {
		logger.info("cachevalue : " + userid + "," + usersrcid + "," + content
				+ "," + contenttype + "," + value);
		if ("0".equals(contenttype)) {
			// 评论信息
			if (jedis.exists(userid + "_" + "pl")) {
				if ("0".equals(value)) {
					jedis.incr(userid + "_" + "pl");
				} else {
					jedis.decr(userid + "_" + "pl");
				}
			} else {
				jedis.set(userid + "_pl", "1");
			}
		} else if ("1".equals(contenttype)) {
			// 回复信息
			if (jedis.exists(userid + "_" + "zan")) {
				if ("0".equals(value)) {
					jedis.incr(userid + "_" + "zan");
				} else {
					jedis.decr(userid + "_" + "zan");
				}
			} else {
				jedis.set(userid + "_zan", "1");
			}
		} else {
			logger.info("error type:" + contenttype);
		}
		if ("0".equals(contenttype) || "1".equals(contenttype)
				|| "2".equals(contenttype)) {
			// 添加内容
			List<NewsView> list = null;
			if ("0".equals(value)) {
				if ("1".equals(contenttype)) {
					// 单用户回复信息
					if (jedis.exists(userid)) {
						String returnJson = jedis.get(userid);
						list = (List<NewsView>) JSONObject.toBean(
								JSONObject.fromObject(returnJson), List.class);
					} else {
						list = new ArrayList<NewsView>();
					}
					NewsView newsView = new NewsView();
					newsView.setNewtime(String.valueOf(System
							.currentTimeMillis()));
					newsView.setContent(content);
					newsView.setNewtype(contenttype);
					newsView.setUsersrc(usersrcid);
					list.add(newsView);
					jedis.set(userid, JSONObject.fromObject(list).toString());
					logger.info("cachevalue finish");
				} else {
					// 评论所有信息
				}
			} else {
				if (jedis.exists(userid)) {
					String returnJson = jedis.get(userid);
					list = (List<NewsView>) JSONObject.toBean(
							JSONObject.fromObject(returnJson), List.class);
					NewsView deleteModel = null;
					for (NewsView newView : list) {
						if (newView.getUsersrc().equals(usersrcid)
								&& newView.getNewtype().equals(contenttype)) {
							deleteModel = newView;
							break;
						}
					}
					list.remove(deleteModel);
					jedis.set(userid, JSONObject.fromObject(list).toString());
					logger.info("cachevalue delete finish");
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<NewsView> findNewsViewList(String userid) {
		if (jedis.exists(userid)) {
			String returnJson = jedis.get(userid);
			List<NewsView> list = (List<NewsView>) JSONObject.toBean(
					JSONObject.fromObject(returnJson), List.class);
			jedis.del(userid);
			return list;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addNews(String userid) {
		String relationKey = "Relation_" + userid;
		boolean existsKey = jedis.exists(relationKey);
		if (existsKey) {
			String friendStr = jedis.get(relationKey);
			Set<String> friendSet = (Set<String>) JSONObject.toBean(
					JSONObject.fromObject(friendStr), Set.class);
			Iterator<String> it = friendSet.iterator();
			String value = null;
			String nKey = null;
			while (it.hasNext()) {
				value = it.next();
				nKey = "view_" + value + "_" + userid;
				if ("0".equals(jedis.get(nKey))) {
					nKey = "bview_" + userid + "_" + value;
					if ("0".equals(jedis.get(nKey))) {
						nKey = "news_" + value;
						if (jedis.exists(nKey)) {
							jedis.incr(nKey);
						} else {
							jedis.set(nKey, "1");
						}
					}
				}
			}
		}
	}

	@Override
	public boolean isNews(String userid) {
		String key = "news_" + userid;
		if (jedis.exists(key)) {
			if (StringUtils.isNotEmpty(jedis.get(key))) {
				logger.info("news cache:+" + jedis.get(key));
				jedis.del(key);
				return true;
			}
		}
		return false;
	}

	@Override
	public void updatePrivilege(String userid, String userdestid,
			String pritype, String privalue) {
		String key = "Relation_" + userid;
		boolean existsKey = jedis.exists(key);
		if (existsKey) {
			if ("0".equals(pritype)) {
				String viewKey = "view_" + userid + "_" + userdestid;
				jedis.set(viewKey, privalue);
			} else if ("1".equals(pritype)) {
				String bViewKey = "bview_" + userid + "_" + userdestid;
				jedis.set(bViewKey, privalue);
			}
		} else {
			logger.error("src:" + userid + ",dest:" + userdestid
					+ " has no relation");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateRelation(String userid, String userdestid,
			String relationtype) {
		String key = "Relation_" + userid;
		boolean existsKey = jedis.exists(key);
		Set<String> friendSet = null;
		String viewKey = "view_" + userid + "_" + userdestid;
		String bViewKey = "bview_" + userid + "_" + userdestid;
		if (existsKey) {
			// 该用户已存在朋友关联关系
			String friendStr = jedis.get(key);
			friendSet = (Set<String>) JSONObject.toBean(
					JSONObject.fromObject(friendStr), Set.class);
			if ("0".equals(relationtype)) {
				friendSet.add(userdestid);
				jedis.set(viewKey, "0");
				jedis.set(bViewKey, "0");
			} else {
				friendSet.remove(userdestid);
				jedis.del(viewKey);
				jedis.del(bViewKey);
			}
			jedis.set(key, JSONObject.fromObject(friendSet).toString());
		} else {
			// 该用户之间不存在朋友关系
			if ("0".equals(relationtype)) {
				friendSet = new HashSet<String>();
				friendSet.add(userdestid);
				jedis.set(key, JSONObject.fromObject(friendSet).toString());
				jedis.set(viewKey, "0");
				jedis.set(bViewKey, "0");
			} else {
				logger.error("userid:" + userid + " relation has not initial");
			}
		}

	}

}
