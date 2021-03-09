package com.spring.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">> 게시글 삭제 처리");
		//1. 전달받은 파라미터 값 추출(확인)
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2. 업무처리 - DB 연동작업(게시글 삭제) 
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);

		BoardDAO boardDao = new BoardDAO();
		boardDao.deleteBoard(vo);
		
		//3. 화면 네이게이션(목록 페이지로 이동) : 데이터 다시 읽어오기
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}
