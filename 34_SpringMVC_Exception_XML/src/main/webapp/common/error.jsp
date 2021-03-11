<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 화면</title>
<style>
	#container {width: 700px; margin: 0 auto; }
	h2, p {text-align: center; }
	.orange {background-color: orange; }
</style>
</head>
<body>

<div id="container">
	<h2>기본 에러 화면(error.jsp)</h2>
	<hr>
	<p class="orange">Message : ${exception.message }</p>
</div>

</body>
</html>