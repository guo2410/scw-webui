package com.atguigu.scw.uiweb.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.scw.uiweb.service.exp.handler.TMenberServiceFeignExceptionHandler;
import com.atguigu.scw.uiweb.vo.resp.UserAddressVo;
import com.atguigu.scw.uiweb.vo.resp.UserRespVo;
import com.atguigu.scw.vo.resp.AppResponse;

@FeignClient(value="SCW-USER",fallback=TMenberServiceFeignExceptionHandler.class)
public interface TMenberServiceFeign {
	@PostMapping("/user/login")
	public AppResponse<UserRespVo> login(@RequestParam("loginacct")String loginacct, @RequestParam("password")String password);
	
	@GetMapping("/user/info/address")
	public AppResponse<List<UserAddressVo>> address(@RequestParam("accessToken")String accessToken);

}
