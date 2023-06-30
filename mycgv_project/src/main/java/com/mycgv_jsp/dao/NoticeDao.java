package com.mycgv_jsp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv_jsp.vo.NoticeVo;

@Repository
public class NoticeDao implements MycgvDao{ //implements MycgvDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * updateHits - 공지사항 조회수 업데이트
	 */
	public void updateHits(String nid) {
		sqlSession.update("mapper.notice.updateHits", nid);		
	}
	
	/**
	 * delete - 공지사항 삭제처리
	 */
	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);		
	}
	
	/**
	 * update - 공지사항 수정처리
	 */
	public int update(NoticeVo noticeVo) {
		return sqlSession.update("mapper.notice.update", noticeVo);		
	}
	
	/**
	 * select(String nid) - 공지사항 상세보기
	 */
	public NoticeVo select(String nid){
		return sqlSession.selectOne("mapper.notice.content", nid);		
	}
	
	
	/**
	 * select - 공지사항 전체 리스트
	 */
	public ArrayList<NoticeVo> select(){
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list2");		
		return (ArrayList<NoticeVo>)list;		
	}
	
	/**
	 * select - 공지사항 전체 리스트(페이징 처리)
	 */
	@Override
	public List<Object> select(int startCount, int endCount){
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.notice.list", param);		
	}
	
	/**
	 * insert - 공지사항 등록
	 */
	//@Override
	public int insert(Object noticeVo) {
		return sqlSession.insert("mapper.notice.insert", noticeVo);		
	}
}







