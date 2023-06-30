package com.mycgv_jsp.service;

import java.util.ArrayList;

import com.mycgv_jsp.vo.BoardVo;

public interface BoardService {
	
	int getInsert(BoardVo boardVo);
	ArrayList<BoardVo> getSelect(int startCount, int endCount);
	BoardVo getSelect(String bid);
	int getUpdate(BoardVo boardVo);
	int getDelete(String bid);
	void getUpdateHits(String bid);
	
}
