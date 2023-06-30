package com.mycgv_jsp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv_jsp.vo.BoardVo;

@Repository
public class BoardDao implements MycgvDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
		
	/**
	 * updateHits - 조회수 증가
	 */
	public void updateHits(String bid) {
		sqlSession.update("mapper.board.updateHits", bid);		
	}
	
	/**
	 * delete - 게시글 삭제
	 */
	public int delete(String bid) {
		return sqlSession.delete("mapper.board.delete", bid);		
	}

	
	/**
	 * update - 게시글 수정
	 */
	public int update(BoardVo boardVo) {
		return sqlSession.update("mapper.board.update", boardVo);
	}	
	
	
	/**
	 * select(bid) - 게시글 상세 보기
	 */
	public BoardVo select(String bid){
		return sqlSession.selectOne("mapper.board.content", bid);
	}
	
	
	/**
	 * select - 게시글 전체 리스트
	 */
	public ArrayList<BoardVo> select(){
		List<BoardVo> list = sqlSession.selectList("mapper.board.list2");
		return (ArrayList<BoardVo>)list;
	}
	
	/**
	 * select - 게시글 전체 리스트(페이징 처리)
	 */
	@Override
	public List<Object> select(int startCount, int endCount){
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);		
		
		return sqlSession.selectList("mapper.board.list", param);
	}
	
	
	/**
	 * insert - 게시글 등록(상속)
	 */
	@Override
	public int insert(Object boardVo) {
		return sqlSession.insert("mapper.board.insert", boardVo);
	}

}









