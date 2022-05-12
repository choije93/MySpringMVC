package com.springbook.biz.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao  dao;
	
	@Override
	public List<MemberVo> list(MemberVo vo) {
		return dao.list(vo);

	}

	@Override
	public String idCk(MemberVo vo) {
		return dao.idCk(vo);
	}

	@Override
	public void insert(MemberVo vo) {
		dao.insert(vo);
	}

	@Override
	public String loginCk(MemberVo vo) {

		return dao.loginCk(vo);
	}

	
	

	

}
