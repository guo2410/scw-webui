package com.atguigu.scw.uiweb.vo.resp;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ToString
@ApiModel
@Data
public class UserRespVo implements Serializable{
	
	@ApiModelProperty("访问令牌，请妥善保管，以后每次请求都要带上")
	private String accessToken;

	private String loginacct;

	private String username;

	private String email;

	private String authstatus = "0";

	private String usertype;

	private String realname;

	private String cardnum;

	private String accttype;
}
