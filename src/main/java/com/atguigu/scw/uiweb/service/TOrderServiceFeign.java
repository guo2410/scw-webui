package com.atguigu.scw.uiweb.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.scw.uiweb.service.exp.handler.TOrderServiceFeignExceptionHandler;
import com.atguigu.scw.uiweb.vo.req.OrderInfoSubmitVo;
import com.atguigu.scw.uiweb.vo.req.TOrder;
import com.atguigu.scw.vo.resp.AppResponse;

@FeignClient(value="SCW-ORDER",fallback=TOrderServiceFeignExceptionHandler.class)
public interface TOrderServiceFeign {

	@RequestMapping("/order/saveOrder")
	AppResponse<TOrder> saveOrder(@RequestBody OrderInfoSubmitVo vo);

}
