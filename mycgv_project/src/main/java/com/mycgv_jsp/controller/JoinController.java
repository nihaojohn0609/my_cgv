package com.mycgv_jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycgv_jsp.service.MemberService;
import com.mycgv_jsp.service.MemberServiceImpl;
import com.mycgv_jsp.vo.MemberVo;

@Controller
public class JoinController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * id_check.do - 아이디 중복체크 처리
	 */
	@RequestMapping(value="/id_check.do", method=RequestMethod.GET)
	@ResponseBody
	public String id_check(String id) {
		return memberService.getIdCheckResult(id);
	}
	
	
	/**
	 * join_proc.do - 회원가입 처리
	 */
	@RequestMapping(value="/join_proc.do", method=RequestMethod.POST)
	public ModelAndView join_proc(MemberVo memberVo) {
		ModelAndView model = new ModelAndView();		
		int result = memberService.getJoinResult(memberVo);
		
		if(result == 1) {
			model.addObject("join_result", "ok");
			model.setViewName("/login/login");
		}else {
			//회원가입 실패 - 에러페이지 호출
		}
		
		return model;
	}
	
	
	/**
	 * join.do - 회원가입 폼
	 */
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String login() {
		return "/join/join";
	}
}
