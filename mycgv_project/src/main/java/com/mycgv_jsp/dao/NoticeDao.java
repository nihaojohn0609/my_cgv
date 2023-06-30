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
	 * updateHits - �������� ��ȸ�� ������Ʈ
	 */
	public void updateHits(String nid) {
		sqlSession.update("mapper.notice.updateHits", nid);		
	}
	
	/**
	 * delete - �������� ����ó��
	 */
	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);		
	}
	
	/**
	 * update - �������� ����ó��
	 */
	public int update(NoticeVo noticeVo) {
		return sqlSession.update("mapper.notice.update", noticeVo);		
	}
	
	/**
	 * select(String nid) - �������� �󼼺���
	 */
	public NoticeVo select(String nid){
		return sqlSession.selectOne("mapper.notice.content", nid);		
	}
	
	
	/**
	 * select - �������� ��ü ����Ʈ
	 */
	public ArrayList<NoticeVo> select(){
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list2");		
		return (ArrayList<NoticeVo>)list;		
	}
	
	/**
	 * select - �������� ��ü ����Ʈ(����¡ ó��)
	 */
	@Override
	public List<Object> select(int startCount, int endCount){
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.notice.list", param);		
	}
	
	/**
	 * insert - �������� ���
	 */
	//@Override
	public int insert(Object noticeVo) {
		return sqlSession.insert("mapper.notice.insert", noticeVo);		
	}
}







