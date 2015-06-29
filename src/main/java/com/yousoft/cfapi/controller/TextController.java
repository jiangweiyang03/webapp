package com.yousoft.cfapi.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class TextController extends AbstractArchController {
	
	@RequestMapping("/text")
	@ResponseBody
	public Object text() {
		return success("测试成功");
	}
	
}