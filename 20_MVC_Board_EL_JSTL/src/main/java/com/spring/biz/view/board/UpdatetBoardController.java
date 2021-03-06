package com.spring.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.view.controller.Controller;

public class UpdatetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">> 게시글 수정 처리");
		//1. 전달받은 파라미터 값 추출(확인)
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//2. 업무처리 - DB 연동작업(게시글 수정)
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDao = new BoardDAO();
		boardDao.updateBoard(vo);
		
		//3. 화면 네이게이션(목록 페이지로 이동) : 데이터 다시 읽어오기
		//response.sendRedirect("getBoardList.do");
		return "getBoardList.do";
	}

}
