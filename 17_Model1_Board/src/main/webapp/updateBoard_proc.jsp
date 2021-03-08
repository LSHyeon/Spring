<%@page import="com.spring.biz.board.BoardVO"%>
<%@page import="com.spring.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터(파라미터) 값으로 DB데이터 수정하고 페이지 이동(목록) --%>
<%
	//1. 전달받은 파라미터 값 추출(확인)
	request.setCharacterEncoding("UTF-8");
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
	
	//3. 화면 네이게이션(목록 페이지로 이동)
	response.sendRedirect("getBoardList.jsp");
%>
