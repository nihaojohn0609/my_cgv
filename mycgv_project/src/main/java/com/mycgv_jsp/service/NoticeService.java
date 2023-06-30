package com.mycgv_jsp.service;

import java.util.ArrayList;

import com.mycgv_jsp.vo.NoticeVo;

public interface NoticeService {
	int getInsert(NoticeVo noticeVo);
	ArrayList<NoticeVo> getSelect(int startCount, int endCount);
	NoticeVo getSelect(String bid);
	int getUpdate(NoticeVo boardVo);
	int getDelete(String bid);
	void getUpdateHits(String bid);
}
