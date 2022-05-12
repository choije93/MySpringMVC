package com.springbook.biz.psd;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PsdVo {
	  private int pcode;
	  private String title;
	  private String pname;  
	  private int price;
	  private int quantity;
	  private int shipping;
	  
	  // 실제 이미지 파일 
	  private MultipartFile   imgFile; 	 
	  // 테이블 이미지 이름
	  private String img;
	  private String imgtype;
	  private int imgsize;
	  private Date rdate;
	  
	  // 검색추가 
	  private String ch1; 
	  private String ch2;
	  
	  
	  //페이징
	  private int startIdx;
	  private int endIdx;
	  private int rownum;
	  private int rnum;
	  
	  private int B1;
	  
}
