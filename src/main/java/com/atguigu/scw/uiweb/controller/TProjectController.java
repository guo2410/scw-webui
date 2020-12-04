package com.atguigu.scw.uiweb.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.scw.uiweb.service.TMenberServiceFeign;
import com.atguigu.scw.uiweb.service.TProjectServiceFeign;
import com.atguigu.scw.uiweb.vo.resp.ProjectDetailVo;
import com.atguigu.scw.uiweb.vo.resp.ReturnPayConfirmVo;
import com.atguigu.scw.uiweb.vo.resp.UserAddressVo;
import com.atguigu.scw.uiweb.vo.resp.UserRespVo;
import com.atguigu.scw.vo.resp.AppResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TProjectController {

	@Autowired
	TProjectServiceFeign projectServiceFeign;
	
	@Autowired
	TMenberServiceFeign menberServiceFeign;
	
	@RequestMapping("/project/confirm/order/{num}")
	public String confirmOrder(@PathVariable("num")Integer num,Model model,HttpSession session) {
		
		UserRespVo data = (UserRespVo) session.getAttribute("LoginMenber");
		
		if(data == null) {
			
			session.setAttribute("prefix", "/project/confirm/order/"+num);
			
			return "redirect:/login";
		}
		
		String accessToken = data.getAccessToken();
		
		AppResponse<List<UserAddressVo>> addressList = menberServiceFeign.address(accessToken);
		
		List<UserAddressVo> list = addressList.getData();
		
		model.addAttribute("addressList", list);
		
		ReturnPayConfirmVo payConfirmVo= (ReturnPayConfirmVo) session.getAttribute("returnPayConfirmVoSession");
		
		payConfirmVo.setNum(num);
		payConfirmVo.setTotalPrice(new BigDecimal(num * payConfirmVo.getPrice()+payConfirmVo.getFreight()));
		
		session.setAttribute("returnPayConfirmVoSession", payConfirmVo);
		
		return "project/pay-step-2";
	}
	
	@RequestMapping("/project/support/{projectId}/{returnId}")
	public String support(@PathVariable("projectId") Integer projectId,
						@PathVariable("returnId") Integer returnId,Model model,HttpSession session) {
		AppResponse<ReturnPayConfirmVo> returnInfo = projectServiceFeign.returnInfo(projectId, returnId);
		ReturnPayConfirmVo payConfirmVo = returnInfo.getData();
		model.addAttribute("returnPayConfirmVo", payConfirmVo);
		session.setAttribute("returnPayConfirmVoSession", payConfirmVo);
		return "project/pay-step-1";
	}
	
	
	@RequestMapping("/project/projectInfo")
	public String projectInfo(Integer id,Model model){
		
		AppResponse<ProjectDetailVo> detailsInfo = projectServiceFeign.detailsInfo(id);
		ProjectDetailVo vo = detailsInfo.getData();
		model.addAttribute("ProjectDetailVo", vo);
		
		return "project/index";
	}
	

}
