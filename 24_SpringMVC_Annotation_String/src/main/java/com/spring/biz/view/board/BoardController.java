package com.spring.biz.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDAO boardDAO, BoardVO vo, Model model) {
		System.out.println("게시글 상세 보기 - String getBoard()");
		BoardVO board = boardDAO.getBoard(vo);
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDAO boardDAO, Model model) {
		System.out.println(">> 게시글 전체 목록 - String getBoardList()");
		List<BoardVO> boardList = boardDAO.getBoardList();
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">> 게시글 입력 - insertBoard()");
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardDAO boardDAO, BoardVO vo) {
		System.out.println(">> 게시글 수정 - updateBoard()");
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">> 게시글 삭제 - deleteBoard()");
		boardDAO.deleteBoard(vo);
		
		return "getBoardList.do";
	}
}

















