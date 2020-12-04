package com.atguigu.scw.uiweb.service.exp.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.scw.uiweb.service.TProjectServiceFeign;
import com.atguigu.scw.uiweb.vo.resp.ProjectDetailVo;
import com.atguigu.scw.uiweb.vo.resp.ProjectVo;
import com.atguigu.scw.uiweb.vo.resp.ReturnPayConfirmVo;
import com.atguigu.scw.vo.resp.AppResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TProjectServiceFeignExceptionHandler implements TProjectServiceFeign {

	@Override
	public AppResponse<List<ProjectVo>> all() {
		AppResponse resp  = AppResponse.fail(null);
		resp.setMsg("远程调用[查询热点项目模块]失败");
		log.error("远程调用[查询热点项目模块]失败");
		return resp;
	}

	@Override
	public AppResponse<ProjectDetailVo> detailsInfo(Integer projectId) {
		AppResponse resp  = AppResponse.fail(null);
		resp.setMsg("远程调用【查询项目详情模块】失败");
		log.error("远程调用【查询项目详情模块】失败");
		return resp;
	}

	@Override
	public AppResponse<ReturnPayConfirmVo> returnInfo(Integer projectId, Integer returnId) {
		AppResponse resp = AppResponse.fail(null);
		resp.setMsg("远程调用【确认订单模块】失败");
		return resp;
	}

}
