package com.spring.biz.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">> 로그아웃 처리");
		//1.세션 초기화(세션 객체 종료)
		request.getSession().invalidate();
		
		//2. 화면 네비게이션(로그인페이지)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp"); // 뷰리졸버 사용 안함
		
		return mav;
	}

}
