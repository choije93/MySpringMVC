package com.springbook.biz.member;

import java.util.List;

public interface MemberDao {

	List<MemberVo> list(MemberVo vo);
		void insert(MemberVo vo);
		String idCk(MemberVo vo);
		String loginCk(MemberVo vo);


}
