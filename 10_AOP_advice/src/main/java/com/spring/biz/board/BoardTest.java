package com.spring.biz.board;

import java.util.List;

import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {
	
	public static void main(String[] args) {
		
		// insert
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트");
		vo.setWriter("테스터");
		vo.setContent("테스트중");
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
		
		// update
		BoardVO vo2 = new BoardVO(); 
		vo2.setTitle("테스트11");
		vo2.setContent("수정 테스트중");
		vo2.setSeq(7);
		
		dao.updateBoard(vo2);
		
		// delete
		BoardVO vo3 = new BoardVO(); 
		vo3.setSeq(4);
		dao.deleteBoard(vo);
		
		// selectOne
		vo.setSeq(1);
		BoardVO board = dao.getBoard(vo);
		System.out.println("board : " + board);
		
		// selectList
		List<BoardVO> list = dao.getBoardList();
		for (BoardVO board2 : list) {
			System.out.println("board2 : " + board2);
		}
	}
}
