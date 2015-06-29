package com.yousoft.cfapi.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yousoft.cfapi.service.ContentService;

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

	/**
	 * 内容发布接口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pubcontent", method = RequestMethod.POST)
	@ResponseBody
	public Object pubContent(@RequestParam String content,
			@RequestParam String photolist, @RequestParam String userid) {
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

}
