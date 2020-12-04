package com.atguigu.scw.uiweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	/**
	 * 解决首页登录不走/index路径的问题
	 * @return
	 */
	@RequestMapping("/")
	public String homePage() {
		log.debug("开始登录来到首页");
		return "redirect:/index";
	}
}
