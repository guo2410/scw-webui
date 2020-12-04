package com.atguigu.scw.uiweb.vo.req;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderInfoSubmitVo implements Serializable { // 用于保存订单的数据
	private static final long serialVersionUID = 1L;
	private String accessToken;
	private Integer projectid;
	private Integer returnid;
	private Integer rtncount;

	private String address;
	private Byte invoice;
	private String invoictitle;
	private String remark;
}
