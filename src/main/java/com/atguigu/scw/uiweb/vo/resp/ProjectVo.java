package com.atguigu.scw.uiweb.vo.resp;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProjectVo implements Serializable {

	private static final long serialVersionUID = 1L;

//	private String projectToken;// 项目的临时token(阅读并同意协议时，后台会分配一个项目token值，用来绑定当前项目信息)	
	private Integer memberid;// 会员id

	private Integer id;

	private String name;// 项目名称
	private String remark;// 项目简介

	private String headerImage;// 项目头部图片
}
