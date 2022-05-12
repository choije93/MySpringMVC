package com.springbook.biz.psd;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PsdDaoImpl implements PsdDao {
   
	@Autowired
	private SqlSessionTemplate  mybatis;

	@Override
	public List<PsdVo> select(PsdVo vo) {
		return mybatis.selectList("psd-mapping.PSDSELECT", vo);
	}

	@Override
	public void insert(PsdVo vo) {
		mybatis.insert("psd-mapping.PSDINSERT", vo);
	}
	
	@Override
	public PsdVo content(PsdVo vo) {
		return mybatis.selectOne("psd-mapping.PSDCONTENT", vo);
	}

	@Override
	public void delete(PsdVo vo) {		
		mybatis.delete("psd-mapping.PSDDELETE", vo);
	}

	@Override
	public void updateFile(PsdVo vo) {
		mybatis.update("psd-mapping.PSDUPDATEFILE", vo);
		
	}

	@Override
	public void update(PsdVo vo) {
		mybatis.update("psd-mapping.PSDUPDATE", vo);
		
	}

	@Override
	public PsdVo totalCount(PsdVo vo) {
		return mybatis.selectOne("psd-mapping.TOTALCOUNT", vo);
	}
	
}
	
	
