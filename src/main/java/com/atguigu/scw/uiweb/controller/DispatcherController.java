package com.atguigu.scw.uiweb.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.scw.uiweb.service.TMenberServiceFeign;
import com.atguigu.scw.uiweb.service.TProjectServiceFeign;
import com.atguigu.scw.uiweb.vo.resp.ProjectVo;
import com.atguigu.scw.uiweb.vo.resp.UserRespVo;
import com.atguigu.scw.vo.resp.AppResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DispatcherController {

	@Autowired
	TMenberServiceFeign menberServiceFeign;

	@Autowired
	TProjectServiceFeign projectServiceFeign;

	@Resource
	RedisTemplate<String, List<ProjectVo>> redisTemplate;

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		if (session != null) {
			session.removeAttribute("LoginMenber");
			session.invalidate();
		}

		return "redirect:/index";
	}

	@RequestMapping("/doLogin")
	public String doLogin(String loginacct, String userpswd, HttpSession session) {

		AppResponse<UserRespVo> login = menberServiceFeign.login(loginacct, userpswd);

		UserRespVo data = login.getData();

		log.debug("项目列表是={}", data);

		if (data == null) {
			return "login";
		}

		session.setAttribute("LoginMenber", data);

		String preUrl = (String) session.getAttribute("prefix");

		if (StringUtils.isEmpty(preUrl)) {
			return "redirect:/index";
		} else {
			return "redirect:"+preUrl;
		}
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/index")
	public String index(Model model) {

		List<ProjectVo> data = (List<ProjectVo>) redisTemplate.opsForValue().get("projectinfo");

		if (data == null) {
			AppResponse<List<ProjectVo>> resp = projectServiceFeign.all();
			data = resp.getData();
			redisTemplate.opsForValue().set("projectinfo", data, 1, TimeUnit.HOURS);
		}

		model.addAttribute("projectVoinfo", data);

		return "index";
	}
}
