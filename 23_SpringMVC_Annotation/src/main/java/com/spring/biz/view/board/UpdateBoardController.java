package com.spring.biz.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController {
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardDAO boardDAO, BoardVO vo) {
		System.out.println(">> 게시글 수정 - updateBoard()");
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
}
