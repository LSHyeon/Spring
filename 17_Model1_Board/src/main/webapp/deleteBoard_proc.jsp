<%@page import="com.spring.biz.board.impl.BoardDAO"%>
<%@page import="com.spring.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터(파라미터) 값으로 DB데이터 삭제하고 페이지 이동(목록) --%>
<%
	//1. 전달받은 파라미터 값 추출(확인)
	request.setCharacterEncoding("UTF-8");
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	//2. 업무처리 - DB 연동작업(게시글 삭제)
	BoardVO vo = new BoardVO();
	vo.setSeq(seq);

	BoardDAO boardDao = new BoardDAO();
	boardDao.deleteBoard(vo);
	
	//3. 화면 네이게이션(목록 페이지로 이동)
	response.sendRedirect("getBoardList.jsp");
%>