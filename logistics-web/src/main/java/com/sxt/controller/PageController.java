package com.sxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	/**
	 * 根目录就跳转login.jsp页面
	 * @return
	 */
	
	@RequestMapping("/")
	public String  showMain() {
		return "/";
	}
	
}
