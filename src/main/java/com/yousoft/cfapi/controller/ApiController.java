package com.yousoft.cfapi.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yousoft.cfapi.entity.model.ContentView;
import com.yousoft.cfapi.entity.model.FriendPageView;
import com.yousoft.cfapi.service.ContentService;
import com.yousoft.cfapi.service.PlService;

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
			contentService.pubContent(content, photolist, userid);
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
			} else if ("1".equals(commtype)) {
				plService.addReply(textid, usersrc, userdest, content);
			}
			return success("评论/回复处理成功");
		}
	}

	@RequestMapping(value = "/claim")
	@ResponseBody
	public Object claim(
			@RequestParam(value = "zantype", required = false) String zantype,
			@RequestParam(value = "textid", required = false) String textid,
			@RequestParam(value = "usersrc", required = false) String usersrc,
			@RequestParam(value = "userdest", required = false) String userdest) {
		return null;
	}

}
