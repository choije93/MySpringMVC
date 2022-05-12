package com.springbook.presentation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import com.springbook.biz.psd.PsdService;
import com.springbook.biz.psd.PsdVo;

@Controller
public class PsdController {

	@Autowired
	private PsdService  service;

			
	@RequestMapping("/psd_list.do")
	String psd_list(Model  model, PsdVo vo) {
					
		if (vo.getStartIdx() == 0) {
			vo.setStartIdx(1);
		}else {
			vo.setStartIdx(vo.getStartIdx());	
		}
		
		PsdVo k=service.totalCount(vo);
		int  totalPage = (int) Math.ceil(k.getB1()/4.0); 
		int  nowPage = (vo.getStartIdx() / 4)+ 1 ;
		int  endPage = (totalPage - 1) * 4 + 1 ;
		
		model.addAttribute("B1" , k.getB1() );
		
		model.addAttribute("startIdx",vo.getStartIdx() );
		model.addAttribute("totalPage",totalPage );
		model.addAttribute("nowPage",nowPage );
		model.addAttribute("endPage",endPage );

		//채널선택(검색)
		model.addAttribute("ch1",vo.getCh1() );
		model.addAttribute("ch2",vo.getCh2() );
		
		model.addAttribute("li", 	service.select(vo));
		return "/psd/psd_list.jsp";	
	}
	
	
	
	
	@RequestMapping("/psd_form.do")
	String psdForm() {
		return "/psd/psd_form.jsp";		
	} 
		
	long time = System.currentTimeMillis();
	SimpleDateFormat dayTime=new SimpleDateFormat("HHmmss");
	String  timeStr = dayTime.format(time);	
	Date now = new Date();
	String onlyFilename ="";
	String extension="";
	
	
	@RequestMapping("/psd_formOK.do")
	String psd_formOK(PsdVo  vo, HttpServletRequest request) throws Exception {
		
	    String	path=request.getSession().getServletContext().getRealPath("/psd/files/");
	    System.out.println("===>path:" + path);
		
		MultipartFile  imgUpdateFile = vo.getImgFile();
		String fileNmae =imgUpdateFile.getOriginalFilename();
		File  f = new File(path+fileNmae);

		if(!imgUpdateFile.isEmpty()) {
		  if(f.exists()) {
			  onlyFilename=fileNmae.substring(0, fileNmae.indexOf("."));
			  extension=fileNmae.substring(fileNmae.indexOf("."));
			  fileNmae =  onlyFilename + "_" + timeStr + extension ;
			  
			  imgUpdateFile.transferTo(new File(path+fileNmae));
			  
		  }else{
			  imgUpdateFile.transferTo(new File(path+fileNmae));
			  System.out.println("fileNmae:" + fileNmae);
		  }	
		  
		}		
		vo.setImgsize(fileNmae.length());
		vo.setImgtype(extension);
		vo.setRdate(now);
		
		vo.setImg(fileNmae);
		service.insert(vo);
		
		return "psd_list.do";		
	}
	
	
	@RequestMapping("/psd_content.do")
	String psd_content(Model  model, PsdVo vo) {
		model.addAttribute("m", service.content(vo));
		return "/psd/psd_content.jsp";	
	}
		
	
	@RequestMapping("/psd_delete.do")
	String psd_delete(PsdVo vo , HttpServletRequest request) {

		// 1. �궘�젣�븷 �뙆�씪 李얘린 �� �뙆�씪�궘�젣 
		PsdVo img = service.content(vo);
		
	    String	path=request.getSession().getServletContext().getRealPath("/psd/files/");

	    File f = new  File(path + img.getImg() ) ;
		if (f.exists()) {
	      f.delete();  // �뙆�씪�씠 議댁옱�븯硫� �궘�젣�븯�떆�삤.
		}
		
		// 2. �젅肄붾뱶 �궘�젣 
		service.delete(vo);
		
		return "psd_list.do";	
	}
	
	@RequestMapping("/psd_UpdateOK.do")
	String psd_UpdateOK(PsdVo  vo, HttpServletRequest request) throws Exception {
		
	    String	path=request.getSession().getServletContext().getRealPath("/psd/files/");
			
		MultipartFile  imgUpdateFile = vo.getImgFile();
		String fileNmae =imgUpdateFile.getOriginalFilename();
		File  f = new File(path+fileNmae);

		if(!imgUpdateFile.isEmpty()) {
			
			PsdVo img = service.content(vo);				
		    File fDel = new  File(path + img.getImg() ) ;
			if (fDel.exists()) {
				fDel.delete();  // �뙆�씪�씠 議댁옱�븯硫� �궘�젣�븯�떆�삤.
			}
			
		  if(f.exists()) {
			// 以묐났 �뙆�씪�씠 議댁옱�븯硫� 
			  System.out.println("�룞�씪�븳 �뙆�씪 議댁옱�븯�뒗 寃쎌슦");
			  onlyFilename=fileNmae.substring(0, fileNmae.indexOf("."));
			  extension=fileNmae.substring(fileNmae.indexOf("."));
			  fileNmae =  onlyFilename + "_" + timeStr + extension ;				  
			  imgUpdateFile.transferTo(new File(path+fileNmae));
			  
		  }else{
			  
			  imgUpdateFile.transferTo(new File(path+fileNmae));
			  
		  }	

			vo.setImgsize(fileNmae.length());
			vo.setImgtype(extension);
			vo.setRdate(now);			
			vo.setImg(fileNmae);				
			service.updateFile(vo);
			System.out.println("==> updateFile : " + vo);
			
		} else {		
			
			service.update(vo);
			System.out.println("==> update: " + vo);
			
		}	
		
		return "psd_list.do";		
	}
	
	
}
	