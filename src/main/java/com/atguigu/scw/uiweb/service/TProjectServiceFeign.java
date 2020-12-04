package com.atguigu.scw.uiweb.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.atguigu.scw.uiweb.service.exp.handler.TProjectServiceFeignExceptionHandler;
import com.atguigu.scw.uiweb.vo.resp.ProjectDetailVo;
import com.atguigu.scw.uiweb.vo.resp.ProjectVo;
import com.atguigu.scw.uiweb.vo.resp.ReturnPayConfirmVo;
import com.atguigu.scw.vo.resp.AppResponse;

@FeignClient(value = "SCW-PROJECT", fallback = TProjectServiceFeignExceptionHandler.class)
public interface TProjectServiceFeign {
	@GetMapping("/project/all")
	public AppResponse<List<ProjectVo>> all();

	@GetMapping("/project/details/info/{projectId}")
	public AppResponse<ProjectDetailVo> detailsInfo(@PathVariable("projectId") Integer projectId);

	@GetMapping("/project/confim/returns/{projectId}/{returnId}")
	public AppResponse<ReturnPayConfirmVo> returnInfo(@PathVariable("projectId") Integer projectId,
			@PathVariable("returnId") Integer returnId);
}
