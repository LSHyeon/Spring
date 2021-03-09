package com.spring.biz.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardDAO boardDAO, BoardVO vo, ModelAndView mav) {
		System.out.println("게시글 상세 보기 - getBoard()");
		BoardVO board = boardDAO.getBoard(vo);
		
		mav.addObject("board", board);
		// ModelAndView 상세보기 화면으로 이동
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}

}
