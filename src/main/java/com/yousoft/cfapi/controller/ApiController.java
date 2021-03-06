package com.yousoft.cfapi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yousoft.cfapi.entity.model.ContentView;
import com.yousoft.cfapi.entity.model.FriendPageView;
import com.yousoft.cfapi.entity.model.NewsView;
import com.yousoft.cfapi.service.ContentService;
import com.yousoft.cfapi.service.PlService;
import com.yousoft.cfapi.service.PrivilegeService;
import com.yousoft.cfapi.service.RedisService;
import com.yousoft.cfapi.service.ZanService;
import com.yousoft.cfapi.util.ArchState;
import com.yousoft.cfapi.util.TimeUtils;

/**
 * 朋友圈开放接口
 * 
 * @author jiangwy
 * @version 1.0
 */
@RestController
@Scope("prototype")
public class ApiController extends AbstractArchController {

	@Autowired
	private ContentService contentService;
	@Autowired
	private PlService plService;
	@Autowired
	private ZanService zanService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private PrivilegeService privilegeService;

	/**
	 * 内容发布接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pubcontent")
	@ResponseBody
	public Object pubContent(
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "photolist", required = false) String photolist,
			@RequestParam(value = "userid", required = false) String userid) {
		if (StringUtils.isEmpty(userid)) {
			return error("当前用户ID不能为空");
		} else if (StringUtils.isEmpty(content)
				&& StringUtils.isEmpty(photolist)) {
			return error("发布内容不能为空");
		} else {
			if (StringUtils.isEmpty(content)) {
				content = "";
			} else if (StringUtils.isEmpty(photolist)) {
				photolist = "";
			}
			contentService.pubContent(content, photolist, userid);
			redisService.addNews(userid);
			return success("消息发布成功");
		}
	}

	/**
	 * 个人朋友圈列表接口
	 * 
	 * @param userid
	 *            用户ID
	 * @param pagenum
	 *            当前页码
	 * @param pagesize
	 *            页码条数
	 * @return
	 */
	@RequestMapping(value = "/cflist")
	@ResponseBody
	public Object viewPersonList(
			@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "pagenum", required = false) Integer pagenum,
			@RequestParam(value = "pagesize", required = false) Integer pagesize) {
		if (StringUtils.isEmpty(userid)) {
			return error("当前用户ID不能为空");
		} else if (pagenum == null || pagesize == null) {
			pagenum = 1;
			pagesize = 10;
		}
		// 进行实体数据查询
		List<ContentView> viewList = contentService.findUserList(userid,
				pagenum, pagesize);
		if (viewList == null || viewList.size() < 1) {
			return error("没有查询到满足条件消息");
		} else {
			return viewList;
		}
	}

	/**
	 * 查看朋友主页内容
	 * 
	 * @param userid
	 *            朋友ID
	 * @param pagenum
	 *            当前页码
	 * @param pagesize
	 *            页码条数
	 * @return
	 */
	@RequestMapping(value = "/friend")
	@ResponseBody
	public Object viewFriend(
			@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "pagenum", required = false) Integer pagenum,
			@RequestParam(value = "pagesize", required = false) Integer pagesize) {
		if (StringUtils.isEmpty(userid)) {
			return error("当前用户ID不能为空");
		} else if (pagenum == null || pagesize == null) {
			pagenum = 1;
			pagesize = 10;
		}
		// 进行实体数据查询
		FriendPageView pageView = contentService.findFriendPage(userid,
				pagenum, pagesize);
		if (pageView == null) {
			return error("没有查询到满足条件消息");
		} else {
			return pageView;
		}
	}

	/**
	 * 查看消息详情
	 * 
	 * @param textid
	 *            消息ID
	 * @return 当前返回消息内容
	 */
	@RequestMapping(value = "/contdetail")
	@ResponseBody
	public Object contentDetails(
			@RequestParam(value = "textid", required = false) String textid) {
		if (StringUtils.isEmpty(textid)) {
			return error("传入的消息ID不能为空");
		} else {
			return contentService.findContentDetails(textid);
		}
	}

	/**
	 * 回复评论接口
	 * 
	 * @param commtype
	 *            评论类型 0评论 1回复
	 * @param textid
	 *            文本ID
	 * @param content
	 *            评论回复内容
	 * @param usersrc
	 *            回复,评论用户ID
	 * @param userdest
	 *            被回复用户ID
	 * @return
	 */
	@RequestMapping(value = "/comment")
	@ResponseBody
	public Object comment(
			@RequestParam(value = "commtype", required = false) String commtype,
			@RequestParam(value = "textid", required = false) String textid,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "usersrc", required = false) String usersrc,
			@RequestParam(value = "userdest", required = false) String userdest) {
		if (StringUtils.isEmpty(commtype)) {
			return error("评论类型参数commtype不能为空");
		} else if (StringUtils.isEmpty(textid)) {
			return error("需要回复或评论的内容ID不能为空");
		} else if (StringUtils.isEmpty(content)) {
			return error("评论的内容不能为空");
		} else if ("1".equals(commtype) && StringUtils.isEmpty(userdest)) {
			return error("回复对象不能为空");
		} else if (StringUtils.isEmpty(usersrc)) {
			return error("评论人或回复人ID不能为空");
		} else {
			if ("0".equals(commtype)) {
				// 评论信息
				plService.addPl(textid, usersrc, content);
				redisService.addListValue(userdest, usersrc, content, "0", "0");
			} else if ("1".equals(commtype)) {
				plService.addReply(textid, usersrc, userdest, content);
				redisService.addListValue(userdest, usersrc, content, "1", "0");
			}
			return success("评论/回复处理成功");
		}
	}

	@RequestMapping(value = "/claim")
	@ResponseBody
	public Object claim(
			@RequestParam(value = "zantype", required = false) String zantype,
			@RequestParam(value = "textid", required = false) String textid,
			@RequestParam(value = "usersrc", required = false) String usersrc) {
		if (StringUtils.isEmpty(zantype)) {
			return error("评论类型字段不能为空");
		} else if (StringUtils.isEmpty(textid)) {
			return error("评论对应的消息ID不能为空");
		} else if (StringUtils.isEmpty(usersrc)) {
			return error("评论人/回复人不能为空");
		} else {
			ContentView contentView = contentService.findContentDetails(textid);
			if ("0".equals(zantype)) {
				// 点赞
				zanService.addZan(textid, usersrc);
				redisService.addListValue(contentView.getPubuserid(), usersrc, "", "2", "0");
				return success("点赞处理成功");
			} else if ("1".equals(zantype)) {
				// 取消赞
				zanService.cancleZan(textid, usersrc);
				redisService.addListValue(contentView.getPubuserid(), usersrc, "", "2", "1");
				return success("取消赞处理成功");
			} else {
				return error("提交的类型参数不正确:" + zantype);
			}

		}
	}

	@RequestMapping(value = "/news")
	@ResponseBody
	public Object news(
			@RequestParam(value = "userid", required = false) String userid) {
		if (StringUtils.isEmpty(userid)) {
			return error("传入的用户ID不能为空");
		} else {
			List<NewsView> newsViewList = redisService.findNewsViewList(userid);
			if (newsViewList == null || newsViewList.size() < 1) {
				return error("0");
			} else {
				// 修改时间
				for (NewsView newsView : newsViewList) {
					newsView.setNewtime(TimeUtils.formatTime(new Date(Long
							.valueOf(newsView.getNewtime()))));
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("newnum", newsViewList.size());
				map.put("newlist", newsViewList);
				return map;
			}
		}
	}

	@RequestMapping(value = "/privilege")
	@ResponseBody
	public Object privilege(
			@RequestParam(value = "usersrc", required = false) String usersrc,
			@RequestParam(value = "userdest", required = false) String userdest,
			@RequestParam(value = "pritype", required = false) String pritype,
			@RequestParam(value = "privalue", required = false) String privalue) {
		if (StringUtils.isEmpty(usersrc) || StringUtils.isEmpty(userdest)
				|| StringUtils.isEmpty(pritype)
				|| StringUtils.isEmpty(privalue)) {
			return error("传入参数不正确");
		} else if (!"0".equals(privalue) && !"1".equals(privalue)) {
			return error("传入的privalue值错误");
		} else if (!"0".equals(pritype) && !"1".equals(pritype)) {
			return error("传入的pritype值错误");
		} else {
			// pritype 0 不看对方朋友圈 1不让对方看自己的朋友圈
			int value = 0;
			if ("0".equals(pritype)) {
				value = privilegeService.proOthersList(usersrc, userdest,
						privalue);
			} else {
				value = privilegeService.proSelfToOthers(usersrc, userdest,
						privalue);
			}
			redisService.updatePrivilege(usersrc, userdest, pritype, privalue);
			if (PrivilegeService.NOTFOUND == value) {
				return error("当前用户与朋友没有朋友关系");
			} else if (PrivilegeService.MORERELATION == value) {
				return error("当前用户与朋友的关联关系大于1");
			} else {
				return success("处理成功");
			}
		}
	}

	@RequestMapping(value = "/relation")
	@ResponseBody
	public Object relation(
			@RequestParam(value = "usersrc", required = false) String usersrc,
			@RequestParam(value = "userdest", required = false) String userdest,
			@RequestParam(value = "relvalue", required = false) String relvalue) {
		if (StringUtils.isEmpty(usersrc) || StringUtils.isEmpty(userdest)
				|| StringUtils.isEmpty(relvalue)) {
			return error("传入参数不正确");
		} else if (!"0".equals(relvalue) && !"1".equals(relvalue)) {
			return error("传入的relvalue值错误");
		} else {
			// 0 取消朋友关系 1确认朋友关系
			int value = privilegeService.relationDeal(usersrc, userdest,
					relvalue);
			redisService.updateRelation(usersrc, userdest, relvalue);
			if (value == ArchState.SUCCESS.getState()) {
				return success("处理成功");
			} else {
				return error("关联失败");
			}
		}
	}

	/**
	 * 分享内容链接
	 * 
	 * @param usersrc
	 * @param userdest
	 * @param relvalue
	 * @return
	 */
	@RequestMapping(value = "/share")
	@ResponseBody
	public Object share(
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "url", required = false) String url,
			@RequestParam(value = "userid", required = false) String userid) {
		if (StringUtils.isEmpty(title) || StringUtils.isEmpty(userid)
				|| StringUtils.isEmpty(url)) {
			return error("传入参数不正确");
		} else {
			contentService.pubSharedUrl(title, url, userid);
			redisService.addNews(userid);
			return success("分享链接发布成功");
		}
	}
	
	/**
	 * 小红点,判断是否有更新的消息
	 * @param userid	当前用户ID
	 * @return			是否有新的消息
	 */
	@RequestMapping(value = "/isnews")
	@ResponseBody
	public Object isnews(
			@RequestParam(value = "userid", required = false) String userid) {
		boolean result = redisService.isNews(userid);
		if (result){
			return success("当前用户有新消息");
		} else {
			return error("当前用户无新消息");
		}
	}

}
