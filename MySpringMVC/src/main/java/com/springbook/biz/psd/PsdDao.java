package com.springbook.biz.psd;

import java.util.List;

public interface PsdDao {
	   List<PsdVo> select(PsdVo vo);
	   void  insert(PsdVo vo);
	   PsdVo content(PsdVo vo);
	   void  delete(PsdVo vo);
	   void  updateFile(PsdVo vo);
	   void  update(PsdVo vo);
	   PsdVo totalCount(PsdVo vo);
}
