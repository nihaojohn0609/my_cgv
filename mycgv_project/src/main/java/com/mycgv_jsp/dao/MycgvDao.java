package com.mycgv_jsp.dao;

import java.util.ArrayList;
import java.util.List;

import com.mycgv_jsp.vo.BoardVo;

public interface MycgvDao {
	int insert(Object obj);
	List<Object> select(int startCount, int endCount);

}
