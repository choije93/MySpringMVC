package com.springbook.biz.psd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsdServiceImpl implements PsdService {

	@Autowired  
	private PsdDao dao;

	@Override
	public List<PsdVo> select(PsdVo vo) {
		return dao.select(vo);
	}

	@Override
	public void insert(PsdVo vo) {
		dao.insert(vo);
		
	}
	@Override
	public PsdVo content(PsdVo vo) {
		return dao.content(vo);
	}
	@Override
	public void delete(PsdVo vo) {
		dao.delete(vo);
		
	}
	
	@Override
	public void updateFile(PsdVo vo) {
		dao.updateFile(vo);
		
	}

	@Override
	public void update(PsdVo vo) {
		dao.update(vo);		
	}

	@Override
	public PsdVo totalCount(PsdVo vo) {
		return dao.totalCount(vo);
	}
	
	
}