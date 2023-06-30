package com.mycgv_jsp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv_jsp.vo.MemberVo;
import com.mycgv_jsp.vo.SessionVo;

@Repository
public class MemberDao implements MycgvDao{ //implements MycgvDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;		
		
	/**
	 * select - 회원리스트
	 */
	@Override
	public List<Object> select(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList("mapper.member.list",param);
	}
		
	
	/**
	 * loginCheck - 로그인 체크
	 */
	public SessionVo loginCheck(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.login", memberVo);
	}
		
	
	/**
	 * idCheck - 아이디 중복체크
	 */
	public int idCheck(String id) {
		return sqlSession.selectOne("mapper.member.idcheck", id);
	}
	
	/**
	 * insert - 회원가입
	 */
	//@Override
	public int insert(Object memberVo) {
		return sqlSession.insert("mapper.member.join", memberVo);
	}
}











