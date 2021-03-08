<%@page import="com.spring.biz.board.impl.BoardDAO"%>
<%@page import="com.spring.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 값(seq) 사용 DB데이터 조회하고 화면 표시 --%>
<%
	//1. 전달받은 데이터 추출(확인)
	String seq = request.getParameter("seq");

	//2. DB 연동 처리(글 하나 조회)
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	BoardVO board = boardDAO.getBoard(vo);
	//3. 조회 데이터 화면 표시
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<style>
   #container {width: 700px; margin: 0 auto;}
   h1,h3,td,p {text-align: center;}
   table {border-collapse: collapse;}
   table, th, td {
      border: 1px solid black;
      margin: 0 auto;
   }
   th {background-color: orange;}
   .center { text-align: center; }
   .border-none { border: none; }
   
</style>
</head>
<body>

<div id="container">
	<h1>글상세</h1>
	<p><a href="logout_proc.jsp">Log-out</a></p>
	<hr>
	
	<form action="updateBoard_proc.jsp" method="post">
		<input type="hidden" name="seq" value="<%=board.getSeq() %>">
	<table>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="title" size="30" value="<%=board.getTitle() %>">
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="writer" value="<%=board.getWriter() %>">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" rows="10" cols="40"><%=board.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="center">
				<input type="submit" value="글 수정">
			</td>
		</tr>
	</table>
	</form>
	
	<p>
		<a href="insertBoard.jsp">등록</a>
		<a href="deleteBoard_proc.jsp?seq=<%=board.getSeq() %>">삭제</a>
		<a href="getBoardList.jsp">글 목록 가기</a>
	</p>
</div>

</body>
</html>
















