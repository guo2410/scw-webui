package com.atguigu.scw.uiweb.vo.resp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ProjectDetailVo implements Serializable{

    private Integer memberid;
	
    private Integer id;

    private String name;

    private String remark;

    private Long money;

    private Integer day;

    private String status;

    private String deploydate;

    private Long supportmoney = 0L;

    private Integer supporter = 0;

    private Integer completion = 0;

    private Integer follower = 100;
	
	private String headerImage;// 项目头部图片
	
	private List<String> detailsImage = new ArrayList<String>();// 项目详情图片

	private List<TReturn> projectReturns = new ArrayList<TReturn>();// 项目回报
}
