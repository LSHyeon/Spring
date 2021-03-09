package com.spring.biz.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardDAO boardDAO, ModelAndView mav) {
		System.out.println(">> 게시글 전체 목록 - getBoardList()");
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		mav.addObject("boardList", boardList); // 뷰에서 사용할 게시글 목록 조회한 데이터 저장
		mav.setViewName("getBoardList.jsp");
		
		return mav;
	}
}
