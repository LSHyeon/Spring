package com.spring.biz.board;

import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {
	
	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트");
		vo.setWriter("테스터");
		vo.setContent("테스트중");
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		vo.setSeq(1);
		BoardVO board = dao.getBoard(vo);
		System.out.println("board : " + board);
	}
}
