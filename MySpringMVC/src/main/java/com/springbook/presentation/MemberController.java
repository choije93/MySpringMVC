package com.springbook.presentation;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVo;





@Controller
public class MemberController {
	
	@Autowired
	private MemberService  service;

	@RequestMapping("/member_list.do")
	String member_list(MemberVo  vo, Model model) throws Exception {
	
		model.addAttribute("li", service.list(vo));
		return "/member/member_list.jsp";	
		
	}
	
	
	@RequestMapping("/idCk.do")
	void idCk(MemberVo  vo, HttpServletResponse response) throws Exception {

		PrintWriter out = response.getWriter();					
		String m = service.idCk(vo);
		
		if (m.equals("F")) {
			out.println(1); // 아이디 중복
		}else {
			out.println(0); // 입력가능 ID
		}
	}
	
	@RequestMapping("/member_form.do")
	 String form() {
		return "/member/member_form.jsp";		 
	 }
	
	@RequestMapping("/member_form1.do")
	 String form1() {
		return "/member/member_form1.jsp";		 
	 }
	
	
	@RequestMapping("/member_formOK.do")
	String psd_formOK(MemberVo  vo, HttpServletRequest request) throws Exception {
		
		service.insert(vo);
		
		return "member_list.do";	
		
	}

	
	@RequestMapping("/member_formOK1.do")
	String psd_formOK1(MemberVo  vo, HttpServletRequest request) throws Exception {
		
		service.insert(vo);
		
		return "index.jsp";	
		
	}
	
	
    @RequestMapping("/login_formOK.do")
	void login_formOK(MemberVo  vo, HttpServletResponse response, 
			          HttpServletRequest request )  throws Exception {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();					
		String m = service.loginCk(vo);
		
		if (m.equals("F")) {
			
			out.println(0); // 로그인 실패						
		}else {
			session.setAttribute("session", m);
			System.out.println("m 확인" +  m);
			out.println(1); // 로그인 성공
		}
	}
	
	@RequestMapping("/logout.do")
	String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();	
		session.invalidate();
		return "index.jsp";	
		
	}
	
	
		
		
}
