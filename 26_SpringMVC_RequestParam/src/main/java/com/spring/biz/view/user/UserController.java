package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
public class UserController {
	
		//@RequestMapping("/login.do") // GET, POST 모두 처리
		//RequestMethod.POST : POST 방식일때만 처리
		@RequestMapping(value = "/login.do", method = RequestMethod.POST)
		public String login(UserVO vo, UserDAO userDAO) {
			System.out.println(">> 로그인 처리 - login()");
			System.out.println("전달받은 vo : " + vo);
			System.out.println("전달받은 userDAO : " + userDAO);
			
			UserVO user = userDAO.getUser(vo);
			if (user != null) {
				System.out.println("로그인 성공");
				return "getBoardList.do";
			} else {
				System.out.println("로그인 실패");
				return "login.jsp";
			}
		}
		
		/* @ModelAttribute : 모델(Model) 속성값으로 저장(속성명 별도 지정)
		 * 	별도 지정 명칭 부여 안하면 <데이터 타입>의 첫글자 소문자로 작성된 명칭 사용
		 * 	Command 객체가 기본 request 스코프에 저장되어 사용됨
		 */
		
		//RequestMethod.GET : GET 방식일때만 처리
		@RequestMapping(value = "/login.do", method = RequestMethod.GET)
		//public String loginView(UserVO vo) { // 뷰에서 사용할 명칭 userVO 데이터 저장
		public String loginView(@ModelAttribute("user") UserVO vo) { // Model 속성명 user 데이터 저장
			System.out.println(">> 로그인 페이지 이동 - loginView()");
			vo.setId("test");
			vo.setPassword("test");
			
			return "login.jsp";
		}
	
		@RequestMapping("/logout.do")
		public String logout(HttpSession session) {
			System.out.println(">> 로그아웃 처리 - logout()");
			//1.세션 초기화(세션 객체 종료)
			session.invalidate();
			
			return "login.jsp";
		}
	
}
