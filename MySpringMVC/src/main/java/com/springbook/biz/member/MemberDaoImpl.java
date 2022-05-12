package com.springbook.biz.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.BCrypt;


@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSessionTemplate  mybatis;

	
	@Override
	public List<MemberVo> list(MemberVo vo) {
		return mybatis.selectList("member-mapping.MEMBERSELECT", vo);

	}


	@Override
	public String idCk(MemberVo vo) {
		
		String str ; 
		MemberVo	k = mybatis.selectOne("member-mapping.IDCK", vo);
		if (k == null) {
			str = "T" ;   // 중복이 없는 입력 가능한 값
		}else{
			str = "F" ;  // 중복된 값.
		}
		return str;
				
	}
	
	@Override
	public void insert(MemberVo vo) {
		
		// 패스워드 암호화
		vo.setPwd(BCrypt.hashpw(vo.getPwd(),BCrypt.gensalt() ));
		mybatis.insert("member-mapping.MEMBERINSERT", vo);
		
	}


	@Override
	public String loginCk(MemberVo vo) {
		
		// 패스워드 암호화 검색하기 
		
		String str ; 
		MemberVo	k = mybatis.selectOne("member-mapping.IDCK", vo);
        if ( k == null ) {
        	// 로그인 실패 
        	str = "F" ; 
          } else {        	     	
           		if (BCrypt.checkpw(vo.getPwd() ,k.getPwd())) {
    			str = vo.getId() ;   // 로그인 성공 
     		}else{
    			str = "F" ;  //  로그인 실패
    		}
    		return str;			
	
        }
		return str;	
		
	}



}
