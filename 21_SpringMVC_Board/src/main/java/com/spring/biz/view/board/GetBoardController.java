package com.spring.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">> 게시글 상세보기 처리");
		//1. 전달받은 데이터 추출(확인)
		String seq = request.getParameter("seq");

		//2. DB 연동 처리(글 하나 조회)
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		//3. 상세보기 결과를 저장(뷰에서 사 용할 수 있게)
		ModelAndView mav = new ModelAndView();
		//mav.addObject(board); = boardVO 명칭으로 저장
		mav.addObject("board", board);
		
		//4. ModelAndView 상세보기 화면으로 이동
		mav.setViewName("getBoard.jsp"); // 뷰리졸버 사용 안함
		
		return mav;
	}

}
