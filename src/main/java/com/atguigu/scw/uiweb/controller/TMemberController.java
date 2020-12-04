package com.atguigu.scw.uiweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class TMemberController {

	@RequestMapping("/member/minecrowdfunding")
	public String orderList() {
		
		log.debug("支付宝支付完成后，同步通知结果....");
		return "member/minecrowdfunding";
	}
}
