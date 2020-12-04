package com.atguigu.scw.uiweb.service.exp.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.scw.uiweb.service.TMenberServiceFeign;
import com.atguigu.scw.uiweb.vo.resp.UserAddressVo;
import com.atguigu.scw.uiweb.vo.resp.UserRespVo;
import com.atguigu.scw.vo.resp.AppResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TMenberServiceFeignExceptionHandler implements TMenberServiceFeign {

	@Override
	public AppResponse<UserRespVo> login(String loginacct, String password) {
		AppResponse<UserRespVo> resp = AppResponse.fail(null);
		resp.setMsg("调用远程服务【登录】失败");
		
		log.error("调用远程服务失败");
		return resp;
	}

	@Override
	public AppResponse<List<UserAddressVo>> address(String accessToken) {
		AppResponse<List<UserAddressVo>> resp = AppResponse.fail(null);
		resp.setMsg("调用远程服务【根据用户查询地址】失败");
		
		log.error("调用远程服务失败");
		return resp;
	}

}
