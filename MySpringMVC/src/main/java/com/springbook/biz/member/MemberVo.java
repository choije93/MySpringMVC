package com.springbook.biz.member;

import lombok.Data;

@Data
public class MemberVo {
	private int emp_no;
	private String  id ;
	private String  pwd  ;
	private String  name ;
	private String  tel ;
	private String  postcode;
	private String  roadAddress ;
	private String  detailAddress ;
	private String  extraAddress ;

	private String  ch1 ;
	private String  ch2 ;
}
