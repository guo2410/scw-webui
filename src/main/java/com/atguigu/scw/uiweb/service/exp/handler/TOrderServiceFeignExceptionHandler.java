package com.atguigu.scw.uiweb.service.exp.handler;

import org.springframework.stereotype.Component;

import com.atguigu.scw.uiweb.service.TOrderServiceFeign;
import com.atguigu.scw.uiweb.vo.req.OrderInfoSubmitVo;
import com.atguigu.scw.uiweb.vo.req.TOrder;
import com.atguigu.scw.vo.resp.AppResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TOrderServiceFeignExceptionHandler implements TOrderServiceFeign {

	@Override
	public AppResponse<TOrder> saveOrder(OrderInfoSubmitVo vo) {
		AppResponse resp  = AppResponse.fail(null);
		resp.setMsg("远程调用【保存订单】失败");
		log.error("远程调用【保存订单】失败");
		return resp;
	}

}
